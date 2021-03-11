package jp.co.tis.s2n.jspConverter.convert.tag.logic;

import jp.co.tis.s2n.converterCommon.util.StringUtils;
import jp.co.tis.s2n.jspConverter.convert.tag.JSTLString;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * LogicMatchタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagLogicMatchConvert extends TagLogicConvertBase {
    @Override
    protected void convertStartProc(NodeWrapper nw) {

        String expression = makeELExpressionFromStdParam(nw);
        String location = getAndDelParam(nw, "location");

        JSTLString value = new JSTLString(getAndDelParam(nw, "value"));

        if (StringUtils.isEmpty(location)) {
            //完全一致
            nw.addKeyValue("test", createJSTLValueAddBlacketAndEscape(
                    "fn:contains(" + expression + " , " + value.getQuotedString() + ")"));
        } else if (location.toLowerCase().equals("start")) {
            //前方一致
            nw.addKeyValue("test", createJSTLValueAddBlacketAndEscape(
                    "fn:startsWith(" + expression + "," + value.getQuotedString() + ")"));
        } else if (location.toLowerCase().equals("end")) {
            //後方一致
            nw.addKeyValue("test", createJSTLValueAddBlacketAndEscape(
                    "fn:endsWith(" + expression + "," + value.getQuotedString() + ")"));
        } else {
            //完全一致
            nw.addKeyValue("test", createJSTLValueAddBlacketAndEscape(
                    "fn:contains(" + expression + " , " + value.getQuotedString() + ")"));
        }

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {
        nw.renameTagName("c:if");
    }

}
