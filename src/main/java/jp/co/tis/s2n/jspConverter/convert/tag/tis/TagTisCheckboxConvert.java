package jp.co.tis.s2n.jspConverter.convert.tag.tis;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * TisCheckboxタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagTisCheckboxConvert extends TagTisInputBase {
    @Override
    protected void convertStartProc(NodeWrapper nw) {
        //入力系共通処理
        super.convertStartProc(nw);
        nw.renameKeyString("suffix", "label");
        nw.removeKeyValue("errorStyleId");

        if (nw.isContainsKey("option")) {
            nw.renameKeyString("option", "listName");
            nw.addKeyValue("elementValueProperty", "true");
            nw.addKeyValue("elementLabelProperty", "label");
        }

        // タグボディをパラメータに変換
        assignBodyTagToTagParameter(nw, "label");

        if (nw.isContainsKey("codeType")) {
            nw.renameKeyString("codeType", "codeId");
            nw.addKeyValue("listFormat", "sp");
        }

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

        if (nw.isContainsKey("codeId")) {
            nw.renameTagName("n:codeCheckboxes");
            nw.removeKeyValue("id");
            nw.removeKeyValue("offValue");
        } else if (nw.isContainsKey("listName")) {
            nw.renameTagName("n:checkboxes");
            nw.removeKeyValue("id");
            nw.removeKeyValue("offValue");
        } else {
            nw.renameTagName("n:checkbox");
            if (!nw.isContainsKey("value")) {
                nw.addKeyValue("value", "on");
            }
        }

    }
}
