package jp.co.tis.s2n.jspConverter.convert;

import java.util.Hashtable;

import org.junit.Test;

import jp.co.tis.s2n.jspConverter.node.Node;
import jp.co.tis.s2n.jspConverter.token.Token;

/**
*
* {@link ConvertStruts2Nablarch}のテスト。
*
*/
public class ConvertStruts2NablarchTest {

    /**
     * ExecuteTagConvertClassメソッドのテスト
     */
    @Test
    public void testExecuteTagConvertClass() {

        ConvertStruts2Nablarch csn = new ConvertStruts2Nablarch();
        csn.setInPath("logs/error.log");
        Node node = Node.create(new Token(Token.NAME, "test"));
        node.addParam(new Token(Token.NAME, "<"));
        node.addParam(new Token(Token.NAME, "tis:button"));
        node.addParam(new Token(Token.NAME, ">"));
        csn.executeTagConvertClass(node, "logs/error.log", new Hashtable<String, Object>(), true);

        Node node2 = Node.create(new Token(Token.NAME, "test"));
        node2.addParam(new Token(Token.NAME, "<"));
        node2.addParam(new Token(Token.NAME, "a"));
        node2.addParam(new Token(Token.NAME, ">"));
        csn.executeTagConvertClass(node2, "logs/error.log", new Hashtable<String, Object>(), true);
    }

    /**
     * MakeTagConverterClassNameメソッドのテスト
     */
    @Test(expected = NullPointerException.class)
    public void testMakeTagConverterClassName() {

        ConvertStruts2Nablarch csn = new ConvertStruts2Nablarch();
        csn.setInPath("logs/error.log");
        Node node = Node.create(new Token(Token.NAME, "test"));
        node.addParam(new Token(Token.NAME, "<"));
        node.addParam(new Token(Token.NAME, "nested:test"));
        node.addParam(new Token(Token.NAME, ">"));
        csn.executeTagConvertClass(node, "logs/error.log", new Hashtable<String, Object>(), false);

    }
}
