package jp.co.tis.s2n.jspConverter.convert.tag.html;

import jp.co.tis.s2n.jspConverter.node.Node;
import jp.co.tis.s2n.jspConverter.node.NodeUtil;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;
import jp.co.tis.s2n.jspConverter.token.Token;

/**
 * HtmlOptionタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlOptionConvert extends TagHtmlConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        nw.renameKeyString("styleId", "id");

        if (nw.isContainsKey("key")) {
            String keyValue = getAndDelParam(nw, "key");

            Node childNode = Node
                    .create(new Token(Token.NAME, "<n:message messageId=" + "\"" + keyValue + "\"" + "/>"));
            NodeUtil.addChildNode(nw.getNode(), 0, childNode);

            String value = nw.getValueAsString("value");
            String selectFlag = " <c:if test=" + "\"${fn:contains(fn:join(" + NodeUtil.selectTagName + "," + "'" + "'"
                    + ")," + "'" + value + "'" + ")}\"" + ">selected</c:if> ";

            Token token = new Token(Token.SPACE, selectFlag);
            nw.getNode().getParams().add(2, token);
        }
    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

        nw.replaceTag("html:", "");

    }
}
