package jp.co.tis.s2n.jspConverter.convert;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jp.co.tis.s2n.converterCommon.log.LogUtils;
import jp.co.tis.s2n.jspConverter.convert.common.TestSecurityManager;
import jp.co.tis.s2n.jspConverter.convert.common.TestSecurityManager.ExitException;

/**
 * 設定ファイルの読み込みテスト。
 *
 */
public class ReadProfileTest {

    private PrintStream defaultPrintStream;
    private SecurityManager securityManager;
    ByteArrayOutputStream byteArrayOutputStream;

    @Before
    public void setUp() throws Exception {
        LogUtils.init();
        // SecurityManager退避
        securityManager = System.getSecurityManager();
        // エラー出力退避
        defaultPrintStream = System.err;

        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setErr(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
        System.setSecurityManager(new TestSecurityManager());

    }

    @Test
    public void testReadProfileCase1() throws Exception {
        try {
            String[] args = new String[] {};
            ConvertStruts2Nablarch.main(args);
        } catch (ExitException ite) {
            // 戻り値を確認
            assertEquals(-1, ite.getStatus());

            // 出力メッセージを確認
            System.err.flush();
            final String actual = byteArrayOutputStream.toString();
            final String expected = "usage:java -jar jspconverter.jar [設定ファイル]";
            assertEquals(expected, actual);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testReadProfileCase2() throws Exception {
        try {
            String[] args = new String[] { "src/test/resources/ReadProfileTest/testCase10.properties" };
            ConvertStruts2Nablarch.main(args);
        } catch (ExitException ite) {
         // 戻り値を確認
            assertEquals(0, ite.getStatus());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testReadProfileCase3() throws Exception {
        try {
            String[] args = new String[] { "a.properties", "b.csv" };
            ConvertStruts2Nablarch.main(args);
        } catch (ExitException ite) {
            // 戻り値を確認
            assertEquals(-1, ite.getStatus());

            // 出力メッセージを確認
            System.err.flush();
            final String actual = byteArrayOutputStream.toString();
            final String expected = "a.properties - エラー:設定ファイルが見つかりません。";
            assertEquals(expected, actual);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testReadProfileCase4() throws Exception {
        try {
            String[] args = new String[] { "src/test/resources/ReadProfileTest/testCase4.properties", "b.csv" };
            ConvertStruts2Nablarch.main(args);
        } catch (ExitException ite) {
            // 戻り値を確認
            assertEquals(-1, ite.getStatus());

            // 出力メッセージを確認
            System.err.flush();
            final String actual = byteArrayOutputStream.toString();
            final String expected = "エラー:projectPathは必須です。";
            assertEquals(expected, actual);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testReadProfileCase5() throws Exception {
        try {
            String[] args = new String[] { "src/test/resources/ReadProfileTest/testCase5.properties", "b.csv" };
            ConvertStruts2Nablarch.main(args);
        } catch (ExitException ite) {
            // 戻り値を確認
            assertEquals(-1, ite.getStatus());

            // 出力メッセージを確認
            System.err.flush();
            final String actual = byteArrayOutputStream.toString();
            final String expected = "エラー:basePackageは必須です。";
            assertEquals(expected, actual);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testReadProfileCase6() throws Exception {
        try {
            String[] args = new String[] { "src/test/resources/ReadProfileTest/testCase6.properties", "b.csv" };
            ConvertStruts2Nablarch.main(args);
        } catch (ExitException ite) {
            // 戻り値を確認
            assertEquals(-1, ite.getStatus());

            // 出力メッセージを確認
            System.err.flush();
            final String actual = byteArrayOutputStream.toString();
            final String expected = "エラー:fileEncordingは必須です。";
            assertEquals(expected, actual);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testReadProfileCase7() throws Exception {
        try {
            String[] args = new String[] { "src/test/resources/ReadProfileTest/testCase7.properties", "b.csv" };
            ConvertStruts2Nablarch.main(args);
        } catch (ExitException ite) {
            // 戻り値を確認
            assertEquals(-1, ite.getStatus());

            // 出力メッセージを確認
            System.err.flush();
            final String actual = byteArrayOutputStream.toString();
            final String expected = "エラー:convertModeは必須です。";
            assertEquals(expected, actual);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testReadProfileCase8() throws Exception {
        try {
            String[] args = new String[] { "src/test/resources/ReadProfileTest/testCase8.properties", "b.csv" };
            ConvertStruts2Nablarch.main(args);
        } catch (ExitException ite) {
            // 戻り値を確認
            assertEquals(-1, ite.getStatus());

            // 出力メッセージを確認
            System.err.flush();
            final String actual = byteArrayOutputStream.toString();
            final String expected = "エラー:strutsConfigFileに指定したファイル数とmoduleに指定したモジュール数が異なります。（strutsConfigFile:4, module:1)";
            assertEquals(expected, actual);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testReadProfileCase9() throws Exception {
        try {
            String[] args = new String[] { "src/test/resources/ReadProfileTest/testCase9.properties", "b.csv" };
            ConvertStruts2Nablarch.main(args);
        } catch (ExitException ite) {
            // 戻り値を確認
            assertEquals(-1, ite.getStatus());

            // 出力メッセージを確認
            System.err.flush();
            final String actual = byteArrayOutputStream.toString();
            final String expected = "b.csv - エラー:パッケージマッピングファイルが見つかりません。";
            assertEquals(expected, actual);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testReadProfileCase10() throws Exception {
        try {
            String[] args = new String[] { "src/test/resources/ReadProfileTest/testCase10.properties",
                    "src/test/resources/ReadProfileTest/testCase10.txt" };
            ConvertStruts2Nablarch.main(args);
        } catch (ExitException ite) {
            // 戻り値を確認
            assertEquals(-1, ite.getStatus());

            // 出力メッセージを確認
            System.err.flush();
            final String actual = byteArrayOutputStream.toString();
            final String expected = "src/test/resources/ReadProfileTest/testCase10.txt - エラー:パッケージマッピングファイルをCSVフォーマットにしてください。";
            assertEquals(expected, actual);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testReadProfileCase11() throws Exception {
        try {
            String[] args = new String[] { "src/test/resources/ReadProfileTest/testCase10.properties",
                    "src/test/resources/ReadProfileTest/testCase11.csv" };
            ConvertStruts2Nablarch.main(args);
        } catch (ExitException ite) {
            // 戻り値を確認
            assertEquals(0, ite.getStatus());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown() {
        System.setOut(defaultPrintStream);
        System.setSecurityManager(securityManager);
    }

}
