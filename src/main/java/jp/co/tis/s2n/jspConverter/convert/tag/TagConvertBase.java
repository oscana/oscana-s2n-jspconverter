package jp.co.tis.s2n.jspConverter.convert.tag;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import jp.co.tis.s2n.converterCommon.struts.analyzer.StrutsAnalyzer;
import jp.co.tis.s2n.converterCommon.struts.analyzer.output.ActionForward;
import jp.co.tis.s2n.converterCommon.struts.analyzer.output.StrutsAction;
import jp.co.tis.s2n.converterCommon.util.CustomTagUtils.CustomTagType;
import jp.co.tis.s2n.converterCommon.util.StringUtils;
import jp.co.tis.s2n.jspConverter.convert.profile.S2nProfile;
import jp.co.tis.s2n.jspConverter.node.Node;
import jp.co.tis.s2n.jspConverter.node.NodeUtil;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;
import jp.co.tis.s2n.jspConverter.token.Token;

/**
 * タグ変換用ベースクラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public abstract class TagConvertBase {

    private static final String COMMON_STORE_KEY_NESTED_STACK = "jp.co.tis.s2n.jspConverter.convert.tag.TagConvertBase.NESTED_STACK";

    protected TagConvertConfig config;
    //ドキュメント全体スコープの変数格納場所
    protected Hashtable<String, Object> commonStore;

    //Nestedタグであるならtrue
    protected boolean isNested;

    // タグ名、未サポート属性リスト
    public static Map<String, List<String>> noSupportTagProperty = new HashMap<>();

    protected S2nProfile activeProfile;

    /**
     * 設定ファイルを設定する。
     * @param activeProfile 設定ファイル
     */
    public void setActiveProfile(S2nProfile activeProfile) {
        this.activeProfile = activeProfile;
    }

    /**
     * タグの変換処理（start）。
     * @param nw ノードラッパ
     */
    public final void start(NodeWrapper nw) {
        if (isNested) {
            //Nestedタグ向けのname引き継ぎは最初に実施する
            nestedStartTagProc(nw);
        }

        noSupportTagPropertyLog(nw);

        // indexed属性自動化対応
        String indexedValue = nw.getValueAsString("indexed");

        convertStartProc(nw);
        convertCommonAfterStartProc(nw,indexedValue);
        convertTagName(nw);
    }

    /**
     * タグの変換処理（end）。
     * @param nw ノードラッパ
     */
    public final void end(NodeWrapper nw) {
        if (isNested) {
            nestedEndTagProc(nw);
        }
        convertEndProc(nw);
        convertTagName(nw);
    }

    /**
     * name属性がなければ親のノードが入れたname属性を引き継ぐ。<br>
     * このノードが開始タグであればname属性値をスタックに積む。
     * @param nw ノードラッパ
     */
    private void nestedStartTagProc(NodeWrapper nw) {
        Stack<String> stack = getNestedNamestack();

        String vname = nw.getValueAsString("name");

        if (StringUtils.isEmpty(vname)) {
            if (stack.size() > 0) {
                vname = stack.peek();
            } else {
                vname = "form";
            }
            nw.addKeyValue("name", vname);
        }

        if (nw.getNodeType() == CustomTagType.StartTag) {
            stack.push(vname);
        }

    }

    /**
     * 終了タグの場合はスタックから最新のものを削除する。
     * @param nw ノードラッパ
     */
    private void nestedEndTagProc(NodeWrapper nw) {

        Stack<String> stack = getNestedNamestack();
        stack.pop();

    }

    @SuppressWarnings("unchecked")
    private Stack<String> getNestedNamestack() {
        Stack<String> nameStack;
        nameStack = (Stack<String>) this.commonStore.get(COMMON_STORE_KEY_NESTED_STACK);
        if (nameStack == null) {
            nameStack = new Stack<String>();
            this.commonStore.put(COMMON_STORE_KEY_NESTED_STACK, nameStack);
        }
        return nameStack;

    }

    /**
     * タグ変換で使用する外部情報格納用ファイルを設定する。
     * @param config タグ変換で使用する外部情報格納用ファイル
     */
    public void setConfig(TagConvertConfig config) {
        this.config = config;
    }

    /**
     * 未対応属性が含まれておればログを出す。
     * @param nw ノードラッパ
     * @param notSupportedKey 未対応属性キー
     */
    protected void logNotSupported(NodeWrapper nw, String notSupportedKey) {
    }

    /**
     * タグの名前を書き換えるユーティリティメソッド。<br>
     * このメソッドはタグ名がsrcNameで開始するタグであればsrcNameをdestNameに置換する。
     * @param node ノード
     * @param srcName 変換元
     * @param destName 変換先
     */
    protected static void renameTagName(Node node, String srcName, String destName) {
        for (Token token : node.getParams()) {
            if (token.getText().startsWith(srcName)) {
                token.setText(token.getText().replace(srcName, destName));
            }
        }
    }

    /**
     * .doを付与する。
     * @param path パス
     * @return .doを付与したパス
     */
    public static String convStrutsActionPath(String path) {
        if (path != null) {
            if (!path.endsWith(".do")) {
                return path + ".do";
            }
        }
        return path;
    }

    /**
     * このJSPのカレントモジュールを取得する。
     * @return カレントモジュール
     */
    protected String getCurModule() {
        String module = StringUtils.relativePath(this.config.inPath, this.config.inFilePath);
        return StringUtils.formatStrutsModulePath(module);
    }

    /**
     * このJSPのパスを取得する（モジュールも含めたパス）。
     * @return パス
     */
    protected String getCurJspPath() {
        String path = StringUtils.relativeFilePath(this.config.inPath, this.config.inFilePath).replace("\\", "/");

        if (path.startsWith("/")) {
            return path;
        } else {
            return "/" + path;
        }
    }

    /**
     * ドキュメント全体スコープの変数格納場所を設定する。
     * @param commonStore ドキュメント全体スコープの変数格納場所
     */
    public void setCommonStore(Hashtable<String, Object> commonStore) {
        this.commonStore = commonStore;

    }

    /**
     * JSPファイル全体の共通プロパティ領域にデータを保存する。
     * @param key キー
     * @param value 値
     */
    protected void setCommonProperty(String key, String value) {
        if (value != null) {
            this.commonStore.put(key, value);
        } else {
            removeCommonProperty(key);
        }
    }

    /**
     * JSPファイル全体の共通プロパティ領域にデータを保存する。
     * @param key キー
     * @param value 値
     */
    protected void setCommonPropertyAsObject(String key, Object value) {
        if (value != null) {
            this.commonStore.put(key, value);
        } else {
            removeCommonProperty(key);
        }

    }

    /**
     * Nestedタグのフラグを設定する。
     * @param isNested Nestedタグのフラグ
     */
    public void setNested(boolean isNested) {
        this.isNested = isNested;
    }

    /**
     * JSPファイル全体の共通プロパティ領域からデータを削除する。
     * @param key キー
     */
    protected void removeCommonProperty(String key) {
        this.commonStore.remove(key);
    }

    /**
     * JSPファイル全体の共通プロパティ領域からデータを取得する。
     * @param key キー
     * @return 共通プロパティ領域のデータ
     */
    protected String getCommonProperty(String key) {
        Object o = this.commonStore.get(key);
        if (o == null) {
            return null;
        } else if (o instanceof String) {
            return (String) o;
        } else {
            return o.toString();
        }
    }

    /**
     * JSPファイル全体の共通プロパティ領域からデータを取得する
     * @param key キー
     * @return 共通プロパティ領域のデータ
     */
    protected Object getCommonPropertyAsObject(String key) {
        return this.commonStore.get(key);
    }

    /**
     * タグの名称変換処理（start, endの両方から呼ばれる）。
     * @param nw ノードラッパ
     */
    abstract protected void convertTagName(NodeWrapper nw);

    /**
     * タグの中身変換処理(startのみで呼ばれる）。
     * @param nw ノードラッパ
     */
    abstract protected void convertStartProc(NodeWrapper nw);

    /**
     * endからのみ呼ばれる。
     * @param nw ノードラッパ
     */
    abstract protected void convertEndProc(NodeWrapper nw);

    /**
     * Strutsのスコープ指定文字列に対するJSTLのスコープ文字列を取得する。
     * @param strutsScope page/request/session/application
     * @return pageScope/requestScope/sessionScope/applicationScope
     */
    protected String convJSTLScope(String strutsScope) {
        if (StringUtils.isEmpty(strutsScope)) {
            return "";
        } else {
            return strutsScope + "Scope";
        }
    }

    /**
     * ${}付きでJSTL文字列を生成する。<br>
     * 空文字は自動的にスキップするので空文字の除去を事前にする必要がない。
     * @param nw ノードラッパ
     * @param params 結合したい要素を可変長引数で付与する
     * @return ${requestScope.foo.bar}のような文字列
     */
    protected String createJSTLValueStr(NodeWrapper nw, String... params) {
        return createJSTLValueStrSub(false, nw, params);
    }

    /**
     * JSTL文字列を生成する。<br>
     * 空文字は自動的にスキップするので空文字の除去を事前にする必要がない。
     * @param nw ノードラッパ
     * @param params 結合したい要素を可変長引数で付与する
     * @return ${requestScope.foo.bar}のような文字列
     */
    protected String createJSTLValueStrNoBlacket(NodeWrapper nw, String... params) {
        return createJSTLValueStrSub(true, nw, params);

    }

    /**
     * JSTL文字列を生成する。<br>
     * このメソッドは${ }で入力文字列を囲むだけである。
     * @param params 結合したい要素
     * @return JSTL文字列
     */
    protected String createJSTLValueAddBlacket(String params) {
        StringBuffer sb = new StringBuffer();
        sb.append("${");
        sb.append(params);
        sb.append("}");
        return sb.toString();

    }

    protected String createJSTLValueAddBlacketAndEscape(String params) {
        StringBuffer sb = new StringBuffer();
        sb.append("${");
        sb.append(params.replaceAll("\"", "\\\\\""));
        sb.append("}");
        return sb.toString();

    }

    /**
     * 与えられたパラメータをすべてピリオドで連結したものをかえす。<br>
     * パラメータにnullや空文字があった場合はその項目は省略する（ピリオド２連にはしない）。
     * @param params 結合したい要素を可変長引数で付与する
     * @return ${requestScope.foo.bar}のような文字列
     */
    protected String createJSTLValue(String... params) {
        StringBuffer sb = new StringBuffer();
        int count = 0;
        for (String param : params) {
            if (!StringUtils.isEmpty(param)) {
                if (count > 0) {
                    sb.append(".");
                }
                sb.append(param);
                count++;
            }
        }
        return sb.toString();
    }

    /**
     * 与えられたパラメータをすべてピリオドで連結したうえで、${xxxx}のように囲ったものをかえす。<br>
     * パラメータにnullや空文字があった場合はその項目は省略する（ピリオド２連にはしない）。
     * @param params 結合したい要素を可変長引数で付与する
     * @return ${requestScope.foo.bar}のような文字列
     */
    protected String createJSTLValueAddBlacket(String... params) {
        StringBuffer sb = new StringBuffer();
        sb.append("${");
        int count = 0;
        for (String param : params) {
            if (!StringUtils.isEmpty(param)) {
                if (count > 0) {
                    sb.append(".");
                }
                sb.append(param);
                count++;
            }
        }
        sb.append("}");
        return sb.toString();
    }

    //ScriptLetから取得するようであれば、それをJSTLから参照できる場所に書き込むスクリプトも生成する
    private String createJSTLValueStrSub(boolean noBlacket, NodeWrapper nw, String... params) {
        StringBuffer sb = new StringBuffer();
        if (!noBlacket) {
            sb.append("${");
        }
        int count = 0;
        for (String param : params) {
            if (!StringUtils.isEmpty(param)) {

                JSTLString jsParam = new JSTLString(param);
                if (jsParam.getDataType() == JSTLString.TYPE_SCRIPTLET) {
                    String vName = makeVnameForScriptLet(jsParam.getValue());
                    NodeUtil.insertPrev(nw.getNode(),
                            " <c:set var=\"" + vName + "\" value='" + jsParam.getOrgValue() + "' />");
                    sb.append("[");
                    sb.append(vName);
                    sb.append("]");
                } else {
                    if (count > 0) {
                        sb.append(".");
                    }
                    sb.append(param);
                }
                count++;
            }
        }
        if (!noBlacket) {
            sb.append("}");
        }
        return sb.toString();
    }

    /**
     * そのまま変数として使えるならそれを返し、そうでないなら勝手に変数名を作る。
     * @param value 変数名
     * @return 変数名
     */
    protected String makeVnameForScriptLet(String value) {
        if (value.matches("\\w*")) {
            return value;
        } else {
            return "pv_" + Integer.toHexString(value.hashCode());
        }
    }

    /**
     * 属性値を取得したあと属性を削除する。<br>
     * 属性を別の属性とマージするので、値取得後は削除したい場合に使用する。
     * @param nw ノードラッパ
     * @param srcKey 属性キー
     * @return 属性値
     */
    protected String getAndDelParam(NodeWrapper nw, String srcKey) {
        String prop = nw.getValueAsString(srcKey);
        nw.removeKeyValue(srcKey);

        return StringUtils.normalizeNull(prop);
    }

    protected String convertScriptLetToJSTLStr(String name) {
        if (JSTLString.isScriptLet(name)) {
            name = JSTLString.scriptletToJSTL(name);
        }
        return name;
    }

    /**
     * このページを参照しているアクションをみつけ、そこにあるForward一覧からforwardで指定された遷移先を取得する。
     * @param forward forward名
     * @param sModule 指定することでモジュールを意識したパスとなる
     * @return 遷移先
     */
    protected String findForwardForThisJsp(String forward, String sModule) {
        String jspPath = getCurJspPath();
        ActionForward nextForward = null;
        List<ActionForward> forwards = StrutsAnalyzer.findForwardByName(this.config.strutsAnalyzeResult, forward);
        if (forwards.size() == 0) {
            List<StrutsAction> fActions = StrutsAnalyzer.findActionByForwardPath(this.config.strutsAnalyzeResult,
                    jspPath);
            if (fActions.size() != 0) {
                nextForward = fActions.get(0).getForwardList().get(forward);
            }
        } else {
            nextForward = forwards.get(0).getParentAction().getForwardList().get(forward);

        }
        if (nextForward != null) {
            return convStrutsActionPath(StringUtils.addPath(sModule, nextForward.getPath()));
        }
        return null;
    }

    /**
     * varにある変数をJSPのページスコープの変数にも書き込む。
     * @param nw ノードラッパ
     */
    protected void writeJSPPageScopeToJSTLParamVar(NodeWrapper nw) {
        NodeUtil.insertAfter(nw.getNode(), "<%Object " + nw.getValueAsString("var") + "=pageContext.findAttribute(\""
                + nw.getValueAsString("var") + "\");%>");
    }

    /**
     * 	暗黙オブジェクトから取り出すコードをvalueに書き込む生成する共通処理。
     *
     * @param nw ノードラッパ
     * @param key キー
     * @param name この値がスクリプトレットの場合は変数に入れ替えるコードも出力する
     */
    protected void writeJSTLImplicitObjectToValue(NodeWrapper nw, String key, String name) {
        JSTLString jsValue = new JSTLString(name);
        if (jsValue.getDataType() == JSTLString.TYPE_SCRIPTLET) {
            String vName = makeVnameForScriptLet(jsValue.getValue());
            NodeUtil.insertPrev(nw.getNode(),
                    " <c:set var=\"" + vName + "\" value=\"" + jsValue.getOrgValue() + "\" />");
            nw.addKeyValue("value", createJSTLValueAddBlacket(key + "[" + vName + "]"));

        } else {
            nw.addKeyValue("value", createJSTLValueStr(nw, key, jsValue.getValue()));
        }
    }

    /**
     * パスの置換を実施する。<br>
     * sAction / forward / sPage / hrefのいずれかをセットする。<br>
     * 複数同時にセットすると上記の順で適合したもので処理する。<br>
     * sModuleはモジュール名をセットする。
     * @param sAction .doが付与され、モジュールを考慮したパスとなる
     * @param sPage そのままで、モジュールを考慮したパスとなる
     * @param forward このページを参照しているアクションをみつけ、そこにあるForward一覧からforwardで指定された遷移先を取得する
     * @param href そのままで、モジュールとの連結も行わず、無修正で返す
     * @param sModule 指定することでモジュールを意識したパスとなる
     * @return 置換結果
     */
    protected String convertPath(String sAction, String sPage, String forward, String href, String sModule) {
        String trgPath = null;
        if (!StringUtils.isEmpty(sAction)) {
            trgPath = StringUtils.addPath(sModule, sAction);
        } else if (!StringUtils.isEmpty(forward)) {
            trgPath = findForwardForThisJsp(forward, sModule);
        } else if (!StringUtils.isEmpty(sPage)) {
            trgPath = StringUtils.addPath(sModule, sPage);
        } else if (!StringUtils.isEmpty(href)) {
            trgPath = href;
        }
        return trgPath;
    }

    /**
     * s2nの標準的な入力フィールドのコンバート。<br>
     * property -> name <br>
     * styleId -> id <br>
     * errorStyleClass -> errorCss <br>
     * styleClass -> cssClass <br>
     * erroStyleId, errorStyle ->エラー <br>
     *
     * nameは[フォーム名].nameにリネーム
     * @param nw ノードラッパ
     */
    protected void s2nStandardInputWidgetConvertProc(NodeWrapper nw) {

        nw.renameKeyString("styleId", "id");
        nw.renameKeyString("errorStyleClass", "errorCss");
        nw.renameKeyString("styleClass", "cssClass");
        nw.removeKeyValue("indexed");
        nw.removeKeyValue("errorStyle");
        nw.removeKeyValue("errorStyleId");
        logNotSupported(nw, "errorStyle");
        logNotSupported(nw, "errorStyleId");
        logNotSupported(nw, "indexed");
        logNotSupported(nw, "codeType");
        logNotSupported(nw, "suffix");
        logNotSupported(nw, "listNumber");

        if (nw.isContainsKey("name") && nw.isContainsKey("property")) {
            nw.setValueAsString("name", nw.getValueAsString("name") + "." + getAndDelParam(nw, "property"));
        } else {
            nw.renameKeyString("property", "name");
        }

    }

    /**
     * タグの中身があれば変数に代入してキーで指定した属性として付与する。<br>
     * 与えられたノードがCustomTagType.StartTagタグ以外であれば何もしない。
     * @param nw ノードラッパ
     * @param variableName 代入する変数名
     */
    protected void assignBodyTagToTagParameter(NodeWrapper nw, String variableName) {
        if (nw.getNodeType() != CustomTagType.StartTag) {
            //開始タグであればボディタグの取得
            List<Node> list = NodeUtil.getBodyAsCustomTag(nw);
            if (list.size() > 0) {
                //ボディタグをオブジェクトの前に移動
                for (Node node : list) {
                    NodeUtil.movePrev(nw.getNode(), node);
                }
                //ボディタグを変数に代入
                NodeUtil.assignBodytoVariable("labelstr", list);
                //変数に代入したボディタグの中身をタグパラメータにセット
                nw.addKeyValue(variableName, "${labelstr}");
            }
        }
    }

    /**
     * 未サポート属性をログとして出力する。
     * @param nw ノードラッパ
     */
    public void noSupportTagPropertyLog(NodeWrapper nw) {

        List<String> noSupportPropertyList = noSupportTagProperty.get(nw.getTagName());
        if (noSupportPropertyList == null || noSupportPropertyList.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String noSupportProperty : noSupportPropertyList) {
            if (nw.isContainsKey(noSupportProperty)) {
                String value = getAndDelParam(nw, noSupportProperty);
                sb.append(noSupportProperty + "=" + "\"" + value + "\"" + "  ");
            }

        }

        if (sb.length() > 0) {
            NodeUtil.insertPrev(nw.getNode(), "<%-- " + Node.NO_SUPPORT_LOG + " 未サポート属性：" + sb.toString() + "--%>\r\n");
        }
    }

    /**
     * マッピングファイルを読み込み、未サポート属性一覧を構築する。
     * @param fileNameファイル名
     * @throws IOException 例外
     * @throws CsvException 例外
     */
    public static void loadMappingFile(String fileName) throws IOException, CsvException {
        Reader fileReader = null;
        CSVReader csvReader = null;
        try {
            fileReader = new InputStreamReader( ClassLoader.getSystemResourceAsStream(fileName));
            csvReader = new CSVReader(fileReader);
            List<String[]> records = csvReader.readAll();
            for (String[] rec : records) {
                if (rec.length == 3 && "×".equals(rec[2].trim())) {
                    List<String> noSupportPropertyList = noSupportTagProperty.get(rec[1]);
                    if (noSupportPropertyList == null || noSupportPropertyList.size() == 0) {
                        noSupportPropertyList = new ArrayList<>();
                        noSupportPropertyList.add(rec[0]);
                    } else {
                        noSupportPropertyList.add(rec[0]);
                    }
                    noSupportTagProperty.put(rec[1], noSupportPropertyList);
                }
            }

        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
            if (csvReader != null) {
                csvReader.close();
            }
        }

    }

    /**
     * 共通転換処理を行う。
     * @param nw ノードラッパ
     * @param indexedValue indexed属性の値
     */
    public void convertCommonAfterStartProc(NodeWrapper nw,String indexedValue) {

        changeIndexed(nw,indexedValue);
    }

    /**
     * name属性の値にindex情報（[${s.index }]）を追加する。
     *
     * @param nw ノードラッパ
     * @param indexedValue indexed属性の値
     */
    private void changeIndexed(NodeWrapper nw,String indexedValue) {
        if("true".equals(indexedValue) && commonStore.get("varStatus") != null) {
            String varStatus = (String) commonStore.get("varStatus");
            String nameValue = nw.getValueAsString("name");
            StringBuilder sb = new StringBuilder(nameValue);
            if(nameValue.contains(".")) {
                int position = sb.indexOf(".");
                sb.insert(position, "[${"+ varStatus + ".index}]");
            } else {
                sb.append("[${"+ varStatus + ".index }]");
            }
            nw.setValueAsString("name", sb.toString());
        }
        nw.removeKeyValue("indexed");
    }

}
