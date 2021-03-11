package jp.co.tis.s2n.jspConverter.convert.tag.tis;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * 入力系の共通処理。
 *
 * @author Fumihiko Yamamoto
 */
public abstract class TagTisInputBase extends TagTisConvertBase {
    @Override
    protected void convertStartProc(NodeWrapper nw) {

        s2nStandardInputWidgetConvertProc(nw);
    }
}
