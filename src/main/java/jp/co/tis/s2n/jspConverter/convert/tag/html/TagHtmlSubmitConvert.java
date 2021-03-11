package jp.co.tis.s2n.jspConverter.convert.tag.html;

import java.util.List;

import jp.co.tis.s2n.converterCommon.util.StringUtils;
import jp.co.tis.s2n.jspConverter.node.Node;
import jp.co.tis.s2n.jspConverter.node.NodeUtil;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * HtmlSubmitタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlSubmitConvert extends TagHtmlConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {
        String curModule = getCurModule();

        String action = getCommonProperty(TagHtmlFormConvert.KEY_FORM);
        nw.renameKeyString("property", "type");
        nw.renameKeyString("styleId", "id");
        nw.addKeyValue("uri", convStrutsActionPath(StringUtils.addPath(curModule, action)));

        //type省略していたら自動追加する
        if (StringUtils.isEmpty(nw.getValueAsString("type"))) {
            nw.addKeyValue("type", "submit");
        }

        // ボタン名を画面上でうまく表示するようにする
        List<Node> childList = NodeUtil.getBodyAsCustomTag(nw);
        Node childTag = null;
            for (Node childNode : childList) {
                if (childNode.getStringWithoutCRLF() != null && !"".equals(childNode.getStringWithoutCRLF().trim())) {
                    childTag = childNode;
                    break;
                }
            }

            //  HtmlSubmitタグの中にBeanMessageタグが入っている場合、変換後、BeanMessageタグの値をNablarchのSubmitタグのvalue属性に設定する
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


        }
    }
}
