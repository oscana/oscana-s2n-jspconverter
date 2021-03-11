package jp.co.tis.s2n.jspConverter.convert.tag.html;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * HtmlButtonタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlButtonConvert extends TagHtmlConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        nw.addKeyValue("type", "button");
        nw.renameKeyString("property", "name");

    }

    @Override
    protected void convertEndProc(NodeWrapper nw) {
        nw.renameTagName("input");

    }

}
