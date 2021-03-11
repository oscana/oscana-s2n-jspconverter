package jp.co.tis.s2n.jspConverter.convert.tag.logic;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * LogicMessagesPresentタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagLogicMessagesPresentConvert extends TagLogicConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        String property = getAndDelParam(nw, "property");
        String name = getAndDelParam(nw, "name");
        nw.removeKeyValue("message");

        if ((property != null) || (name != null)) {
            nw.addKeyValue("test", "${!empty errors.getMessage('" + createJSTLValue(name, property) + "')}");
        } else {
            nw.addKeyValue("test", "${!empty errors}");
        }
    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

        nw.renameTagName("c:if");

    }
}
