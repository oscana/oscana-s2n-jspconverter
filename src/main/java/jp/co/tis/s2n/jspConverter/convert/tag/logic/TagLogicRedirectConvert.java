package jp.co.tis.s2n.jspConverter.convert.tag.logic;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * LogicRedirectタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagLogicRedirectConvert extends TagLogicConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        String action = getAndDelParam(nw, "action");
        String href = getAndDelParam(nw, "href");
        String forward = getAndDelParam(nw, "forward");
        String page = getAndDelParam(nw, "page");

        String trgUrl = convertPath(action, page, forward, href, getCurModule());
        nw.addKeyValue("url", trgUrl);

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {
        nw.renameTagName("c:redirect");
    }

}
