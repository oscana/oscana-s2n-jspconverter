package jp.co.tis.s2n.jspConverter.convert;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;

import jp.co.tis.s2n.converterCommon.log.LogUtils;
import jp.co.tis.s2n.converterCommon.struts.analyzer.ClassPathConvertUtil;
import jp.co.tis.s2n.converterCommon.struts.analyzer.StrutsAnalyzeResult;
import jp.co.tis.s2n.converterCommon.util.StringUtils;
import jp.co.tis.s2n.jspConverter.convert.profile.S2nProfile;
import jp.co.tis.s2n.jspConverter.convert.statistics.ScriptletStatistics;
import jp.co.tis.s2n.jspConverter.convert.statistics.TagStatistics;
import jp.co.tis.s2n.jspConverter.convert.tag.TagConvertBase;
import jp.co.tis.s2n.jspConverter.convert.tag.TagConvertBaseFactory;
import jp.co.tis.s2n.jspConverter.convert.tag.TagConvertConfig;
import jp.co.tis.s2n.jspConverter.file.S2nFileWriter;
import jp.co.tis.s2n.jspConverter.node.Node;
import jp.co.tis.s2n.jspConverter.node.NodeUtil;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;
import jp.co.tis.s2n.jspConverter.parser.JspParser;
import jp.co.tis.s2n.jspConverter.token.Token;

/**
 * S2N JspConverterの主処理。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class ConvertStruts2Nablarch extends AbstractBatchBase {

    private static final String XENLON_S2N_CONVERT_STRUTS_JSP_TAGLIB_INJECT_PARTS_VM = "templete/StrutsJSPTaglibInjectParts.vm";

    public static final String[] NESTED_TRG = { "bean", "html", "logic" };
    public static final String NESTED_TAG_KEY = "nested";

    private StrutsAnalyzeResult[] strutsAnalyzeResultList;
    private VelocityEngine velocityEngine;

    //プロファイル
    private S2nProfile activeProfile;
    private static String sp = System.getProperty("file.separator");

    /**
     * JspConverterの主処理。
     * @param args 引数
     * @throws Exception 例外
     */
    public static void main(String[] args) throws Exception {
        LogUtils.init();

     // パラメータ必須チェック
        if (args.length < 1) {
            System.err.print("usage:java -jar jspconverter.jar [設定ファイル]" );
            System.exit(-1);
        }
        //設定ファイルを読み取り
        String profileName = args[0];

        // 設定ファイル存在チェック
        if (!new File(profileName).exists()) {
            System.err.print(profileName + " - エラー:設定ファイルが見つかりません。");
            System.exit(-1);
        }
        S2nProfile activeProfile = new S2nProfile(profileName);

        //パッケージマッピングファイル
        String mappingFileName = null;
        if (args.length > 1) {
            mappingFileName = args[1];
            // マッピングファイル存在チェック
            if (!new File(mappingFileName).exists()) {
                System.err.print(mappingFileName + " - エラー:パッケージマッピングファイルが見つかりません。");
                System.exit(-1);
            } else if (!"csv".equals(mappingFileName.substring(mappingFileName.lastIndexOf('.') + 1))) {
                System.err.print(mappingFileName + " - エラー:パッケージマッピングファイルをCSVフォーマットにしてください。");
                System.exit(-1);
            }
        }

        ClassPathConvertUtil.loadMappingFile(mappingFileName);

        String projectPath = activeProfile.getProjectPath();

        // 絶対パスに変わる
        File fileProject = new File(projectPath);
        if (fileProject != null && !fileProject.isAbsolute()) {
            projectPath = fileProject.getAbsolutePath();
        }
        if (!projectPath.endsWith(sp)) {
            projectPath = projectPath + sp;
        }

        ConvertStruts2Nablarch parserJava = new ConvertStruts2Nablarch();
        parserJava.setActiveProfile(activeProfile);

        parserJava.setCodeName(activeProfile.getFileEncording());
        parserJava.setInPath(projectPath + "jsp" + sp + "from");
        parserJava.setOutPath(projectPath + "jsp" + sp + "to");

        parserJava.strutsAnalyzeResultList = activeProfile.getStrutsAnalyzeResultList();

        parserJava.initVelocityEngine();

        TagConvertBase.loadMappingFile("noSupportTagProperty.csv");

        parserJava.execute();

        TagStatistics.getInstance().exportData();
        ScriptletStatistics.getInstance().exportData();

        //テストアプリにも直接デプロイ(デバッグ用途)
        if (!StringUtils.isEmpty(activeProfile.getTestDeployPath())) {

            parserJava.setOutPath(activeProfile.getTestDeployPath());
            parserJava.execute();

        }

    }

    /**
     * プロファイルを設定する。
     * @param activeProfile プロファイル
     */
    public void setActiveProfile(S2nProfile activeProfile) {
        this.activeProfile = activeProfile;

    }

    protected void executeFile(String inFilePath, String outPath, String fileName) throws IOException {

        println("<<File:" + inFilePath);

        Node topNode = JspParser.parse(inFilePath, fileName, codeName);

        //スクリプトレットログ
        makeScriptletLog(topNode, getRelativePath(inFilePath));

        //@page import置換
        convertPageImport(topNode, inFilePath);
        //@taglib置換
        convertTagLib(topNode, inFilePath);

        //カスタムタグ+inputタグの置換
        convertProc(topNode,
                new String[] { "logic:", "html:", "bean:", "s:", "nested:", "tis:", "input", "jsp:", "c:" },
                inFilePath);
        //Save File
        postProc(inFilePath, outPath, fileName, topNode);

    }

    private void makeScriptletLog(Node topNode, String jspname) {
        List<Node> sNodeList = NodeUtil.findAllScriptletNode(topNode);

        for (Node snode : sNodeList) {
            ScriptletStatistics.getInstance().addScriptlet(jspname, snode.getString());
        }
    }

    /**
     * page importの中からStruts系を削除。
     * @param topNode トップノード
     * @param inFilePath ファイルパス
     */
    private void convertPageImport(Node topNode, String inFilePath) {
        List<Node> findList = NodeUtil.findAllDirectiveNode(topNode, "page");
        //        boolean addNabStruts = false;
        for (Node node : findList) {
            NodeWrapper nw = new NodeWrapper(node);
            if (nw.isContainsKey("import")) {
                String strImports = nw.getValueAsString("import");
                StringBuffer outBuf = new StringBuffer();
                if (!StringUtils.isEmpty(strImports)) {
                    String[] arImports = strImports.split(",");
                    for (String strImport : arImports) {
                        String converted = ClassPathConvertUtil.getInstance().getConverterRules().get(strImport);
                        if (converted != null) {
                            strImport = converted;
                        }
                        if (outBuf.length() > 0) {
                            outBuf.append(",");
                        }
                        outBuf.append(strImport);
                    }
                }
                String outdata = outBuf.toString();
                if (StringUtils.isEmpty(outdata)) {
                    nw.removeAllTokens();
                } else {
                    nw.setValueAsString("import", outdata);
                }
            }
        }
    }

    protected void convertTagLib(Node topNode, String inFilePath) {
        List<Node> findList = NodeUtil.findAllDirectiveNode(topNode, "taglib");
        int insertPos = 0;
        for (Node node : findList) {
            int pos = node.getParent().getChildren().indexOf(node);
            insertPos = pos;
            NodeWrapper nw = new NodeWrapper(node);
            String uri = nw.getValueAsString("uri");
            if ((uri.startsWith("http://struts.apache.org/tags-")
                    || uri.startsWith("http://sastruts.seasar.org")
                    || uri.startsWith("http://www.tis.co.jp/s_web")
                    || uri.startsWith("http://www.tis.co.jp/taglib_1_0")
                    || uri.startsWith("http://www.tis.co.jp/taglib-tiles_1_0")
                    || uri.startsWith("http://jakarta.apache.org/struts/tags-"))) {
                node.getParent().getChildren().remove(node);

            }
        }

        VelocityContext context = new VelocityContext();
        String sw = mergeVelocityTemplate(XENLON_S2N_CONVERT_STRUTS_JSP_TAGLIB_INJECT_PARTS_VM, context);
        if (findList.size() > 0) {
            Node page = findList.get(0);
            page.getParent().getChildren().add(insertPos, Node.create(Node.T_NORMAL, sw));
        } else {
            topNode.getChildren().add(0, Node.create(Node.T_NORMAL, sw));
        }

    }

    protected void convertProc(Node topNode, String[] keys, String inFilePath) {
        Hashtable<String, Object> commonStore = new Hashtable<>();
        List<Node> findList = new ArrayList<>();
        List<Node> ignoreList = new ArrayList<>();
        NodeUtil.findTagStartsWithAllNode(topNode, keys, findList, ignoreList);
        //ignoreListの中身はログに書き出す
        for (Node node : ignoreList) {
            executeTagConvertClass(node, inFilePath, commonStore, true);

        }
        //findListの中身は処理する
        for (Node node : findList) {
            if (node.getParent() != null) {
                executeTagConvertClass(node, inFilePath, commonStore, false);
            }
        }

    }

    /**
     * タグを処理してログに書き出す。
     * @param node ノード
     * @param inFilePath ファイルパス
     * @param commonStore ドキュメント全体スコープの変数格納場所
     * @param ignoreFlg trueを付与するとタグ処理はせず、ログの書き出しのみ行う。
     */
    protected void executeTagConvertClass(Node node, String inFilePath, Hashtable<String, Object> commonStore,
            boolean ignoreFlg) {

        String[] sa = null;
        boolean startTag = true;
        if (node.getParams().get(1).getText().equals("/")) {
            startTag = false;
            sa = node.getParams().get(2).getText().split(":");
        } else {
            sa = node.getParams().get(1).getText().split(":");
        }
        String nodeString = node.getStringWithoutCRLF();
        String nodeSignature = new NodeWrapper(node).getSignature();
        //Nestedも考慮したうえでクラスを特定する
        String tagName = null;
        String className = null;

        if (sa.length > 1) {
            if (!ignoreFlg) {
                className = TagConvertBaseFactory.makeTagConverterClassName(sa[0], sa[1]);
            }
            tagName = sa[0] + ":" + sa[1];
        } else {
            if (!ignoreFlg) {
                className = TagConvertBaseFactory.makeTagConverterClassName("def", sa[0]);
            }
            tagName = sa[0];
        }

        if (!ignoreFlg) {
            //タグ処理実施

            TagConvertConfig config = new TagConvertConfig();
            config.inPath = this.inPath;
            config.inFilePath = inFilePath;
            config.strutsAnalyzeResult = this.strutsAnalyzeResultList;
            config.paramNamePrefix = this.activeProfile.getParamNamePrefix();

            TagConvertBase conv = null;
            try {
                conv = TagConvertBaseFactory.getInstance(className);
                conv.setConfig(config);
                conv.setActiveProfile(this.activeProfile);
                conv.setCommonStore(commonStore);
                if (sa[0].equals(NESTED_TAG_KEY)) {
                    //Nestedならフラグを立てる
                    conv.setNested(true);
                }

            } catch (Exception ex) {
                if(className.startsWith("jp.co.tis.s2n.jspConverter.convert.tag.c.")) {
                   return;
                }
                System.err.println(className + " is not found.");
                TagStatistics.getInstance().convertedCustomTag(tagName, className, nodeSignature,
                        getRelativePath(inFilePath), nodeString, TagStatistics.RESULT_NOTSUPPORTED);

                // 未サポートタグをコメントアウトしてログ出力する
                NodeUtil.insertPrev(node, "<%-- " + Node.NO_SUPPORT_LOG + " --%>" + "\r\n");
                node.getParams().add(0, new Token(Token.COMMENT1, "<%-- "));
                node.getParams().add(new Token(Token.COMMENT1, " --%>"));

                return;
            }

            try {
                NodeWrapper nw = new NodeWrapper(node);
                if (startTag) {
                    conv.start(nw);
                } else {
                    conv.end(nw);
                }
                TagStatistics.getInstance().convertedCustomTag(tagName, className, nodeSignature,
                        getRelativePath(inFilePath), nodeString, TagStatistics.RESULT_SUCCESS);
            } catch (Exception ex) {
                ex.printStackTrace();
                TagStatistics.getInstance().convertedCustomTag(tagName, className, nodeSignature,
                        getRelativePath(inFilePath), nodeString, TagStatistics.RESULT_ERROR);
            }
        } else {
            //ignoreログ
            TagStatistics.getInstance().convertedCustomTag(tagName, "", nodeSignature, getRelativePath(inFilePath),
                    nodeString, TagStatistics.RESULT_IGNORE);
        }

    }



    protected void postProc(String inFilePath, String outPath, String fileName, Node topNode) {

        String outFilePath = outPath + File.separator + fileName;
        println("<<File:" + inFilePath);
        println(">>File:" + outFilePath);

        try (OutputStreamWriter osw = getOutputStreamWriter(outFilePath, codeName)) {
            NodeUtil.fprintAll(new S2nFileWriter(osw, activeProfile), topNode);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Velocityエンジンの初期化。
     */
    public void initVelocityEngine() {
        VelocityEngine engine = new VelocityEngine();
        Properties p = new Properties();
        p.setProperty(RuntimeConstants.RESOURCE_LOADER, "class");
        p.setProperty("class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        engine.init(p);
        this.velocityEngine = engine;

    }

    /**
     * Velocityテンプレートを読む。
     * @param InjectPartsName 対象テンプレートファイル名
     * @param context コンテキスト
     * @return 取得した文字列
     */
    public String mergeVelocityTemplate(String InjectPartsName, VelocityContext context) {
        StringWriter sw = new StringWriter();

        //テンプレートの作成
        Template template = this.velocityEngine.getTemplate(InjectPartsName, "UTF-8");
        //テンプレートとマージ
        template.merge(context, sw);
        //マージしたデータはWriterオブジェクトであるswが持っているのでそれを文字列として出力
        sw.flush();
        return sw.toString();
    }

}
