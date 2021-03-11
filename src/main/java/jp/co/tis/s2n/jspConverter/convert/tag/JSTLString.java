package jp.co.tis.s2n.jspConverter.convert.tag;

import jp.co.tis.s2n.converterCommon.util.StringUtils;

/**
 * JSTLの中で使用する文字列を扱う。<br>
 *
 * リテラル文字列、EL式やスクリプトレットで指定されたデータをJSTLの${ }に入れる用に自動変換し、
 * 変換結果を保持するクラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class JSTLString {

    private static final String PATTERN_SCRIPTLET = "^<%\\s*=(.+)%\\s*>$";
    /** * リテラル文字列 */
    public static int TYPE_NORMAL = 0;
    /** * スクリプトレットによる変数参照 */
    public static int TYPE_SCRIPTLET = 1;
    /** * ELによる変数参照 */
    public static int TYPE_EL = 2;

    private String orgValue;

    private String destvalue;
    private int dataType;

    public JSTLString(String value) {
        super();
        this.orgValue = value;
        if (StringUtils.isEmpty(this.orgValue)) {
            return;
        }
        destvalue = orgValue.replaceAll(PATTERN_SCRIPTLET, "$1");

        if (destvalue.equals(orgValue)) {
            destvalue = orgValue.replaceAll("\\$\\{\\s*([^\\}\\s]+\\s*)\\}", "$1");
            if (destvalue.equals(orgValue)) {
                dataType = TYPE_NORMAL;
            } else {
                dataType = TYPE_EL;
            }
        } else {
            dataType = TYPE_SCRIPTLET;
        }

    }

    /**
     * タグの文字列を取得する。
     * @return タグの文字列
     */
    public String getOrgValue() {
        return this.orgValue;
    }

    /**
     * 中身の値を取得する。
     * @return 中身の値
     */
    public String getValue() {
        return this.destvalue;
    }

    /**
     * データタイプを取得する。
     * @return データタイプ
     */
    public int getDataType() {
        return dataType;
    }

    /**
     * JSTL式内で使用するためのクオートを適切につける。<br>
     * リテラル文字列の場合だけダブルクオートを付ける。
     * @return クオートを付けた結果
     */
    public String getQuotedString() {
        if (dataType == TYPE_NORMAL) {
            return "\"" + this.destvalue + "\"";
        }
        return this.destvalue;
    }

    /**
     * <%=  %>であるかを判定する。
     * @param name 文字列
     * @return チェック結果、Scriptlet形式の場合：true、その以外：false
     */
    public static boolean isScriptLet(String name) {
        if (name == null) {
            return false;
        }
        return name.matches(PATTERN_SCRIPTLET);
    }

    /**
     * Scrptlet形式の中身だけを取り出す。<br>
     * <%=  %>の中身だけを取り出す。
     * @param name 文字列
     * @return 取得した結果
     */
    public static String scriptletToJSTL(String name) {
        return name.replaceAll(PATTERN_SCRIPTLET, "$1");

    }

}
