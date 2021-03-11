package jp.co.tis.s2n.jspConverter.convert.tag.tis;

import jp.co.tis.s2n.jspConverter.node.NodeWrapper;
import jp.co.tis.s2n.jspConverter.token.Token;

/**
 * TisButtonタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagTisButtonConvert extends TagTisConvertBase {
    @Override
    protected void convertStartProc(NodeWrapper nw) {

        nw.renameKeyString("styleClass", "cssClass");
        nw.renameKeyString("styleId", "id");
        nw.addKeyValue("uri", nw.getValueAsString("name"));
        logNotSupported(nw, "keyValue");
        logNotSupported(nw, "unEditableName");
        logNotSupported(nw, "unEditableValue");
        logNotSupported(nw, "unEditableKeyValue");
        logNotSupported(nw, "unEditable");
        logNotSupported(nw, "indexed");
        getAndDelParam(nw, "keyValue");
        getAndDelParam(nw, "unEditableName");
        getAndDelParam(nw, "unEditableValue");
        getAndDelParam(nw, "unEditableKeyValue");
        getAndDelParam(nw, "unEditable");
        getAndDelParam(nw, "indexed");

        int size = nw.getNode().getParams().size();
        nw.getNode().getParams().remove(size - 2);
        Token t = null;
        if (nw.getValueAsString("value") != null && !"".equals(nw.getValueAsString("value"))) {
            t = new Token(Token.STRING1, nw.getValueAsString("value") + "</n:button>");
        } else {
            t = new Token(Token.STRING1, "ボタン</n:button>");
        }
        nw.getNode().getParams().add(t);
    }

}
