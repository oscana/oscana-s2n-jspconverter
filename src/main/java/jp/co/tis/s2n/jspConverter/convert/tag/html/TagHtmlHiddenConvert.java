package jp.co.tis.s2n.jspConverter.convert.tag.html;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * HtmlHiddenタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlHiddenConvert extends TagHtmlConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {
        nw.renameKeyString("styleId", "id");
        getAndDelParam(nw, "value");
        nw.renameKeyString("property", "name");

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

        nw.renameTagName("n:hidden");

    }

}
