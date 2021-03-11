package jp.co.tis.s2n.jspConverter.convert.tag.html;

import jp.co.tis.s2n.converterCommon.util.StringUtils;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * HtmlImgタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlImgConvert extends TagHtmlConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        String sAction = getAndDelParam(nw, "action");
        String sPage = getAndDelParam(nw, "page");
        String sSrc = getAndDelParam(nw, "src ");

        nw.renameKeyString("styleId", "id");
        nw.renameKeyString("altKey", "alt");

        //パス書き換え
        nw.addKeyValue("src", convertPath(sAction, sPage, null, sSrc, getCurModule()));

        //必須属性のaltがなければ自動追加
        if (StringUtils.isEmpty(nw.getValueAsString("alt"))) {
            nw.addKeyValue("alt", nw.getValueAsString("src"));
        }

    }
}
