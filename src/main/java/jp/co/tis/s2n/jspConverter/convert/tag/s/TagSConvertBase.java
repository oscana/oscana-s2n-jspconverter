package jp.co.tis.s2n.jspConverter.convert.tag.s;

import jp.co.tis.s2n.jspConverter.convert.tag.TagConvertBase;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * Sタグ変換用ベースクラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagSConvertBase extends TagConvertBase {

    protected void convertTagName(NodeWrapper nw) {
        nw.replaceTag("s:", "n:");
    }

    protected void convertStartProc(NodeWrapper nw) {
        //defaultは何もやらない
    }

    protected void convertEndProc(NodeWrapper nw) {

    }

}
