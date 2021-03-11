package jp.co.tis.s2n.jspConverter.convert.tag.def;

import jp.co.tis.s2n.jspConverter.convert.tag.s.TagSFormConvert;
import jp.co.tis.s2n.jspConverter.node.NodeUtil;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * inputタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagDefInputConvert extends TagDefConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        NodeWrapper nwAction = (NodeWrapper) getCommonPropertyAsObject(TagSFormConvert.KEY_FORM);

        String inputType = nw.getValueAsString("type");

        if (nwAction != null && "submit".equals(inputType)) {
            //s:form中にあるinputタグである
            String value = nw.getValueAsString("value");
            String name = nw.getValueAsString("name");
            NodeUtil.insertPrev(nw.getNode(), "<n:button uri=\"" + name + "\">" + value + "</n:button>");
            //Startタグは削除
            nw.removeAllTokens();

        }

    }
}
