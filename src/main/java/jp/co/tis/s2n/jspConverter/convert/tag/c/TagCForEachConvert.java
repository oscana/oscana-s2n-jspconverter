package jp.co.tis.s2n.jspConverter.convert.tag.c;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * CForEachタグ変換用クラス。
 *
 * @author Ko Ho
 *
 */
public class TagCForEachConvert extends TagCConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        if (nw.isContainsKey("varStatus")) {
            commonStore.put("varStatus", nw.getValueAsString("varStatus"));
        } else {
            nw.addKeyValue("varStatus", "s");
            commonStore.put("varStatus", "s");
        }
    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

    }

    @Override
    protected void convertEndProc(NodeWrapper nw) {
        commonStore.remove("varStatus");
    }

}
