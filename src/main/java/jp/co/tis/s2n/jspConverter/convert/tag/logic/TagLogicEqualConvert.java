package jp.co.tis.s2n.jspConverter.convert.tag.logic;

/**
 * LogicEqualタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagLogicEqualConvert extends TagLogicComparisonConvertBase {

    @Override
    protected String getOperator() {

        return "==";
    }

}
