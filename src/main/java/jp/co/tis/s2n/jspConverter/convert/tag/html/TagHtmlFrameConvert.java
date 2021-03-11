package jp.co.tis.s2n.jspConverter.convert.tag.html;

import jp.co.tis.s2n.converterCommon.util.StringUtils;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * HtmlFrameタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlFrameConvert extends TagHtmlConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        String curModule = getCurModule();

        String sAction = getAndDelParam(nw, "action");
        String sPage = getAndDelParam(nw, "page");
        String forward = getAndDelParam(nw, "forward");
        String module = getAndDelParam(nw, "module");
        String href = getAndDelParam(nw, "href");

        String sModule = "";
        if (!StringUtils.isEmpty(module)) {
            sModule = module;
        } else {
            sModule = curModule;
        }

        nw.renameKeyString("frameName", "name");

        String trgPath = convertPath(sAction, sPage, forward, href, sModule);
        nw.addKeyValue("src", trgPath);

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

        nw.replaceTag("html:", "");
    }

}
