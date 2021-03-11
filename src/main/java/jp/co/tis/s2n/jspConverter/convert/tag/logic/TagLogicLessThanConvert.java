package jp.co.tis.s2n.jspConverter.convert.tag.logic;

/**
 * LogicLessThanタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagLogicLessThanConvert extends TagLogicComparisonConvertBase {

    @Override
    protected String getOperator() {
        return "<";
    }
}
