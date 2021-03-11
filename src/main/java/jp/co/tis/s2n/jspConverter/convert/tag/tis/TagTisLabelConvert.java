package jp.co.tis.s2n.jspConverter.convert.tag.tis;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * TisLabelタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagTisLabelConvert extends TagTisInputBase {
    @Override
    protected void convertStartProc(NodeWrapper nw) {

        //入力系共通処理
        logNotSupported(nw, "separator");
        logNotSupported(nw, "id");

        getAndDelParam(nw, "separator");
        getAndDelParam(nw, "styleId");
        getAndDelParam(nw, "indexed");

        nw.renameKeyString("property", "name");
        if (nw.isContainsKey("codeType")) {
            nw.renameKeyString("codeType", "codeId");
            getAndDelParam(nw, "name");
        }

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

        if (nw.isContainsKey("codeId")) {
            nw.renameTagName("n:code");
        } else {
            nw.renameTagName("n:write");
        }

    }
}
