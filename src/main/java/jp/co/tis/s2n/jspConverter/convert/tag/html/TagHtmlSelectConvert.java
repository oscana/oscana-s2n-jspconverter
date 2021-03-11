package jp.co.tis.s2n.jspConverter.convert.tag.html;

import jp.co.tis.s2n.jspConverter.node.NodeUtil;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * HtmlSelectタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlSelectConvert extends TagHtmlInputBase {
    @Override
    protected void convertStartProc(NodeWrapper nw) {

        NodeUtil.selectTagName = nw.getValueAsString("property");

        //入力系共通処理
        super.convertStartProc(nw);

        if (nw.isContainsKey("multiple")) {
            nw.setValueAsString("multiple", "multiple");
        }

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

        nw.replaceTag("html:", "");

    }

}
