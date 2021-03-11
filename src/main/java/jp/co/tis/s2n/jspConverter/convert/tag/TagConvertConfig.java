package jp.co.tis.s2n.jspConverter.convert.tag;

import jp.co.tis.s2n.converterCommon.struts.analyzer.StrutsAnalyzeResult;

/**
 * タグ変換で使用する外部情報格納用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagConvertConfig {
    public String inPath;
    public String inFilePath;
    public StrutsAnalyzeResult[] strutsAnalyzeResult;
    public String paramNamePrefix;

}
