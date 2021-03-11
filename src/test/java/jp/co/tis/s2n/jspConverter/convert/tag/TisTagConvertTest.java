package jp.co.tis.s2n.jspConverter.convert.tag;

import org.junit.Test;

/**
 * Tisタグのテスト。
 *
 */
public class TisTagConvertTest extends TagConvertTest {

    /**
     * TisButtonタグを変換できること
     * @throws Exception
     */
    @Test
    public void testTisButtonTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/tis/jsp/to/tisButtonTag.jsp",
                "src/test/resources/tagConvertTest/tis/jsp/expect/tisButtonTag.jsp",
                "src/test/resources/tagTestConfig/testTisTag.properties");
    }

    /**
     * TisButtonNonSubmitタグを変換できること
     * @throws Exception
     */
    @Test
    public void testTisButtonNonSubmitTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/tis/jsp/to/tisButtonNonSubmitTag.jsp",
                "src/test/resources/tagConvertTest/tis/jsp/expect/tisButtonNonSubmitTag.jsp",
                "src/test/resources/tagTestConfig/testTisTag.properties");
    }

    /**
     * TisCheckboxタグを変換できること
     * @throws Exception
     */
    @Test
    public void testTisCheckboxTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/tis/jsp/to/tisCheckBoxTag.jsp",
                "src/test/resources/tagConvertTest/tis/jsp/expect/tisCheckBoxTag.jsp",
                "src/test/resources/tagTestConfig/testTisTag.properties");

        testTagConvert("src/test/resources/tagConvertTest/tis/jsp/to/tisCheckBoxTag2.jsp",
                "src/test/resources/tagConvertTest/tis/jsp/expect/tisCheckBoxTag2.jsp",
                "src/test/resources/tagTestConfig/testTisTag.properties");
    }

    /**
     * TisErrorsタグを変換できること
     * @throws Exception
     */
    @Test
    public void testTisErrorsTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/tis/jsp/to/tisErrorsTag.jsp",
                "src/test/resources/tagConvertTest/tis/jsp/expect/tisErrorsTag.jsp",
                "src/test/resources/tagTestConfig/testTisTag.properties");
    }

    /**
     * TisFileUploadタグを変換できること
     * @throws Exception
     */
    @Test
    public void testTisFileUploadTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/tis/jsp/to/tisFileUpLoadTag.jsp",
                "src/test/resources/tagConvertTest/tis/jsp/expect/tisFileUpLoadTag.jsp",
                "src/test/resources/tagTestConfig/testTisTag.properties");
    }

    /**
     * TisHiddenタグを変換できること
     * @throws Exception
     */
    @Test
    public void testTisHiddenTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/tis/jsp/to/tisHiddenTag.jsp",
                "src/test/resources/tagConvertTest/tis/jsp/expect/tisHiddenTag.jsp",
                "src/test/resources/tagTestConfig/testTisTag.properties");
    }

    /**
     * TisLabelタグを変換できること
     * @throws Exception
     */
    @Test
    public void testTisLabelTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/tis/jsp/to/tisLabelTag.jsp",
                "src/test/resources/tagConvertTest/tis/jsp/expect/tisLabelTag.jsp",
                "src/test/resources/tagTestConfig/testTisTag.properties");
    }

    /**
     * TisMessagesタグを変換できること
     * @throws Exception
     */
    @Test
    public void testTisMessagesTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/tis/jsp/to/tisMessagesTag.jsp",
                "src/test/resources/tagConvertTest/tis/jsp/expect/tisMessagesTag.jsp",
                "src/test/resources/tagTestConfig/testTisTag.properties");
    }

    /**
     * TisPasswordタグを変換できること
     * @throws Exception
     */
    @Test
    public void testTisPasswordTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/tis/jsp/to/tisPasswordTag.jsp",
                "src/test/resources/tagConvertTest/tis/jsp/expect/tisPasswordTag.jsp",
                "src/test/resources/tagTestConfig/testTisTag.properties");
    }

    /**
     * TisRadioタグを変換できること
     * @throws Exception
     */
    @Test
    public void testTisRadioTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/tis/jsp/to/tisRadioTag.jsp",
                "src/test/resources/tagConvertTest/tis/jsp/expect/tisRadioTag.jsp",
                "src/test/resources/tagTestConfig/testTisTag.properties");
    }

    /**
     * TisSelectタグを変換できること
     * @throws Exception
     */
    @Test
    public void testTisSelectTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/tis/jsp/to/tisSelectTag.jsp",
                "src/test/resources/tagConvertTest/tis/jsp/expect/tisSelectTag.jsp",
                "src/test/resources/tagTestConfig/testTisTag.properties");
    }

    /**
     * TisSubmitタグを変換できること
     * @throws Exception
     */
    @Test
    public void testTisSubmitTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/tis/jsp/to/tisSubmitTag.jsp",
                "src/test/resources/tagConvertTest/tis/jsp/expect/tisSubmitTag.jsp",
                "src/test/resources/tagTestConfig/testTisTag.properties");
    }

    /**
     * TisTextareaタグを変換できること
     * @throws Exception
     */
    @Test
    public void testTisTextAreaTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/tis/jsp/to/tisTextAreaTag.jsp",
                "src/test/resources/tagConvertTest/tis/jsp/expect/tisTextAreaTag.jsp",
                "src/test/resources/tagTestConfig/testTisTag.properties");
    }

    /**
     * TisTextタグを変換できること
     * @throws Exception
     */
    @Test
    public void testTisTextTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/tis/jsp/to/tisTextTag.jsp",
                "src/test/resources/tagConvertTest/tis/jsp/expect/tisTextTag.jsp",
                "src/test/resources/tagTestConfig/testTisTag.properties");
    }
}
