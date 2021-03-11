package jp.co.tis.s2n.jspConverter.convert.tag.logic;

import jp.co.tis.s2n.converterCommon.util.StringUtils;
import jp.co.tis.s2n.jspConverter.node.NodeUtil;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * LogicIterateタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagLogicIterateConvert extends TagLogicConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        NodeUtil.logicIterateTagId = nw.getValueAsString("id");
        nw.renameKeyString("id", "var");

        String name = getAndDelParam(nw, "name");
        String property = getAndDelParam(nw, "property");
        String scope = getAndDelParam(nw, "scope");
        String collection = getAndDelParam(nw, "collection");
        String indexId = getAndDelParam(nw, "indexId");
        String offset = getAndDelParam(nw, "offset");
        String length = getAndDelParam(nw, "length");

        if (!StringUtils.isEmpty(name)) {
            nw.addKeyValue("items", createJSTLValueStr(nw, convJSTLScope(scope), name, property));
        } else if (!StringUtils.isEmpty(collection)) {
            nw.addKeyValue("items", collection);
        }
        if (!StringUtils.isEmpty(indexId)) {
            String statusName = "status_" + indexId;
            nw.addKeyValue("varStatus", statusName);
            NodeUtil.insertAfter(nw.getNode(),
                    "<c:set var=\"" + indexId + "\" value=\"${" + statusName + ".index}\"/>");
            NodeUtil.insertAfter(nw.getNode(),
                    "<%Object " + indexId + "=pageContext.findAttribute(\"" + statusName + ".index\");%>");

        }
        int begin = 0;
        if (!StringUtils.isEmpty(offset)) {
            nw.addKeyValue("begin", offset);
            begin = Integer.parseInt(offset);
        }
        if (!StringUtils.isEmpty(length)) {
            String send = String.valueOf(begin + Integer.parseInt(length) - 1);
            nw.addKeyValue("end", send);
        }
    }

    @Override
    protected void convertTagName(NodeWrapper nw) {
        nw.renameTagName("c:forEach");
    }
}
