package jp.co.tis.s2n.jspConverter.convert.tag.bean;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * BeanCookieタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagBeanCookieConvert extends TagBeanConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        nw.renameKeyString("id", "var");
        nw.removeKeyValue("value");

        String name = getAndDelParam(nw, "name");
        writeJSTLImplicitObjectToValue(nw, "cookie", name);
    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

        nw.renameTagName("n:set");
    }

}
