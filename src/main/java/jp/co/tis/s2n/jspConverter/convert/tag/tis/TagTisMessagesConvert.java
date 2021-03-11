package jp.co.tis.s2n.jspConverter.convert.tag.tis;

import java.util.List;

import jp.co.tis.s2n.jspConverter.node.Node;
import jp.co.tis.s2n.jspConverter.node.NodeUtil;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;
import jp.co.tis.s2n.jspConverter.token.Token;

/**
 * TisMessagesタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagTisMessagesConvert extends TagTisConvertBase {
    @Override
    protected void convertStartProc(NodeWrapper nw) {

        if (nw.isContainsKey("message") && "true".equals(nw.getValueAsString("message"))) {
            if (nw.isContainsKey("name")) {
                nw.setValueAsString("name", "org_apache_struts_action_ACTION_MESSAGE");
            } else {
                nw.addKeyValue("name", "org_apache_struts_action_ACTION_MESSAGE");
            }
        }
        nw.removeKeyValue("id");
        nw.removeKeyValue("message");

        int size = nw.getNode().getParams().size();
        Token t = new Token(Token.SYMBOL, "/");
        nw.getNode().getParams().add(size - 1, t);

        List<Node> list = NodeUtil.getBodyAsCustomTag(nw);
        for (Node childNode : list) {
            NodeUtil.removeChildNode(childNode);
        }

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {
        nw.renameTagName("n:write");
    }

    @Override
    protected void convertEndProc(NodeWrapper nw) {
        NodeUtil.removeChildNode(nw.getNode());
    }

}
