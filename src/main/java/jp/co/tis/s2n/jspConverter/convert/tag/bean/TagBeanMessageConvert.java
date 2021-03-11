package jp.co.tis.s2n.jspConverter.convert.tag.bean;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * BeanMessageタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagBeanMessageConvert extends TagBeanConvertBase {
    @Override
    protected void convertStartProc(NodeWrapper nw) {

        nw.renameKeyString("key", "messageId");
        nw.removeKeyValue("bundle");

    }

}
