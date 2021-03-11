package jp.co.tis.s2n.jspConverter.convert.statistics;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jp.co.tis.s2n.converterCommon.statistics.StatisticsBase;

/**
 * 統計情報を蓄積するツール。<br>
 *
 * このクラスはシングレトンである、<br>
 * スレッドセーフではないので単一スレッドからの利用を想定する。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagStatistics {

    //シングレトン化
    private static TagStatistics instance;

    private TagStatistics() {
    }

    /**
     * インスタンスを取得する。
     * @return 唯一のインスタンスを返す
     */
    public static TagStatistics getInstance() {
        if (instance == null) {
            instance = new TagStatistics();
        }
        return instance;
    }

    /**
     * ログファイルのレコード定義（1行分）。
     */
    public class TagData {
        public String tagName;
        public String tagSignature;
        public String tagConvertClassName;
        public String jspname;
        public String result;
        public String orgString;
    }

    //ログファイルデータ
    private List<TagData> tagdata = new ArrayList<TagData>();

    /** TagData.resultのパラメータ*/
    public static String RESULT_SUCCESS = "SUCCESS";
    /** TagData.resultのパラメータ*/
    public static String RESULT_NOTSUPPORTED = "NOTSUPPORTED";
    /** TagData.resultのパラメータ*/
    public static String RESULT_IGNORE = "IGNORE";
    /** TagData.resultのパラメータ*/
    public static String RESULT_ERROR = "ERROR";

    /**
     * カスタムタグ処理結果を登録する。
     * @param tagName タグ名
     * @param tagConvertClassName タグクラス名
     * @param tagSignature タグシグネチャ
     * @param jspName jsp名
     * @param orgString ノードの文字列
     * @param result 変換結果
     */
    public void convertedCustomTag(String tagName, String tagConvertClassName, String tagSignature, String jspName,
            String orgString, String result) {
        TagData td = new TagData();
        td.tagName = tagName;
        td.tagConvertClassName = tagConvertClassName;
        td.tagSignature = tagSignature;
        td.jspname = jspName.replace("\\", "/");
        td.orgString = orgString;
        td.result = result;
        tagdata.add(td);

    }

    /**
     * CSVファイルに書き出す。
     * @throws IOException 例外
     * @throws IllegalAccessException 例外
     */
    public void exportData() throws IOException, IllegalAccessException {
        File file = new File("logs/tagResult.csv");
        StatisticsBase.exportCollection2Csv(file, tagdata);

    }

}
