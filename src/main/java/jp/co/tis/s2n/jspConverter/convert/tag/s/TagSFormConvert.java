package jp.co.tis.s2n.jspConverter.convert.tag.s;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * SFormタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagSFormConvert extends TagSConvertBase {

    public static String KEY_FORM = "TagSFormConvert.form";

    @Override
    protected void convertEndProc(NodeWrapper nw) {
        removeCommonProperty(KEY_FORM);
    }

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        setCommonPropertyAsObject(KEY_FORM, nw);
        nw.renameKeyString("styleId", "id");
    }
}
