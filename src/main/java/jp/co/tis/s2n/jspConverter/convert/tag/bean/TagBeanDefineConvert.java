package jp.co.tis.s2n.jspConverter.convert.tag.bean;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * BeanDefineタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagBeanDefineConvert extends TagBeanConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {
        nw.renameKeyString("id", "var");
        String defaultVale = getAndDelParam(nw, "value");
        nw.renameKeyString("name", "value");
        nw.renameKeyString("toScope ", "scope");

        String value = nw.getValueAsString("value");
        String scope = getAndDelParam(nw, "scope");
        String prop = getAndDelParam(nw, "property");

        if (nw.isContainsKey("value")) {
            nw.setValueAsString("value", createJSTLValueStr(nw, convJSTLScope(scope), value, prop));
        } else {
            nw.addKeyValue("value", defaultVale);
        }

        //varにある変数をJSPのページスコープの変数にも書き込む
        writeJSPPageScopeToJSTLParamVar(nw);

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

        nw.renameTagName("c:set");
    }
}
