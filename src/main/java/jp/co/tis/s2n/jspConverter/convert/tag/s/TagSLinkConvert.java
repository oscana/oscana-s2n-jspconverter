package jp.co.tis.s2n.jspConverter.convert.tag.s;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * SLinkタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagSLinkConvert extends TagSConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        nw.removeKeyValue("useLocalEncoding");
        String curModule = getCurModule();

        String sAction = getAndDelParam(nw, "action");
        String sPage = getAndDelParam(nw, "page");
        String forward = getAndDelParam(nw, "forward");
        String href = getAndDelParam(nw, "href");
        getAndDelParam(nw, "tabindex");
        getAndDelParam(nw, "transaction");
        nw.renameKeyString("styleClass", "cssClass");
        nw.renameKeyString("styleId", "id");

        String sModule = "";
        sModule = curModule;

        String trgPath = convertPath(sAction, sPage, forward, href, sModule);
        nw.addKeyValue("href", trgPath);

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

        nw.replaceTag("s:link", "n:a");

    }

}
