package jp.co.tis.s2n.jspConverter.convert.tag.html;

import jp.co.tis.s2n.converterCommon.util.StringUtils;
import jp.co.tis.s2n.jspConverter.node.Node;
import jp.co.tis.s2n.jspConverter.node.NodeUtil;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;
import jp.co.tis.s2n.jspConverter.token.Token;

/**
 * HtmlOptionsタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagHtmlOptionsConvert extends TagHtmlConvertBase {

    @Override
    protected void convertStartProc(NodeWrapper nw) {
        String collection = getAndDelParam(nw, "collection");
        String name = getAndDelParam(nw, "name");
        String property = getAndDelParam(nw, "property");

        if (!StringUtils.isEmpty(name)) {

            String trgName = createJSTLValueAddBlacket(name, property);

            String valiable = "vn_" + makeVnameForScriptLet(trgName);
            NodeUtil.insertPrev(nw.getNode(), Node.create(new Token(Token.JSP_COMMENT,
                    "<c:forEach var=\"" + valiable + "\" items=\"" + trgName.replace("form.", "") + "\">")));
            NodeUtil.insertAfter(nw.getNode(), Node.create(new Token(Token.JSP_COMMENT, "</c:forEach>")));
            NodeUtil.insertAfter(nw.getNode(), Node.create(
                    new Token(Token.NAME, "<option value=\"${" + valiable + "}\">${" + valiable + "}</option>")));
        } else if (!StringUtils.isEmpty(collection)) {
            String valiable = "vc_" + collection;
            NodeUtil.insertPrev(nw.getNode(), Node.create(new Token(Token.JSP_COMMENT,
                    "<c:forEach var=\"" + valiable + "\" items=\"" + collection.replace("form.", "") + "\">")));
            NodeUtil.insertAfter(nw.getNode(), Node.create(new Token(Token.JSP_COMMENT, "</c:forEach>")));
            NodeUtil.insertAfter(nw.getNode(), Node.create(new Token(Token.NAME,
                    "<option value=\"${" + valiable + ".value}\">${" + valiable + ".label}</option>")));

        }

        nw.removeAllTokens();

    }

}
