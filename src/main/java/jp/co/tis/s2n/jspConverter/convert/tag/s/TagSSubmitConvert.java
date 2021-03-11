package jp.co.tis.s2n.jspConverter.convert.tag.s;

import java.util.List;

import jp.co.tis.s2n.jspConverter.node.Node;
import jp.co.tis.s2n.jspConverter.node.NodeUtil;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;
import jp.co.tis.s2n.jspConverter.token.Token;

/**
 * SSubmitタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagSSubmitConvert extends TagSConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {
        nw.renameKeyString("styleId", "id");
        getAndDelParam(nw, "clientValidate");
        String propertyValue = getAndDelParam(nw, "property");
        nw.addKeyValue("type", "submit");
        nw.addKeyValue("uri", propertyValue);

        List<Node> childList = NodeUtil.getBodyAsCustomTag(nw);
        Node childTag = null;
            for (Node childNode : childList) {
                if (!"".equals(childNode.getStringWithoutCRLF().trim())
                        && childNode.getStringWithoutCRLF().contains(":")) {
                    childTag = childNode;
                    break;
                }
            }

            //  SSubmitタグの中にBeanMessageタグが入っている場合、変換後、BeanMessageタグの値をNablarchのSubmitタグのvalue属性に設定する
            if (childTag != null) {
                NodeWrapper nwChild = new NodeWrapper(childTag);
                if (nwChild.renameKeyString("key", "messageId")) {
                    nwChild.replaceTag("bean:", "n:");
                    String messageId = nwChild.getValueAsString("messageId").replace(".", "");
                    String cSetTag = "<c:set var=\"" + messageId + "\">" + "\n"
                            + nwChild.getNode().getStringWithoutCRLF()
                            + "\n" + "</c:set>" + "\n";

                    nw.addKeyValue("value", "${" + messageId + "}");
                    NodeUtil.insertPrev(nw.getNode(), cSetTag);

                    List<Node> list = NodeUtil.getBodyAsCustomTag(nw);
                    for(Node childNode:list) {
                        NodeUtil.removeChildNode(childNode);
                    }
                }

            } else {
                nw.addKeyValue("value", childList.get(0).getString());

                int size = nw.getNode().getParams().size();
                Token t = new Token(Token.SYMBOL, "/");
                nw.getNode().getParams().add(size - 1, t);

                for (Node childNode : childList) {
                    NodeUtil.removeChildNode(childNode);
                }
            }

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {
        nw.renameTagName("n:submit");
    }

    @Override
    protected void convertEndProc(NodeWrapper nw) {
        NodeUtil.removeChildNode(nw.getNode());
    }
}
