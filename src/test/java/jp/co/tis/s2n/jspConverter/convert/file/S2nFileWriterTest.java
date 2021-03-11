package jp.co.tis.s2n.jspConverter.convert.file;

import static org.junit.Assert.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.Test;

import jp.co.tis.s2n.jspConverter.convert.profile.S2nProfile;
import jp.co.tis.s2n.jspConverter.file.S2nFileWriter;

/**
*
* {@link S2nFileWriter}のテスト。
*
*/
public class S2nFileWriterTest {

    /**
     * fprintメソッドのテスト
     * @throws IOException
     */
    @Test
    public void testFprint() throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("logs/error.log"), "UTF-8");
        S2nProfile s2np = new S2nProfile();
        s2np.setLineSeparator("\n");
        S2nFileWriter s2n = new S2nFileWriter(writer,s2np);
        s2n.fprint("test");
        assertNotNull(s2n);
    }
}
