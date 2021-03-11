package jp.co.tis.s2n.jspConverter.convert.tag;

import java.util.function.BiFunction;

import jp.co.tis.s2n.jspConverter.convert.ConvertStruts2Nablarch;

/**
 * TagConvertBaseのインスタンスを取得する。
 *
 * @author I Ko
 *
 */
public abstract class TagConvertBaseFactory {

    /**
     * TagConvertBaseのインスタンスを取得する。
     * @param className クラス名
     * @return TagConvertBaseのインスタンス
     */
    public static TagConvertBase getInstance(String className) {
        TagConvertBase conv = null;
        try {
            Class<?> clazz = Class.forName(className);
            conv = (TagConvertBase) clazz.getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            System.err.println(className + " is not found.");
        }
        return conv;
    }

    /**
     * タグコンバータのクラス名を求める。<br>
     * tagLibがnestedの場合はtagLibNameの変換も行う。
     * @param tagLibName tagLib名
     * @param tagName タグ名
     * @return クラス名
     */
    public static String makeTagConverterClassName(String tagLibName, String tagName) {

        BiFunction<String, String, String> fi = (tLib, tName) -> "jp.co.tis.s2n.jspConverter.convert.tag."
                + tLib + "."
                + "Tag" + headUpString(tLib) + headUpString(tName) + "Convert";

        String className = null;

        if (tagLibName.equals(ConvertStruts2Nablarch.NESTED_TAG_KEY)) {
            for (String cTagLibName : ConvertStruts2Nablarch.NESTED_TRG) {
                String tmpClassName = fi.apply(cTagLibName, tagName);
                try {
                    //タグクラスが見つかったのでこれに確定
                    Class.forName(tmpClassName);
                    className = tmpClassName;
                    break;
                } catch (ClassNotFoundException e) {
                    //タグがない
                }
            }
            if (className == null) {
                className = fi.apply(tagLibName, tagName);
            }
        } else {
            className = fi.apply(tagLibName, tagName);

        }
        return className;
    }

    protected static String headUpString(String instr) {

        String str1 = instr.substring(0, 1).toUpperCase();
        String str2 = instr.substring(1);
        return str1 + str2;

    }
}
