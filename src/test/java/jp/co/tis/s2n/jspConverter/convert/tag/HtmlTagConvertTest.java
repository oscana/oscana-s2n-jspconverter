package jp.co.tis.s2n.jspConverter.convert.tag;

import org.junit.Test;

/**
 * HTMLタグのテスト。
 *
 */
public class HtmlTagConvertTest extends TagConvertTest {

    /**
     * HtmlBaseタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlBaseTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlBaseTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlBaseTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }

    /**
     * HtmlButtonタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlButtonTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlButtonTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlButtonTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }

    /**
     * HtmlCheckboxタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlCheckboxTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlCheckboxTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlCheckboxTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }

    /**
     * HtmlErrorsタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlErrorsTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlErrorsTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlErrorsTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }

    /**
     * HtmlFileタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlFileTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlFileTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlFileTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }

    /**
     * HtmlFormタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlFormTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlFormTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlFormTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }

    /**
     * HtmlFrameタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlFrameTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlFrameTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlFrameTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }

    /**
     * HtmlHiddenタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlHiddenTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlHiddenTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlHiddenTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }

    /**
     * HtmlHtmlタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlHtmlTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlHtmlTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlHtmlTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }

    /**
     * HtmlImageタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlImageTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlImageTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlImageTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }

    /**
     * HtmlImgタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlImgTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlImgTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlImgTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }

    /**
     * HtmlJavascriptタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlJavascriptTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlJavascriptTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlJavascriptTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }

    /**
     * HtmlLinkタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlLinkTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlLinkTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlLinkTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }

    /**
     * HtmlMessagesタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlMessagesTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlMessagesTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlMessagesTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }

    /**
     * HtmlMultiboxタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlMultiboxTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlMultiboxTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlMultiboxTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }

    /**
     * HtmlOptionタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlOptionTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlOptionTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlOptionTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }

    /**
     * HtmlOptionsタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlOptionsTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlOptionsTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlOptionsTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }

    /**
     * HtmlOptionsCollectionタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlOptionsCollectionTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlOptionsCollectionTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlOptionsCollectionTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }

    /**
     * HtmlRadioタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlRadioTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlRadioTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlRadioTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }

    /**
     * HtmlResetタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlResetTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlResetTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlResetTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }

    /**
     * HtmlSelectタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlSelectTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlSelectTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlSelectTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }

    /**
     * HtmlSubmitタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlSubmitTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlSubmitTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlSubmitTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }

    /**
     * HtmlTextareaタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlTextareaTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlTextAreaTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlTextAreaTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }

    /**
     * HtmlTextタグを変換できること
     * @throws Exception
     */
    @Test
    public void testHtmlTextTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/html/jsp/to/htmlTextTag.jsp",
                "src/test/resources/tagConvertTest/html/jsp/expect/htmlTextTag.jsp",
                "src/test/resources/tagTestConfig/testHtmlTag.properties");
    }
}
