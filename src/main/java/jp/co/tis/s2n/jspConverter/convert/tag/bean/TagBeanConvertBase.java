package jp.co.tis.s2n.jspConverter.convert.tag.bean;

import jp.co.tis.s2n.jspConverter.convert.tag.TagConvertBase;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;
import jp.co.tis.s2n.jspConverter.token.Token;

/**
 * Beanタグ変換用ベースクラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagBeanConvertBase extends TagConvertBase {

    @Override
    protected void convertTagName(NodeWrapper nw) {

        for (Token token : nw.getNode().getParams()) {
            if (token.getText().startsWith("bean")) {
                token.setText(token.getText().replace("bean:", "n:"));
            }
        }
    }

    @Override
    protected void convertStartProc(NodeWrapper nw) {
        //defaultは何もやらない
    }

    @Override
    protected void convertEndProc(NodeWrapper nw) {

    }

}
