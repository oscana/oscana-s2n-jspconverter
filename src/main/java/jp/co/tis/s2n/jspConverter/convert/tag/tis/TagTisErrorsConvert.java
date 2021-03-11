package jp.co.tis.s2n.jspConverter.convert.tag.tis;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * TisErrorsタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagTisErrorsConvert extends TagTisConvertBase {

    private boolean hasProp = false;

    @Override
    protected void convertStartProc(NodeWrapper nw) {

        if (nw.isContainsKey("property")) {
            nw.renameKeyString("property", "name");
            hasProp = true;
        } else {

        }
    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

        if (hasProp) {
            nw.renameTagName("n:error");
        } else {
            nw.renameTagName("n:errors");

        }

    }
}
