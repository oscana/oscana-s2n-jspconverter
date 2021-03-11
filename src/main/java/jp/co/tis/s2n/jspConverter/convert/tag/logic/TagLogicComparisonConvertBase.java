package jp.co.tis.s2n.jspConverter.convert.tag.logic;

import jp.co.tis.s2n.jspConverter.convert.tag.JSTLString;
import jp.co.tis.s2n.jspConverter.node.NodeUtil;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * equal, notEqual, greaterEqual, greaterThan, lessEqual, lessThanタグ変換用ベースクラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public abstract class TagLogicComparisonConvertBase extends TagLogicConvertBase {
    @Override
    protected void convertStartProc(NodeWrapper nw) {

        String expression = makeELExpressionFromStdParam(nw);
        JSTLString value = new JSTLString(getAndDelParam(nw, "value"));
        if (value.getDataType() == JSTLString.TYPE_SCRIPTLET) {
            String vName = makeVnameForScriptLet(value.getValue());
            NodeUtil.insertPrev(nw.getNode(), " <c:set var=\"" + vName + "\" value=\"" + value.getOrgValue() + "\" />");
            nw.addKeyValue("test", createJSTLValueAddBlacketAndEscape(expression + " " + getOperator() + " " + vName));

        } else {
            nw.addKeyValue("test", createJSTLValueAddBlacketAndEscape(
                    expression + " " + getOperator() + " " + value.getQuotedString()));
        }

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {
        nw.renameTagName("c:if");
    }

    /**
     * 演算子を応答する。
     * @return 演算子
     */
    protected abstract String getOperator();

}
