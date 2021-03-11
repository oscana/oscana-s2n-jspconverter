package jp.co.tis.s2n.jspConverter.convert.tag.html;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * HtmlMultiboxタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlMultiboxConvert extends TagHtmlInputBase {
    @Override
    protected void convertStartProc(NodeWrapper nw) {

        nw.renameKeyString("styleId", "id");
        nw.renameKeyString("property", "name");
        nw.renameKeyString("errorStyle", "errorCss");

        //タグボディをパラメータに変換
        assignBodyTagToTagParameter(nw, "label");

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {
        nw.renameTagName("n:checkbox");

    }
}
