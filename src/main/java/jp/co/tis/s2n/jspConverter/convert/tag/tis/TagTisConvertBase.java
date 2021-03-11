package jp.co.tis.s2n.jspConverter.convert.tag.tis;

import jp.co.tis.s2n.jspConverter.convert.tag.TagConvertBase;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * Tisタグ変換用ベースクラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagTisConvertBase extends TagConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {

    }

    @Override
    protected void convertTagName(NodeWrapper nw) {

        renameTagName(nw.getNode(), "tis:", "n:");

    }

    protected void convertEndProc(NodeWrapper nw) {

    }

}
