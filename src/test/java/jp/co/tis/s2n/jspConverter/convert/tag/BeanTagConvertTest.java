package jp.co.tis.s2n.jspConverter.convert.tag;

import org.junit.Test;

/**
 * Beanタグのテスト
 *
 */
public class BeanTagConvertTest extends TagConvertTest {

    /**
     * BeanCookieタグを変換できること
     * @throws Exception
     */
    @Test
    public void testBeanCookieTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/bean/jsp/to/beanCookieTag.jsp",
                "src/test/resources/tagConvertTest/bean/jsp/expect/beanCookieTag.jsp",
                "src/test/resources/tagTestConfig/testBeanTag.properties");
    }

    /**
     * BeanDefineタグを変換できること
     * @throws Exception
     */
    @Test
    public void testBeanDefineTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/bean/jsp/to/beanDefineTag.jsp",
                "src/test/resources/tagConvertTest/bean/jsp/expect/beanDefineTag.jsp",
                "src/test/resources/tagTestConfig/testBeanTag.properties");
    }

    /**
     * BeanHeaderタグを変換できること
     * @throws Exception
     */
    @Test
    public void testBeanHeaderTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/bean/jsp/to/beanHeaderTag.jsp",
                "src/test/resources/tagConvertTest/bean/jsp/expect/beanHeaderTag.jsp",
                "src/test/resources/tagTestConfig/testBeanTag.properties");
    }

    /**
     * BeanIncludeタグを変換できること
     * @throws Exception
     */
    @Test
    public void testBeanIncludeTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/bean/jsp/to/beanIncludeTag.jsp",
                "src/test/resources/tagConvertTest/bean/jsp/expect/beanIncludeTag.jsp",
                "src/test/resources/tagTestConfig/testBeanTag.properties");
    }

    /**
     * BeanMessageタグを変換できること
     * @throws Exception
     */
    @Test
    public void testBeanMessageTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/bean/jsp/to/beanMessageTag.jsp",
                "src/test/resources/tagConvertTest/bean/jsp/expect/beanMessageTag.jsp",
                "src/test/resources/tagTestConfig/testBeanTag.properties");
    }

    /**
     * BeanParameterタグを変換できること
     * @throws Exception
     */
    @Test
    public void testBeanParameterTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/bean/jsp/to/beanParameterTag.jsp",
                "src/test/resources/tagConvertTest/bean/jsp/expect/beanParameterTag.jsp",
                "src/test/resources/tagTestConfig/testBeanTag.properties");
    }

    /**
     * BeanResourceタグを変換できること
     * @throws Exception
     */
    @Test
    public void testBeanResourceTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/bean/jsp/to/beanResourceTag.jsp",
                "src/test/resources/tagConvertTest/bean/jsp/expect/beanResourceTag.jsp",
                "src/test/resources/tagTestConfig/testBeanTag.properties");
    }

    /**
     * BeanSizeタグを変換できること
     * @throws Exception
     */
    @Test
    public void testBeanSizeTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/bean/jsp/to/beanSizeTag.jsp",
                "src/test/resources/tagConvertTest/bean/jsp/expect/beanSizeTag.jsp",
                "src/test/resources/tagTestConfig/testBeanTag.properties");
    }

    /**
     * BeanWriteタグを変換できること
     * @throws Exception
     */
    @Test
    public void testBeanWriteTagConvert() throws Exception {
        testTagConvert("src/test/resources/tagConvertTest/bean/jsp/to/beanWriteTag.jsp",
                "src/test/resources/tagConvertTest/bean/jsp/expect/beanWriteTag.jsp",
                "src/test/resources/tagTestConfig/testBeanTag.properties");
    }
}
