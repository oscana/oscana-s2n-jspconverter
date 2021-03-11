package jp.co.tis.s2n.jspConverter.convert.profile;

import static org.junit.Assert.*;

import org.junit.Test;

/**
*
* {@link S2nProfile}のテスト。
*
*/
public class S2nProfileTest {

    /**
     * getBasePackageメソッドのテスト
     */
    @Test
    public void testGetBasePackage() {
        S2nProfile s2n = new S2nProfile();
        s2n.setBasePackage("test");
        assertEquals("test",s2n.getBasePackage());
    }

    /**
     * setStrutsAnalyzeResultListメソッドのテスト
     */
    @Test
    public void testSetStrutsAnalyzeResultList() {
        S2nProfile s2n = new S2nProfile();
        s2n.setStrutsAnalyzeResultList(null);
        assertNull(s2n.getStrutsAnalyzeResultList());
    }

    /**
     * getHeaderPathメソッドのテスト
     */
    @Test
    public void testGetHeaderPath() {
        S2nProfile s2n = new S2nProfile();
        s2n.setHeaderPath("test");
        assertEquals("test",s2n.getHeaderPath());
    }

    /**
     * getFooterPathメソッドのテスト
     */
    @Test
    public void testGetFooterPath() {
        S2nProfile s2n = new S2nProfile();
        s2n.setFooterPath("test");
        assertEquals("test",s2n.getFooterPath());
    }
}
