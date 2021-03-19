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

        Reader reader4 = new InputStreamReader(new ByteArrayInputStream("//".getBytes()));
        PushbackReader pbr4 = new PushbackReader(reader4, 3);
        TokenMgr tokenMgr4 = new TokenMgr(pbr4, null);
        assertEquals("//",tokenMgr4.getToken(0).getText());

        Reader reader5 = new InputStreamReader(new ByteArrayInputStream("//\r".getBytes()));
        PushbackReader pbr5 = new PushbackReader(reader5, 3);
        TokenMgr tokenMgr5 = new TokenMgr(pbr5, null);
        assertEquals("//",tokenMgr5.getToken(0).getText());

        Reader reader6 = new InputStreamReader(new ByteArrayInputStream("<%-".getBytes()));
        PushbackReader pbr6 = new PushbackReader(reader6, 3);
        TokenMgr tokenMgr6 = new TokenMgr(pbr6, null);
        assertEquals("<",tokenMgr6.getToken(0).getText());

        Reader reader7 = new InputStreamReader(new ByteArrayInputStream("<%".getBytes()));
        PushbackReader pbr7 = new PushbackReader(reader7, 3);
        TokenMgr tokenMgr7 = new TokenMgr(pbr7, null);
        assertEquals("<",tokenMgr7.getToken(0).getText());

        Reader reader8 = new InputStreamReader(new ByteArrayInputStream("あ\r".getBytes()));
        PushbackReader pbr8 = new PushbackReader(reader8, 3);
        TokenMgr tokenMgr8 = new TokenMgr(pbr8, null);
        assertEquals("あ",tokenMgr8.getToken(0).getText());

        Reader reader9 = new InputStreamReader(new ByteArrayInputStream("あ".getBytes()));
        PushbackReader pbr9 = new PushbackReader(reader9, 3);
        TokenMgr tokenMgr9 = new TokenMgr(pbr9, null);
        assertEquals("あ",tokenMgr9.getToken(0).getText());

    }
}
