package jp.co.tis.s2n.jspConverter.convert.tag.html;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * HtmlFormタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlFormConvert extends TagHtmlConvertBase {

    public static String KEY_FORM = "TagHtmlFormConvert.form";

    @Override
    protected void convertEndProc(NodeWrapper nw) {
        removeCommonProperty(KEY_FORM);
    }

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        setCommonProperty(KEY_FORM, nw.getValueAsString("action"));
        nw.removeKeyValue("action");
        nw.renameKeyString("styleId", "id");
    }
}
