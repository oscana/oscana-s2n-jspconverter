package jp.co.tis.s2n.jspConverter.convert.tag.html;

import jp.co.tis.s2n.converterCommon.util.StringUtils;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * HtmlImageタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlImageConvert extends TagHtmlConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        String orgSrc = nw.getValueAsString("page");
        nw.renameKeyString("page", "src");
        nw.addKeyValue("alt", orgSrc);
        nw.renameKeyString("styleId", "id");

        nw.setValueAsString("src", StringUtils.addPath(getCurModule(), orgSrc));

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {
        nw.replaceTag("html:image", "n:img");
    }

}
