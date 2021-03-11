package jp.co.tis.s2n.jspConverter.convert.tag.logic;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * LogicPresentタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagLogicPresentConvert extends TagLogicConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        String expression = makeELExpressionFromStdParam(nw);
        nw.addKeyValue("test", createJSTLValueAddBlacketAndEscape("!(empty " + expression + ")"));

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {
        nw.renameTagName("c:if");
    }

}
