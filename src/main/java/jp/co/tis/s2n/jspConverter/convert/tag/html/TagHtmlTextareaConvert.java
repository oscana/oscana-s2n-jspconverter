package jp.co.tis.s2n.jspConverter.convert.tag.html;

import jp.co.tis.s2n.converterCommon.util.StringUtils;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * HtmlTextareaタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlTextareaConvert extends TagHtmlInputBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        //入力系共通処理
        super.convertStartProc(nw);

        if (StringUtils.isEmpty(nw.getValueAsString("cols"))) {
            nw.addKeyValue("cols", "20");//html5の初期値
        }
        if (StringUtils.isEmpty(nw.getValueAsString("rows"))) {
            nw.addKeyValue("rows", "2");//html5の初期値
        }

    }
}
