package jp.co.tis.s2n.jspConverter.convert.tag.bean;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * BeanWriteタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagBeanWriteConvert extends TagBeanConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        getAndDelParam(nw, "scope");
        nw.removeKeyValue("ignore");

        if (nw.isContainsKey("property")) {
            nw.setValueAsString("name", nw.getValueAsString("name") + "." + getAndDelParam(nw, "property"));
        }

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

        nw.renameTagName("n:write");
    }

}
