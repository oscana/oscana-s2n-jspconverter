package jp.co.tis.s2n.jspConverter.convert.tag.tis;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;
import jp.co.tis.s2n.jspConverter.token.Token;

/**
 * TisButtonNonSubmitタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagTisButtonNonSubmitConvert extends TagTisConvertBase {
    @Override
    protected void convertStartProc(NodeWrapper nw) {

        nw.addKeyValue("uri", "#");
        nw.renameKeyString("styleClass", "cssClass");
        nw.renameKeyString("styleId", "id");

        logNotSupported(nw, "keyValue");
        logNotSupported(nw, "unEditableName");
        logNotSupported(nw, "unEditableValue");
        logNotSupported(nw, "unEditableKeyValue");
        logNotSupported(nw, "unEditable");

        nw.removeKeyValue("keyValue");
        nw.removeKeyValue("unEditable");
        nw.removeKeyValue("unEditableKeyValue");
        nw.removeKeyValue("unEditableName");
        nw.removeKeyValue("unEditableValue");

        // 終了タグを追加する
        int size = nw.getNode().getParams().size();
        nw.getNode().getParams().remove(size - 2);
        Token endTag = new Token(Token.STRING1, nw.getValueAsString("value") + "</n:button>");
        nw.getNode().getParams().add(endTag);
    }

    @Override
    protected void convertTagName(NodeWrapper nw) {
        nw.renameTagName("n:button");
    }
}
