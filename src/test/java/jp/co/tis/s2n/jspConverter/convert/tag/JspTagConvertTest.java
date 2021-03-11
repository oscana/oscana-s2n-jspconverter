package jp.co.tis.s2n.jspConverter.convert.tag;

import org.junit.Test;

/**
 * Jspタグのテスト。
 *
 */
public class JspTagConvertTest extends TagConvertTest {

    /**
     * JspGetPropertyタグを変換できること
     * @throws Exception
     */
    @Test
    public void testJspGetPropertyTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/jsp/jsp/to/jspGetPropertyTag.jsp",
                "src/test/resources/tagConvertTest/jsp/jsp/expect/jspGetPropertyTag.jsp",
                "src/test/resources/tagTestConfig/testJspTag.properties");
    }

}
