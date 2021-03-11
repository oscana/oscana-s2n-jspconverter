package jp.co.tis.s2n.jspConverter.convert.tag.logic;

import jp.co.tis.s2n.converterCommon.util.StringUtils;
import jp.co.tis.s2n.jspConverter.convert.tag.TagConvertBase;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * Logicタグ変換用ベースクラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagLogicConvertBase extends TagConvertBase {

    @Override
    protected void convertTagName(NodeWrapper nw) {
        renameTagName(nw.getNode(), "logic:", "n:");
    }

    @Override
    protected void convertStartProc(NodeWrapper nw) {
        //defaultは何もやらない
    }

    @Override
    protected void convertEndProc(NodeWrapper nw) {

    }

    /**
     * scope,name,property,cookie,header,parameterからなるパラメータに対するEL式を取得する。
     *
     * @param nw ノードラッパ
     * @return EL式
     */
    protected String makeELExpressionFromStdParam(NodeWrapper nw) {
        String scope = getAndDelParam(nw, "scope");
        String name = getAndDelParam(nw, "name");
        name = convertScriptLetToJSTLStr(name);
        String property = getAndDelParam(nw, "property");

        String cookie = getAndDelParam(nw, "cookie");
        getAndDelParam(nw, "header");
        String parameter = getAndDelParam(nw, "parameter");

        String expression = null;
        if (!StringUtils.isEmpty(name)) {
            expression = createJSTLValueStrNoBlacket(nw, convJSTLScope(scope), name, property);
        } else if (!StringUtils.isEmpty(cookie)) {
            expression = createJSTLValueStrNoBlacket(nw, "cookie", cookie); //cookieのあとにvalueを付けるか否か？
        } else if (!StringUtils.isEmpty(parameter)) {
            expression = createJSTLValueStrNoBlacket(nw, "param", parameter);
        }
        return expression;
    }

}
