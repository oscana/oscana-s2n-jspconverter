package jp.co.tis.s2n.jspConverter.convert.tag.logic;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * LogicForwardタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagLogicForwardConvert extends TagLogicConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {
        nw.setValueAsString("name", nw.getValueAsString("name") + ".jsp");
        nw.renameKeyString("name", "page");
    }

    @Override
    protected void convertTagName(NodeWrapper nw) {
        nw.renameTagName("jsp:foward");
    }
}
