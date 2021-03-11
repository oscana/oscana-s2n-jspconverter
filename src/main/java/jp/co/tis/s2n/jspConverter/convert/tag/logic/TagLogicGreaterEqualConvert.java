package jp.co.tis.s2n.jspConverter.convert.tag.logic;

/**
 * LogicGreaterEqualタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagLogicGreaterEqualConvert extends TagLogicComparisonConvertBase {

    @Override
    protected String getOperator() {
        return ">=";
    }

}
