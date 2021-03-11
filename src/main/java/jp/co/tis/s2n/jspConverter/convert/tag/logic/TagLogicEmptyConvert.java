package jp.co.tis.s2n.jspConverter.convert.tag.logic;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * LogicEmptyタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagLogicEmptyConvert extends TagLogicConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        String name = getAndDelParam(nw, "name");
        String property = getAndDelParam(nw, "property");
        String scope = getAndDelParam(nw, "scope");

        nw.addKeyValue("test", createJSTLValueAddBlacket(
                "empty " + createJSTLValueStrNoBlacket(nw, convJSTLScope(scope), name, property)));

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {
        nw.renameTagName("c:if");
    }
}
