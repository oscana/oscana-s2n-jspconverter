package jp.co.tis.s2n.jspConverter.convert.tag.logic;

/**
 * LogicLessEqualタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagLogicLessEqualConvert extends TagLogicComparisonConvertBase {

    @Override
    protected String getOperator() {
        return "<=";
    }

}
