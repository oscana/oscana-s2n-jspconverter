package jp.co.tis.s2n.jspConverter.convert.tag.html;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * HtmlHtmlタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlHtmlConvert extends TagHtmlConvertBase {

    @Override
    protected void convertTagName(NodeWrapper nw) {
        nw.replaceTag("html:", "");
    }

}
