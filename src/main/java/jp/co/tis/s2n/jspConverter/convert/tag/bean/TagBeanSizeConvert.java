package jp.co.tis.s2n.jspConverter.convert.tag.bean;

import jp.co.tis.s2n.converterCommon.util.StringUtils;
import jp.co.tis.s2n.jspConverter.convert.tag.JSTLString;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * BeanSizeタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagBeanSizeConvert extends TagBeanConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {
        nw.renameKeyString("id", "var");

        String collection = getAndDelParam(nw, "collection");
        String scope = getAndDelParam(nw, "scope");

        String name = getAndDelParam(nw, "name");
        String property = getAndDelParam(nw, "property");

        String list;
        if (!StringUtils.isEmpty(collection)) {
            JSTLString jstr = new JSTLString(collection);
            list = jstr.getQuotedString();
        } else {
            list = createJSTLValueStrNoBlacket(nw, convJSTLScope(scope), name, property);
        }

        nw.addKeyValue("value", createJSTLValueStrNoBlacket(nw, "${fn:length(" + list + ")}"));

        //varにある変数をJSPのページスコープの変数にも書き込む
        writeJSPPageScopeToJSTLParamVar(nw);
    }

    @Override
    protected void convertTagName(NodeWrapper nw) {
        nw.renameTagName("c:set");
    }
}
