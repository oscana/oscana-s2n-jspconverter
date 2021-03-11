package jp.co.tis.s2n.jspConverter.convert.tag.tis;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * TisSelectタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagTisSelectConvert extends TagTisInputBase {
    @Override
    protected void convertStartProc(NodeWrapper nw) {
        //入力系共通処理
        super.convertStartProc(nw);
        nw.renameKeyString("codeType", "codeId");
        nw.renameKeyString("firstScreenString", "noneOptionLabel");
        nw.addKeyValue("withNoneOption", "true");

        nw.removeKeyValue("dispOnlyImiFlg");
        nw.removeKeyValue("columnId");
        nw.removeKeyValue("columnName");
        nw.removeKeyValue("delFlg");
        nw.removeKeyValue("indexed");
        nw.removeKeyValue("dispOnlyCodeFlg");
        nw.removeKeyValue("delFlg");

        if (nw.isContainsKey("codeId")) {
            nw.removeKeyValue("option");
        } else {
            nw.renameKeyString("option", "listName");
            nw.addKeyValue("elementValueProperty", "true");
            nw.addKeyValue("elementLabelProperty", "label");
        }

        if (nw.isContainsKey("multiple")) {
            nw.setValueAsString("multiple", "multiple");
        }

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

        if (nw.isContainsKey("codeId")) {
            nw.renameTagName("n:codeSelect");
        } else {
            nw.renameTagName("n:select");
        }
    }
}
