package jp.co.tis.s2n.jspConverter.convert.tag.tis;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * TisFileUploadタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagTisFileUploadConvert extends TagTisInputBase {
    @Override
    protected void convertStartProc(NodeWrapper nw) {
        //入力系共通処理
        s2nStandardInputWidgetConvertProc(nw);

        logNotSupported(nw, "list");
        logNotSupported(nw, "max");
        logNotSupported(nw, "accept");
        logNotSupported(nw, "remove");
        logNotSupported(nw, "selected");
        logNotSupported(nw, "duplicate");
        logNotSupported(nw, "onFileSelect");
        logNotSupported(nw, "afterFileSelect");
        logNotSupported(nw, "onFileAppend");
        logNotSupported(nw, "afterFileAppend");
        logNotSupported(nw, "onFileRemove");
        logNotSupported(nw, "size");

        if (nw.isContainsKey("name") && nw.isContainsKey("property")) {
            String propertyValue = getAndDelParam(nw, "property");
            nw.setValueAsString("name", nw.getValueAsString("name") + "." + propertyValue);
        } else {
            nw.renameKeyString("property", "name");
        }

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

        nw.renameTagName("n:file");

    }

    protected void s2nStandardInputWidgetConvertProc(NodeWrapper nw) {

        nw.renameKeyString("styleId", "id");
        nw.renameKeyString("errorStyleClass", "errorCss");
        nw.renameKeyString("styleClass", "cssClass");
        getAndDelParam(nw, "indexed");
        getAndDelParam(nw, "list");
        getAndDelParam(nw, "max");
        getAndDelParam(nw, "duplicate");
        getAndDelParam(nw, "remove");

    }
}
