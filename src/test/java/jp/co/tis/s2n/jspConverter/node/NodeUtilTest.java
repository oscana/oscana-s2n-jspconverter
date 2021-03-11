package jp.co.tis.s2n.jspConverter.node;

import static org.junit.Assert.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import jp.co.tis.s2n.jspConverter.convert.profile.S2nProfile;
import jp.co.tis.s2n.jspConverter.file.S2nFileWriter;
import jp.co.tis.s2n.jspConverter.token.Token;

/**
*
* {@link NodeUtil}のテスト。
*
*/
public class NodeUtilTest {

    /**
     * findTagStartsWithAllNodeメソッドのテスト０１
     */
    @Test
    public void testFindTagStartsWithAllNode01() {

        Node node = Node.create(new Token(Token.NAME,"test"));
        node.addParam(new Token(Token.NAME,"<"));
        node.addParam(new Token(Token.NAME,"/"));
        node.addParam(new Token(Token.NAME,">"));

        List<Node> ignoreList = new ArrayList<>();
        List<Node> findList = new ArrayList<>();
        String[] keys = {};
        NodeUtil.findTagStartsWithAllNode(node, keys, findList, ignoreList);
        assertEquals(0,ignoreList.size());
    }

    /**
     * findTagStartsWithAllNodeメソッドのテスト０２
     */
    @Test
    public void testFindTagStartsWithAllNode02() {

        Node node = Node.create(new Token(Token.NAME,"test"));
        node.addParam(new Token(Token.NAME,"<"));
        node.addParam(new Token(Token.NAME,"/"));
        node.addParam(new Token(Token.NAME,":"));
        node.addParam(new Token(Token.NAME,">"));

        List<Node> ignoreList = new ArrayList<>();
        List<Node> findList = new ArrayList<>();
        String[] keys = {};
        NodeUtil.findTagStartsWithAllNode(node, keys, findList, ignoreList);
        assertEquals(1,ignoreList.size());

        NodeUtil.findTagStartsWithAllNode(node, keys, findList, null);
        assertEquals(1,ignoreList.size());
    }

    /**
     * findTagStartsWithAllNodeメソッドのテスト０３
     */
    @Test
    public void testFindTagStartsWithAllNode03() {

        Node node = Node.create(new Token(Token.NAME,"test"));
        node.addParam(new Token(Token.NAME,"<"));
        node.addParam(new Token(Token.NAME,":"));
        node.addParam(new Token(Token.NAME,":"));
        node.addParam(new Token(Token.NAME,">"));

        List<Node> ignoreList = new ArrayList<>();
        List<Node> findList = new ArrayList<>();
        String[] keys = {};
        NodeUtil.findTagStartsWithAllNode(node, keys, findList, ignoreList);
        assertEquals(1,ignoreList.size());

        NodeUtil.findTagStartsWithAllNode(node, keys, findList, null);
        assertEquals(1,ignoreList.size());
    }

    /**
     * fprintAllメソッドのテスト
     * @throws IOException
     */
    @Test
    public void testFprintAll() throws IOException {

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("logs/error.log"), "UTF-8");
        S2nProfile activeProfile = new S2nProfile();
        Node node = Node.create(Node.T_MODULE,"test1");
        activeProfile.setLineSeparator("\r\n");
        NodeUtil.fprintAll(new S2nFileWriter(osw, activeProfile), node);

        Node node2 = Node.create(Node.T_NORMAL,"test2");
        node2.addParam(new Token(Token.NAME,"test2"));
        NodeUtil.fprintAll(new S2nFileWriter(osw, activeProfile), node2);
        osw.flush();
    }

    /**
     * findAllDirectiveNodeメソッドのテスト
     * @throws IOException
     */
    @Test
    public void testFindAllDirectiveNode() throws IOException {
        Node node1 = Node.create(Node.T_NORMAL,"<%@ 1");
        node1.addParam(new Token(Token.NAME,"test2"));
        List<Node> findList1 = new ArrayList<>();
        NodeUtil.findAllDirectiveNode(node1, "1", findList1);
        assertEquals(1,findList1.size());

        Node node2 = Node.create(Node.T_NORMAL,"<%@1");
        node2.addParam(new Token(Token.NAME,"test2"));
        List<Node> findList2 = new ArrayList<>();
        NodeUtil.findAllDirectiveNode(node2, "1", findList2);
        assertEquals(1,findList2.size());

        Node node3 = Node.create(Node.T_NORMAL,"test");
        node3.addParam(new Token(Token.NAME,"test2"));
        List<Node> findList3 = new ArrayList<>();
        NodeUtil.findAllDirectiveNode(node3, "1", findList3);
        assertEquals(0,findList3.size());
    }
}
