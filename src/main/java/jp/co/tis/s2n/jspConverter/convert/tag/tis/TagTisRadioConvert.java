package jp.co.tis.s2n.jspConverter.convert.tag.tis;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * TisRadioタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagTisRadioConvert extends TagTisInputBase {
    @Override
    protected void convertStartProc(NodeWrapper nw) {

        //入力系共通処理
        super.convertStartProc(nw);
        nw.renameKeyString("codeType", "codeId");
        nw.renameKeyString("suffix", "label");
        nw.removeKeyValue("id");

        if (nw.isContainsKey("option")) {
            nw.renameKeyString("option", "listName");
            nw.addKeyValue("elementValueProperty", "true");
            nw.addKeyValue("elementLabelProperty", "label");
        } else {
            nw.removeKeyValue("listNumber");
        }

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

        if (nw.isContainsKey("listName")) {
            nw.renameTagName("n:radioButtons");
        } else if (nw.isContainsKey("codeId")) {
            nw.renameTagName("n:codeRadioButtons");
        } else {
            nw.renameTagName("n:radioButton");
        }
    }
}
