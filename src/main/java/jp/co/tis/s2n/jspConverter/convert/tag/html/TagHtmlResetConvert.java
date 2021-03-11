package jp.co.tis.s2n.jspConverter.convert.tag.html;

import java.util.List;
import java.util.Optional;

import jp.co.tis.s2n.converterCommon.util.CustomTagUtils.CustomTagType;
import jp.co.tis.s2n.jspConverter.node.Node;
import jp.co.tis.s2n.jspConverter.node.NodeUtil;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * HtmlResetタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlResetConvert extends TagHtmlConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        nw.renameKeyString("styleId", "id");
        if (nw.getNodeType() == CustomTagType.StartTag) {

            //ボディタグの取得
            List<Node> list = NodeUtil.getBodyAsCustomTag(nw);
            //タグで囲まれた領域はコメントアウト
            NodeUtil.commentoutBody(list);

            Optional<Node> f = list.stream().filter(node -> "bean:message".equals(new NodeWrapper(node).getTagName()))
                    .findFirst();

            if (f.isPresent()) {
                //固定文字列を挿入
                NodeUtil.insertPrev(nw.getNode(), "<input type=\"reset\" value=\"<n:message messageId=\""
                        + new NodeWrapper(f.get()).getValueAsString("key") + "\"/>\">");
            } else {
                StringBuilder sb = new StringBuilder();
                for(Node node : list) {
                    sb.append(node.getString());
                }
                //固定文字列を挿入
                NodeUtil.insertPrev(nw.getNode(), "<input type=\"reset\" value=\""+sb.toString()+"\"/>");
            }
        } else {
            //固定文字列を挿入
            NodeUtil.insertPrev(nw.getNode(), "<input type=\"reset\" />");

        }
        //Startタグは削除
        nw.removeAllTokens();

    }

    @Override
    protected void convertEndProc(NodeWrapper nw) {
        nw.removeAllTokens();

    }

}
