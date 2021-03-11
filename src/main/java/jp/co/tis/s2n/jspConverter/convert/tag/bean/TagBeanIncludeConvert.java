package jp.co.tis.s2n.jspConverter.convert.tag.bean;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * BeanIncludeタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagBeanIncludeConvert extends TagBeanConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {
        nw.renameKeyString("id", "var");

        String url = null;
        if (nw.isContainsKey("page")) {
            url = getAndDelParam(nw, "page");
        } else if (nw.isContainsKey("href")) {
            url = getAndDelParam(nw, "href");
        }
        nw.addKeyValue("url", url);

        //varにある変数をJSPのページスコープの変数にも書き込む
        writeJSPPageScopeToJSTLParamVar(nw);

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

        nw.renameTagName("c:import");
    }
}
