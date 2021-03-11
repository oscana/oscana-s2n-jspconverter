package jp.co.tis.s2n.jspConverter.convert.tag.html;

import java.util.List;

import jp.co.tis.s2n.jspConverter.node.Node;
import jp.co.tis.s2n.jspConverter.node.NodeUtil;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;
import jp.co.tis.s2n.jspConverter.token.Token;

/**
 * HtmlRadioタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlRadioConvert extends TagHtmlInputBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        //入力系共通処理
        super.convertStartProc(nw);

        int size = nw.getNode().getParams().size();
        Token token = nw.getNode().getParams().get(size - 2);
        if ("/".equals(token.getText())) {
            nw.addKeyValue("label", "");
        } else {
            nw.setValueAsString("value", "${" + NodeUtil.logicIterateTagId + ".value}");
            nw.addKeyValue("label", "${" + NodeUtil.logicIterateTagId + ".label}");
            int sizeTemp = nw.getNode().getParams().size();
            Token t = new Token(Token.SYMBOL, "/");
            nw.getNode().getParams().add(sizeTemp - 1, t);

            List<Node> list = NodeUtil.getBodyAsCustomTag(nw);
            for (Node childNode : list) {
                NodeUtil.removeChildNode(childNode);
            }
        }
    }

    @Override
    protected void convertTagName(NodeWrapper nw) {
        nw.renameTagName("n:radioButton");
    }

    @Override
    protected void convertEndProc(NodeWrapper nw) {
        NodeUtil.removeChildNode(nw.getNode());
    }
}
