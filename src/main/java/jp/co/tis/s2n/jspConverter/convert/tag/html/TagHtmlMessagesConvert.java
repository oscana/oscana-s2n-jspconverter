package jp.co.tis.s2n.jspConverter.convert.tag.html;

import java.util.List;

import jp.co.tis.s2n.converterCommon.util.StringUtils;
import jp.co.tis.s2n.jspConverter.node.Node;
import jp.co.tis.s2n.jspConverter.node.NodeUtil;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * HtmlMessagesタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlMessagesConvert extends TagHtmlConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        String property = getAndDelParam(nw, "property");

        //ボディタグの取得
        List<Node> list = NodeUtil.getBodyAsCustomTag(nw);
        //タグで囲まれた領域はコメントアウト
        NodeUtil.commentoutBody(list);
        //Startタグは削除
        nw.removeAllTokens();
        //固定文字列を挿入
        if (StringUtils.isEmpty(property)) {
            NodeUtil.insertPrev(nw.getNode(), "<n:write name=\"messages\"/> ");
        } else {
            NodeUtil.insertPrev(nw.getNode(), "<n:write name=\"" + property + "\"/> ");
        }

    }

    @Override
    protected void convertEndProc(NodeWrapper nw) {
        nw.removeAllTokens();
    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

    }

}
