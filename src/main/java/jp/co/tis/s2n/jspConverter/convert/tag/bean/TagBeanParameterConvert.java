package jp.co.tis.s2n.jspConverter.convert.tag.bean;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * BeanParameterタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagBeanParameterConvert extends TagBeanConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {
        nw.renameKeyString("id", "var");
        nw.removeKeyValue("value");

        String name = getAndDelParam(nw, "name");
        writeJSTLImplicitObjectToValue(nw, "param", name);

        //varにある変数をJSPのページスコープの変数にも書き込む
        writeJSPPageScopeToJSTLParamVar(nw);
    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

        nw.renameTagName("c:set");
    }
}
