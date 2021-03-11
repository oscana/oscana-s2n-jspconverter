package jp.co.tis.s2n.jspConverter.convert.tag;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;

import jp.co.tis.s2n.jspConverter.convert.ConvertStruts2Nablarch;
import jp.co.tis.s2n.jspConverter.convert.common.TestSecurityManager;
import jp.co.tis.s2n.jspConverter.convert.common.TestSecurityManager.ExitException;

/**
 * タグ変換のテスト。
 *
 */
public class TagConvertTest {

    private PrintStream defaultPrintStream;
    private SecurityManager securityManager;
    ByteArrayOutputStream byteArrayOutputStream;

    @After
    public void tearDown() {
        System.setOut(defaultPrintStream);
        System.setSecurityManager(securityManager);
    }

    @Before
    public void setUp() {
        // SecurityManager退避
        securityManager = System.getSecurityManager();
        // エラー出力退避
        defaultPrintStream = System.err;

        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setErr(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
        System.setSecurityManager(new TestSecurityManager());

    }

    /**
     * ファイルを変換し、テストを行う
     * @param toFileName
     * @param expectFileName
     * @param configFile
     * @throws Exception
     */
    public void testTagConvert(String toFileName, String expectFileName, String configFile) throws Exception {

        try {
            String[] args = new String[] { configFile, "src/test/resources/tagTestConfig/testCase1.csv" };

            ConvertStruts2Nablarch.main(args);
            String bkFile = new File(toFileName).getAbsolutePath();
            String toFile = new File(expectFileName).getAbsolutePath();

            //　ファイルの中身を比較する
            assertTrue(fileCompare(bkFile, toFile));

        } catch (ExitException ite) {
            // 戻り値を確認
            assertEquals(0, ite.getStatus());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * ファイルが同じかどうかを判断する
     * @param fileA
     * @param fileB
     * @return 同じであれば、trueを返す
     */
    private boolean fileCompare(String fileA, String fileB) {
        boolean bRet = false;
        try {
            bRet = Arrays.equals(Files.readAllBytes(Paths.get(fileA)), Files.readAllBytes(Paths.get(fileB)));
        } catch (IOException e) {
            return false;
        }
        return bRet;
    }

}
