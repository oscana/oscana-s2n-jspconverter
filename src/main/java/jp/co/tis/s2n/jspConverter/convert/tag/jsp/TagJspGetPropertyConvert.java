package jp.co.tis.s2n.jspConverter.convert.tag.jsp;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * JspGetPropertyタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagJspGetPropertyConvert extends TagJspConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        if (nw.isContainsKey("property")) {
            nw.setValueAsString("name", nw.getValueAsString("name") + "." + getAndDelParam(nw, "property"));
        }
    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

        nw.renameTagName("n:write");
    }

}
