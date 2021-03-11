package jp.co.tis.s2n.jspConverter.convert;

import java.io.File;

import org.junit.Test;

/**
*
* {@link AbstractBatchBase}のテスト。
*
*/
public class AbstractBatchBaseTest {

    /**
     * findDirメソッドのテスト
     */
    @Test
    public void testFindDir() {
        TestAbstractBatchBase tb = new TestAbstractBatchBase();
        File dir = new File("src/test/resources/ApiTest");
        tb.findDir("", "", "", dir);
    }
}

class TestAbstractBatchBase extends AbstractBatchBase {

}
