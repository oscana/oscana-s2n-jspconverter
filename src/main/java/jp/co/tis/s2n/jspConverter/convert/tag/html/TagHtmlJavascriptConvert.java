package jp.co.tis.s2n.jspConverter.convert.tag.html;

import jp.co.tis.s2n.jspConverter.node.NodeUtil;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * HtmlJavascriptタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlJavascriptConvert extends TagHtmlConvertBase {
    @Override
    protected void convertStartProc(NodeWrapper nw) {

        NodeUtil.insertPrev(nw.getNode(), "<b>JavaSciptタグは未対応</b>");

        //Startタグは削除
        nw.removeAllTokens();

    }

    @Override
    protected void convertEndProc(NodeWrapper nw) {
        nw.removeAllTokens();

    }

}
