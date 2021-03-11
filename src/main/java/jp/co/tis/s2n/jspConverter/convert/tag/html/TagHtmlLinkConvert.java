package jp.co.tis.s2n.jspConverter.convert.tag.html;

import jp.co.tis.s2n.converterCommon.util.StringUtils;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * HtmlLinkタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlLinkConvert extends TagHtmlConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        nw.removeKeyValue("useLocalEncoding");
        nw.renameKeyString("styleId", "id");
        String curModule = getCurModule();

        String sAction = getAndDelParam(nw, "action");
        String sPage = getAndDelParam(nw, "page");
        String forward = getAndDelParam(nw, "forward");
        String module = getAndDelParam(nw, "module");

        getAndDelParam(nw, "paramId");
        getAndDelParam(nw, "paramName");
        getAndDelParam(nw, "paramProperty");

        logNotSupported(nw, "forward");

        String sModule = "";
        if (!StringUtils.isEmpty(module)) {
            sModule = module;
        } else {
            sModule = curModule;
        }

        String trgPath = convertPath(sAction, sPage, forward, null, sModule);
        nw.addKeyValue("href", trgPath);

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

        nw.renameTagName("n:a");

    }

}
