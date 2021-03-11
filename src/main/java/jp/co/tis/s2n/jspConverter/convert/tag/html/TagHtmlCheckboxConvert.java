package jp.co.tis.s2n.jspConverter.convert.tag.html;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * HtmlCheckboxタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlCheckboxConvert extends TagHtmlInputBase {
    @Override
    protected void convertStartProc(NodeWrapper nw) {

        //入力系共通処理
        super.convertStartProc(nw);

        //タグボディをパラメータに変換
        assignBodyTagToTagParameter(nw, "label");

        if (!nw.isContainsKey("value")) {
            nw.addKeyValue("value", "on");
        }

    }

}
