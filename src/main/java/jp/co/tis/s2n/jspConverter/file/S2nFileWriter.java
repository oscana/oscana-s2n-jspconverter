package jp.co.tis.s2n.jspConverter.file;

import java.io.IOException;
import java.io.OutputStreamWriter;

import jp.co.tis.s2n.jspConverter.convert.profile.S2nProfile;

/**
 * ファイル出力ツール。<br>
 * <br>
 * 標準化されたスペース、タブ、改行の出力や、インデントの生成を補助する機能を有するWriterのラッパ<br>
 * ・スペース=半角スペース<br>
 * ・タブ=半角スペース4つ<br>
 * ・インデントはタブ１つ<br>
 * ・改行コードはプロパティ設定ファイルに指定した改行コード<br>
 *  ※ノード間に挿入する改行を指定した改行コードにするだけでなく、ノード内に含まれる改行コードも指定した改行コードに置換する。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class S2nFileWriter {

    protected S2nProfile activeProfile;

    /**
     * {@link S2nFileWriter}を作成する。
     * @param osw 出力ファイル
     * @param activeProfile 設定ファイル
     */
    public S2nFileWriter(OutputStreamWriter osw, S2nProfile activeProfile) {
        this.osw = osw;
        this.activeProfile = activeProfile;
    }

    // Output File
    private OutputStreamWriter osw = null;

    /**
     * 指定した文字列を出力する。<br>
     *
     * 改行コードを置換する。
     *
     * @param str 出力文字列
     * @throws IOException 例外
     */
    public void fprint(String str) throws IOException {
        //設定ファイルに指定した改行コードが\r\nの場合、そのまま書き込む
        if (activeProfile.getLineSeparator().equals("\r\n")) {
            oswWrite(str);
        } else {
            //指定した改行コードが\nの場合、改行コードを\nに変換した上、書き込む
            oswWrite(str.replaceAll("\r\n", activeProfile.getLineSeparator()));
        }
    }

    private void oswWrite(String str) throws IOException {
        osw.write(str);
    }

}
