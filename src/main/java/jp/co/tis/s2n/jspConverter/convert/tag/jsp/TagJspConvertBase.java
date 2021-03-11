package jp.co.tis.s2n.jspConverter.convert.tag.jsp;

import jp.co.tis.s2n.jspConverter.convert.tag.TagConvertBase;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * Jspタグ変換用ベースクラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagJspConvertBase extends TagConvertBase {

    @Override
    protected void convertTagName(NodeWrapper nw) {

    }

    @Override
    protected void convertStartProc(NodeWrapper nw) {
        //defaultは何もやらない
    }

    @Override
    protected void convertEndProc(NodeWrapper nw) {

    }

}
