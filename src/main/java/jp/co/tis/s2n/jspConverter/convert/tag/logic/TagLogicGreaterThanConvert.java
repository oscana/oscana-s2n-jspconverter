package jp.co.tis.s2n.jspConverter.convert.tag.logic;

/**
 * LogicGreaterThanタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagLogicGreaterThanConvert extends TagLogicComparisonConvertBase {

    @Override
    protected String getOperator() {
        return ">";
    }

}
