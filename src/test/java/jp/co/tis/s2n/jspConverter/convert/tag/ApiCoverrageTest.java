package jp.co.tis.s2n.jspConverter.convert.tag;

import org.junit.Test;

/**
 * APIクラスのテスト。
 *
 */
public class ApiCoverrageTest extends TagConvertTest {

    /**
     * BeanCookieタグを変換できること
     * @throws Exception
     */
    @Test
    public void testBeanCookieTagConvert() throws Exception {
        testTagConvert("src/test/resources/ApiTest/jsp/to/apiTest.jsp",
                "src/test/resources/ApiTest/jsp/expect/apiTest.jsp",
                "src/test/resources/tagTestConfig/testApi.properties");
    }
}
