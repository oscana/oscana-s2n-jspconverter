package jp.co.tis.s2n.jspConverter.convert.tag;

import org.junit.Test;

/**
 * Cタグのテスト。
 *
 */
public class CTagConvertTest extends TagConvertTest {

    /**
     * indexed属性があるタグを変換できること
     * @throws Exception
     */
    @Test
    public void testJspGetPropertyTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/c/jsp/to/cForEachTag.jsp",
                "src/test/resources/tagConvertTest/c/jsp/expect/cForEachTag.jsp",
                "src/test/resources/tagTestConfig/testCTag.properties");
    }

}
