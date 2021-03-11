package jp.co.tis.s2n.jspConverter.convert.tag;

import org.junit.Test;

/**
 * Logicタグのテスト。
 *
 */
public class LogicTagConvertTest extends TagConvertTest {

    /**
     * LogicEmptyタグを変換できること
     * @throws Exception
     */
    @Test
    public void testLogicEmptyTagTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/logic/jsp/to/logicEmptyTag.jsp",
                "src/test/resources/tagConvertTest/logic/jsp/expect/logicEmptyTag.jsp",
                "src/test/resources/tagTestConfig/testLogicTag.properties");
    }

    /**
     * LogicEqualタグを変換できること
     * @throws Exception
     */
    @Test
    public void testLogicEqualTagTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/logic/jsp/to/logicEqualTag.jsp",
                "src/test/resources/tagConvertTest/logic/jsp/expect/logicEqualTag.jsp",
                "src/test/resources/tagTestConfig/testLogicTag.properties");
    }

    /**
     * LogicForwardタグを変換できること
     * @throws Exception
     */
    @Test
    public void testLogicForwardTagTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/logic/jsp/to/logicForwardTag.jsp",
                "src/test/resources/tagConvertTest/logic/jsp/expect/logicForwardTag.jsp",
                "src/test/resources/tagTestConfig/testLogicTag.properties");
    }

    /**
     * LogicGreaterEqualタグを変換できること
     * @throws Exception
     */
    @Test
    public void testLogicGreaterEqualTagTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/logic/jsp/to/logicGreaterEqualTag.jsp",
                "src/test/resources/tagConvertTest/logic/jsp/expect/logicGreaterEqualTag.jsp",
                "src/test/resources/tagTestConfig/testLogicTag.properties");
    }

    /**
     * LogicGreaterThanタグを変換できること
     * @throws Exception
     */
    @Test
    public void testLogicGreaterThanTagTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/logic/jsp/to/logicGreaterThanTag.jsp",
                "src/test/resources/tagConvertTest/logic/jsp/expect/logicGreaterThanTag.jsp",
                "src/test/resources/tagTestConfig/testLogicTag.properties");
    }

    /**
     * LogicIterateタグを変換できること
     * @throws Exception
     */
    @Test
    public void testLogicIterateTagTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/logic/jsp/to/logicIterateTag.jsp",
                "src/test/resources/tagConvertTest/logic/jsp/expect/logicIterateTag.jsp",
                "src/test/resources/tagTestConfig/testLogicTag.properties");
    }

    /**
     * LogicLessEqualタグを変換できること
     * @throws Exception
     */
    @Test
    public void testLogicLessEqualTagTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/logic/jsp/to/logicLessEqualTag.jsp",
                "src/test/resources/tagConvertTest/logic/jsp/expect/logicLessEqualTag.jsp",
                "src/test/resources/tagTestConfig/testLogicTag.properties");
    }

    /**
     * LogicLessThanタグを変換できること
     * @throws Exception
     */
    @Test
    public void testLogicLessThanTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/logic/jsp/to/logicLessThanTag.jsp",
                "src/test/resources/tagConvertTest/logic/jsp/expect/logicLessThanTag.jsp",
                "src/test/resources/tagTestConfig/testLogicTag.properties");
    }

    /**
     * LogicMatchタグを変換できること
     * @throws Exception
     */
    @Test
    public void testLogicMatchTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/logic/jsp/to/logicMatchTag.jsp",
                "src/test/resources/tagConvertTest/logic/jsp/expect/logicMatchTag.jsp",
                "src/test/resources/tagTestConfig/testLogicTag.properties");
    }

    /**
     * LogicMessagesNotPresentタグを変換できること
     * @throws Exception
     */
    @Test
    public void testLogicMessagesNotPresentTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/logic/jsp/to/logicMessagesNotPresentTag.jsp",
                "src/test/resources/tagConvertTest/logic/jsp/expect/logicMessagesNotPresentTag.jsp",
                "src/test/resources/tagTestConfig/testLogicTag.properties");
    }

    /**
     * LogicMessagesPresentタグを変換できること
     * @throws Exception
     */
    @Test
    public void testLogicMessagesPresentTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/logic/jsp/to/logicMessagesPresentTag.jsp",
                "src/test/resources/tagConvertTest/logic/jsp/expect/logicMessagesPresentTag.jsp",
                "src/test/resources/tagTestConfig/testLogicTag.properties");
    }

    /**
     * LogicNotEmptyタグを変換できること
     * @throws Exception
     */
    @Test
    public void testLogicNotEmptyTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/logic/jsp/to/logicNotEmptyTag.jsp",
                "src/test/resources/tagConvertTest/logic/jsp/expect/logicNotEmptyTag.jsp",
                "src/test/resources/tagTestConfig/testLogicTag.properties");
    }

    /**
     * LogicNotEqualタグを変換できること
     * @throws Exception
     */
    @Test
    public void testLogicNotEqualTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/logic/jsp/to/logicNotEqualTag.jsp",
                "src/test/resources/tagConvertTest/logic/jsp/expect/logicNotEqualTag.jsp",
                "src/test/resources/tagTestConfig/testLogicTag.properties");
    }

    /**
     * LogicNotMatchタグを変換できること
     * @throws Exception
     */
    @Test
    public void testLogicNotMatchTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/logic/jsp/to/logicNotMatchTag.jsp",
                "src/test/resources/tagConvertTest/logic/jsp/expect/logicNotMatchTag.jsp",
                "src/test/resources/tagTestConfig/testLogicTag.properties");
    }

    /**
     * LogicNotPresentタグを変換できること
     * @throws Exception
     */
    @Test
    public void testLogicNotPresentTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/logic/jsp/to/logicNotPresentTag.jsp",
                "src/test/resources/tagConvertTest/logic/jsp/expect/logicNotPresentTag.jsp",
                "src/test/resources/tagTestConfig/testLogicTag.properties");
    }

    /**
     * LogicPresentタグを変換できること
     * @throws Exception
     */
    @Test
    public void testLogicPresentTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/logic/jsp/to/logicPresentTag.jsp",
                "src/test/resources/tagConvertTest/logic/jsp/expect/logicPresentTag.jsp",
                "src/test/resources/tagTestConfig/testLogicTag.properties");
    }

    /**
     * LogicRedirectタグを変換できること
     * @throws Exception
     */
    @Test
    public void testLogicRedirectTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/logic/jsp/to/logicRedirectTag.jsp",
                "src/test/resources/tagConvertTest/logic/jsp/expect/logicRedirectTag.jsp",
                "src/test/resources/tagTestConfig/testLogicTag.properties");
    }
}
