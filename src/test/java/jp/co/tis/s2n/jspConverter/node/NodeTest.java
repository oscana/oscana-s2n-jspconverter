package jp.co.tis.s2n.jspConverter.node;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.co.tis.s2n.jspConverter.token.Token;

/**
*
* {@link Node}のテスト。
*
*/
public class NodeTest {

    /**
     * getStringWithoutCRLFメソッドのテスト
     */
    @Test
    public void testGetStringWithoutCRLF() {
        Node node = Node.create(new Token(Token.NAME,"test"));
        node.addParam(new Token(Token.NAME,"<"));
        assertEquals("test<",node.getStringWithoutCRLF());
    }
}
