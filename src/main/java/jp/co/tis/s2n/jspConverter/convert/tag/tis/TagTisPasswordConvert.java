package jp.co.tis.s2n.jspConverter.convert.tag.tis;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * TisPasswordタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagTisPasswordConvert extends TagTisInputBase {
    @Override
    protected void convertStartProc(NodeWrapper nw) {
        //入力系共通処理
        super.convertStartProc(nw);
        nw.removeKeyValue("value");
        logNotSupported(nw, "value");
    }
}
