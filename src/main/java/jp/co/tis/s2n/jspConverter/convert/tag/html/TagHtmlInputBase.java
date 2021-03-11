package jp.co.tis.s2n.jspConverter.convert.tag.html;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * 入力系タグの共通処理。
 *
 * @author Fumihiko Yamamoto
 *
 */
public abstract class TagHtmlInputBase extends TagHtmlConvertBase {
    @Override
    protected void convertStartProc(NodeWrapper nw) {

        s2nStandardInputWidgetConvertProc(nw);
    }
}
