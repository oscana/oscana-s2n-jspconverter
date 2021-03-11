package jp.co.tis.s2n.jspConverter.convert.tag.html;

import jp.co.tis.s2n.jspConverter.node.Node;
import jp.co.tis.s2n.jspConverter.node.NodeUtil;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;
import jp.co.tis.s2n.jspConverter.token.Token;

/**
 * HtmlOptionsCollectionタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlOptionsCollectionConvert extends TagHtmlConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {
        String name = getAndDelParam(nw, "name");
        String property = getAndDelParam(nw, "property");

        String trgName = createJSTLValueAddBlacket(name, property);

        String valiable = "voc_" + makeVnameForScriptLet(trgName);
        NodeUtil.insertPrev(nw.getNode(), Node.create(new Token(Token.JSP_COMMENT,
                "<c:forEach var=\"" + valiable + "\" items=\"" + trgName.replace("form.", "") + "\">")));
        NodeUtil.insertAfter(nw.getNode(), Node.create(new Token(Token.JSP_COMMENT, "</c:forEach>")));
        NodeUtil.insertAfter(nw.getNode(), Node.create(new Token(Token.NAME,
                "<option value=\"${" + valiable + ".value}\">${" + valiable + ".label}</option>")));

        nw.removeAllTokens();

    }

}
