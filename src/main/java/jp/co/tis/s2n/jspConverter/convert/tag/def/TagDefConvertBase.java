package jp.co.tis.s2n.jspConverter.convert.tag.def;

import jp.co.tis.s2n.jspConverter.convert.tag.TagConvertBase;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * Defaultタグ変換用ベースクラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagDefConvertBase extends TagConvertBase {

    @Override
    protected void convertTagName(NodeWrapper nw) {
        //defaultは何もやらない
    }

    @Override
    protected void convertStartProc(NodeWrapper nw) {
        //defaultは何もやらない
    }

    @Override
    protected void convertEndProc(NodeWrapper nw) {
        //defaultは何もやらない

    }

}
