package jp.co.tis.s2n.jspConverter.convert.tag.html;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * HtmlTextタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlTextConvert extends TagHtmlInputBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        getAndDelParam(nw, "indexed");
        if (nw.isContainsKey("name")) {
            String propertyValue = nw.getValueAsString("property");

            getAndDelParam(nw, "property");

            nw.renameKeyString("styleId", "id");
            nw.renameKeyString("errorStyleClass", "errorCss");
            nw.renameKeyString("styleClass", "cssClass");
            logNotSupported(nw, "errorStyle");
            logNotSupported(nw, "errorStyleId");
            logNotSupported(nw, "indexed");
            logNotSupported(nw, "codeType");
            logNotSupported(nw, "suffix");
            logNotSupported(nw, "listNumber");

            nw.setValueAsString("name", nw.getValueAsString("name") + "." + propertyValue);
        } else {
            //入力系共通処理
            super.convertStartProc(nw);
        }

    }
}
