package jp.co.tis.s2n.jspConverter.node;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.co.tis.s2n.jspConverter.token.Token;

/**
*
* {@link NodeWrapper}のテスト。
*
*/
public class NodeWrapperTest {

    /**
     * getSignatureメソッドのテスト
     */
    @Test
    public void testGetSignature() {
        Node node = Node.create(new Token(Token.NAME,"test"));
        node.addParam(new Token(Token.NAME,"<"));
        node.addParam(new Token(Token.EQ1,"<"));
        node.addParam(new Token(Token.STRING1,"<"));
        node.addParam(new Token(Token.EQ1,"<"));
        node.addParam(new Token(Token.EQ2,"<"));
        node.addParam(new Token(Token.SYMBOL,"<"));
        node.addParam(new Token(Token.COLON,"<"));
        node.addParam(new Token(Token.SEMICOLON,"<"));

        NodeWrapper nw = new NodeWrapper(node);
        assertEquals("<",nw.getSignature());

        Node node2 = Node.create(new Token(Token.NAME,"test"));
        node2.addParam(new Token(Token.NAME,"<"));
        node2.addParam(new Token(Token.EQ1,"<"));
        node2.addParam(new Token(Token.NAME,"<"));

        NodeWrapper nw2 = new NodeWrapper(node2);
        assertEquals("",nw2.getSignature());
    }

    /**
     * getTagNameメソッドのテスト
     */
    @Test
    public void testGetTagName() {
        Node node = Node.create(new Token(Token.NAME,"test"));
        node.addParam(new Token(Token.NAME,"<tis:button>"));
        NodeWrapper nw = new NodeWrapper(node);

        assertEquals(null,nw.getTagName());
    }
}
