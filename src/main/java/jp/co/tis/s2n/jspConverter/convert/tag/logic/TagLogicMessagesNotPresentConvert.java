package jp.co.tis.s2n.jspConverter.convert.tag.logic;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * LogicMessagesNotPresentタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagLogicMessagesNotPresentConvert extends TagLogicConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {
        nw.addKeyValue("test", "${empty errors}");
        nw.removeKeyValue("message");
    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

        nw.renameTagName("c:if");

    }
}
