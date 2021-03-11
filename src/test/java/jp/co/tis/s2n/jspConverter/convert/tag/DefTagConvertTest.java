package jp.co.tis.s2n.jspConverter.convert.tag;

import org.junit.Test;

/**
 * Defaultタグのテスト。
 *
 */
public class DefTagConvertTest extends TagConvertTest {

    /**
     * inputタグを変換できること
     * @throws Exception
     */
    @Test
    public void testJspGetPropertyTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/def/jsp/to/defInputTag.jsp",
                "src/test/resources/tagConvertTest/def/jsp/expect/defInputTag.jsp",
                "src/test/resources/tagTestConfig/testDefTag.properties");
    }

}
