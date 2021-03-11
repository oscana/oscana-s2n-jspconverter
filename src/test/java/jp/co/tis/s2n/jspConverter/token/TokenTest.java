package jp.co.tis.s2n.jspConverter.token;

import static org.junit.Assert.*;

import org.junit.Test;

/**
*
* {@link Token}のテスト。
*
*/
public class TokenTest {

    /**
     * setTextWithoutQuoteメソッドのテスト
     */
    @Test
    public void testSetTextWithoutQuote() {
        Token t = new Token(Token.STRING1,"a");
        t.setTextWithoutQuote("a");
        assertEquals("\'a\'",t.getText());
    }
}
