package jp.co.tis.s2n.jspConverter.convert.tag.logic;

/**
 * LogicNotEqualタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagLogicNotEqualConvert extends TagLogicComparisonConvertBase {

    @Override
    protected String getOperator() {
        return "!=";
    }

}
