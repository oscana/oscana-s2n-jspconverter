package jp.co.tis.s2n.jspConverter.convert.tag.html;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * HtmlBaseタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlBaseConvert extends TagHtmlConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        nw.addKeyValue("href", "<c:out value=\"${pageContext.request.requestURL}\"/>");

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

        nw.replaceTag("html:", "");

    }

}
