package jp.co.tis.s2n.jspConverter.convert.tag.tis;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * TisHiddenタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagTisHiddenConvert extends TagTisConvertBase {
    protected void convertStartProc(NodeWrapper nw) {
        nw.renameKeyString("styleId", "id");
        getAndDelParam(nw, "value");
        if (nw.isContainsKey("name") && nw.isContainsKey("property")) {
            nw.setValueAsString("name", nw.getValueAsString("name") + "." + getAndDelParam(nw, "property"));
        } else {
            nw.renameKeyString("property", "name");
        }
    }

    @Override
    protected void convertTagName(NodeWrapper nw) {
        nw.renameTagName("n:hidden");
    }
}
