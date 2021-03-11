package jp.co.tis.s2n.jspConverter.convert.tag;

import org.junit.Test;

/**
 * Sタグのテスト。
 *
 */
public class STagConvertTest extends TagConvertTest {

    /**
     * SFormタグを変換できること
     * @throws Exception
     */
    @Test
    public void testSFormTagTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/s/jsp/to/sFormTag.jsp",
                "src/test/resources/tagConvertTest/s/jsp/expect/sFormTag.jsp",
                "src/test/resources/tagTestConfig/testSTag.properties");
    }

    /**
     * SLinkタグを変換できること
     * @throws Exception
     */
    @Test
    public void testSLinkTagTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/s/jsp/to/sLinkTag.jsp",
                "src/test/resources/tagConvertTest/s/jsp/expect/sLinkTag.jsp",
                "src/test/resources/tagTestConfig/testSTag.properties");
    }

    /**
     * SSubmitタグを変換できること
     * @throws Exception
     */
    @Test
    public void testSSubmitTagTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/s/jsp/to/sSubmitTag.jsp",
                "src/test/resources/tagConvertTest/s/jsp/expect/sSubmitTag.jsp",
                "src/test/resources/tagTestConfig/testSTag.properties");
    }
}
