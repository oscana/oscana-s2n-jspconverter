package jp.co.tis.s2n.jspConverter.parser;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.co.tis.s2n.jspConverter.token.Token;

/**
*
* {@link JspParser}のテスト。
*
*/
public class JspParserTest {

    /**
     *judgeTagNestメソッドのテスト
     */
    @Test
    public void testJudgeTagNest() {
        assertEquals(0,JspParser.judgeTagNest(0, new Token(Token.NAME,">")));
    }
}
