package jp.co.tis.s2n.jspConverter.token;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import java.io.Reader;

import org.junit.Test;

/**
*
* {@link TokenMgr}のテスト。
*
*/
public class TokenMgrTest {

    /**
     * getTokenメソッドのテスト
     * @throws IOException
     */
    @Test
    public void testGetToken() throws IOException {
        Reader reader = new InputStreamReader(new ByteArrayInputStream("\r.a".getBytes()));
        PushbackReader pbr = new PushbackReader(reader, 3);
        TokenMgr tokenMgr = new TokenMgr(pbr, null);
        assertEquals(".",tokenMgr.getToken(0).getText());

        Reader reader2 = new InputStreamReader(new ByteArrayInputStream("==".getBytes()));
        PushbackReader pbr2 = new PushbackReader(reader2, 3);
        TokenMgr tokenMgr2 = new TokenMgr(pbr2, null);
        assertEquals("==",tokenMgr2.getToken(0).getText());


        Reader reader3 = new InputStreamReader(new ByteArrayInputStream("\"".getBytes()));
        PushbackReader pbr3 = new PushbackReader(reader3, 3);
        TokenMgr tokenMgr3 = new TokenMgr(pbr3, null);
        assertEquals("\"",tokenMgr3.getToken(0).getText());
    }
}
