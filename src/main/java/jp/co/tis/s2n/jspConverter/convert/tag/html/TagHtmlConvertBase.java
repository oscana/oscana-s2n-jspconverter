package jp.co.tis.s2n.jspConverter.convert.tag.html;

import jp.co.tis.s2n.jspConverter.convert.tag.TagConvertBase;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * Htmlタグ変換用ベースクラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlConvertBase extends TagConvertBase {

    public String selectTagName;

    @Override
    protected void convertTagName(NodeWrapper nw) {
        nw.replaceTag("html:", "n:");
    }

    @Override
    protected void convertStartProc(NodeWrapper nw) {
        //defaultは何もやらない
    }

    @Override
    protected void convertEndProc(NodeWrapper nw) {

    }

}
