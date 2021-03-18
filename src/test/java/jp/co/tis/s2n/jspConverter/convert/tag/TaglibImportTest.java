package jp.co.tis.s2n.jspConverter.convert.tag;

import org.junit.Test;

/**
 * APIクラスのテスト。
 *
 */
public class TaglibImportTest extends TagConvertTest {

    /**
     * Strutsのtaglibインポート文を変換できること。
     * @throws Exception
     */
    @Test
    public void testStrutsTabLibImportConvert() throws Exception {
        testTagConvert("src/test/resources/TaglibImportTest/struts/jsp/to/strutsTaglibImport.jsp",
                "src/test/resources/TaglibImportTest/struts/jsp/expect/strutsTaglibImport.jsp",
                "src/test/resources/tagTestConfig/testStrutsTablibImport.properties");
    }

    /**
     * SAStrutsのtaglibインポート文を変換できること。
     * @throws Exception
     */
    @Test
    public void testSAStrutsTabLibImportConvert() throws Exception {
        testTagConvert("src/test/resources/TaglibImportTest/sastruts/jsp/to/saStrutsTaglibImport.jsp",
                "src/test/resources/TaglibImportTest/sastruts/jsp/expect/saStrutsTaglibImport.jsp",
                "src/test/resources/tagTestConfig/testSastrutsTablibImport.properties");
    }
}
