package jp.co.tis.s2n.jspConverter.convert.tag.html;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * HtmlErrorsタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlErrorsConvert extends TagHtmlConvertBase {

    private boolean hasProp = false;

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        getAndDelParam(nw, "prefix");
        getAndDelParam(nw, "suffix");

        if (nw.isContainsKey("property")) {
            nw.renameKeyString("property", "name");
            hasProp = true;
        } else {

        }

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

        if (hasProp) {
            nw.renameTagName("n:error");
        } else {
            nw.renameTagName("n:errors");

        }

    }

}
