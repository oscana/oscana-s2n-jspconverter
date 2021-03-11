package jp.co.tis.s2n.jspConverter.convert;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.TreeSet;

import jp.co.tis.s2n.converterCommon.util.StringUtils;
import jp.co.tis.s2n.jspConverter.file.S2nFileWriter;

/**
 * convert処理の土台クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public abstract class AbstractBatchBase {

    public static final String CRLF = "\r\n";
    public static final String SP1 = " ";

    protected String inPath = null;
    protected String outPath = null;
    protected String logPath = null;
    protected String logFileName = null;

    protected String codeName = null;

    protected S2nFileWriter logw = null;

    protected TreeSet<String> treeSet = new TreeSet<>();

    /**
     * 対象ファイルのあるディレクトリを設定する。
     * @param path 対象ファイルのあるディレクトリ
     */
    public void setInPath(String path) {
        inPath = path;
    }

    /**
     * 出力先を設定する。
     * @param path 出力先
     */
    public void setOutPath(String path) {
        outPath = path;
    }

    /**
     * 処理の入り口。<br>
     * トップ階層から再帰的にディレクトリを走査して、全ファイルの処理を実施する。
     */
    public void execute() {
        execute(inPath, outPath, ".jsp");
    }

    /**
     * 指定された場所から再帰的にディレクトリを走査して、全ファイルの処理を実施する。<br>
     * fromPathで指定されたディレクトリ内の全ファイルのうち、ファイル名がsuffixで終わるものだけを処理する。<br>
     * 処理結果はtoPathに出力される。
     * @param fromPath 処理対象(Input)
     * @param toPath 出力先(Output)
     * @param keywd 処理対象ファイルの種類
     */
    public void execute(String fromPath, String toPath, String keywd) {

        try {
            findDir(fromPath, toPath, keywd, new File(fromPath));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * ファイルの再帰処理。<br>
     * 再帰的にディレクトリを走査しながら以下の処理を実施する。<br>
     * ・出力先ディレクトリの作成をしながら、ファイル単位の処理を呼び出す。<br>
     *  ディレクトリが空なら出力先ディレクトリは作成しない。
     *
     * @param fromPath 対象ファイルのあるディレクトリ
     * @param toPath 出力先
     * @param keywd 処理対象ファイルの種類
     * @param dir 処理対象ファイル
     */
    public void findDir(String fromPath, String toPath, String keywd, File dir) {

        println();
        println("<<Path:" + dir.getPath());
        String s1 = dir.getPath();
        String s2 = s1.replace(fromPath, "");
        String s3 = toPath + s2;
        println(">>Path:" + s3);

        File newDir = new File(s3);

        newDir.mkdir();

        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                findDir(fromPath, toPath, keywd, file);
            } else if (file.isFile()) {
                findFile(fromPath, toPath, keywd, file, newDir);
            }
        }

    }

    /**
     * 単一ファイルの処理。
     * @param fromPath 処理対象(Input)
     * @param toPath 出力先(Output)
     * @param keywd 処理対象ファイルの種類
     * @param file 処理対象ファイル
     * @param outPath 出力ファイル
     */
    public void findFile(String fromPath, String toPath, String keywd, File file, File outPath) {
        try {
            if (file.getName().endsWith(keywd) == false) {
                //そのままコピーする
                Path cFrom = Paths.get(file.getAbsolutePath());
                Path cTo = Paths.get(new File(outPath.getAbsolutePath(), file.getName()).getAbsolutePath());
                Files.copy(cFrom, cTo, StandardCopyOption.REPLACE_EXISTING);

                return;
            }

            executeFile(file.getAbsolutePath(), outPath.getAbsolutePath(), file.getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    protected void executeFile(String inFilePath, String outPath, String fileName) throws IOException {
    }

    protected OutputStreamWriter getOutputStreamWriter(String filePath, String codeName) throws IOException {
        return new OutputStreamWriter(new FileOutputStream(filePath), codeName);
    }

    /**
     * 処理中のファイルに対するトップディレクトリからの相対パスを取得する。
     * @param inFilePath ファイルパス
     * @return 相対パス
     */
    public String getRelativePath(String inFilePath) {
        return StringUtils.relativeFilePath(this.inPath, inFilePath);
    }

    /**
     * 文字コードを設定する。
     * @param name 文字コード
     */
    public void setCodeName(String name) {
        codeName = name;
    }

    protected void println(String str) {
        System.out.println(str);
    }

    protected void println() {
        System.out.println("");
    }

}
