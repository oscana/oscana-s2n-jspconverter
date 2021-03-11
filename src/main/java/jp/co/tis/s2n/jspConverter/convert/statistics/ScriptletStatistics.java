package jp.co.tis.s2n.jspConverter.convert.statistics;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jp.co.tis.s2n.converterCommon.statistics.StatisticsBase;
import jp.co.tis.s2n.converterCommon.util.StringUtils;

/**
 * 統計情報を蓄積するツール。<br>
 *
 * このクラスはシングレトンである、<br>
 * スレッドセーフではないので単一スレッドからの利用を想定する。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class ScriptletStatistics {

    //シングレトン化
    private static ScriptletStatistics instance;

    private ScriptletStatistics() {
    }

    /**
     * インスタンスを取得する。
     * @return 唯一のインスタンスを返す
     */
    public static ScriptletStatistics getInstance() {
        if (instance == null) {
            instance = new ScriptletStatistics();
        }
        return instance;
    }

    /**
     * ログファイルのレコード定義（1行分）。
     */
    public class ScriptletData {
        public String jsppath;
        public String jspname;
        public String scriptlet;
    }

    //ログファイルデータ
    private List<ScriptletData> scriptletData = new ArrayList<ScriptletData>();

    /**
     * 検出したスクリプトレットを登録する。
     * @param jspname jsp名
     * @param scriptlet スクリプトレット
     */
    public void addScriptlet(String jspname, String scriptlet) {
        ScriptletData data = new ScriptletData();
        data.jsppath = StringUtils.getDirectoryFromFilePath(jspname.replace("\\", "/"));
        data.jspname = StringUtils.getFileNameFromFilePath(jspname.replace("\\", "/"));
        data.scriptlet = scriptlet;
        scriptletData.add(data);
    }

    /**
     * CSVファイルに書き出す。
     * @throws IOException 例外
     * @throws IllegalAccessException 例外
     */
    public void exportData() throws IOException, IllegalAccessException {
        File file = new File("logs/scriptletData.csv");
        StatisticsBase.exportCollection2Csv(file, scriptletData);

    }

}
