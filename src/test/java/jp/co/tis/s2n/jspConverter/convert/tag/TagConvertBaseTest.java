package jp.co.tis.s2n.jspConverter.convert.tag;

import static org.junit.Assert.*;

import java.util.Hashtable;
import java.util.Stack;

import org.junit.Test;

import jp.co.tis.s2n.jspConverter.node.Node;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;
import jp.co.tis.s2n.jspConverter.token.Token;

/**
*
* {@link TagConvertBase}のテスト。
*
*/
public class TagConvertBaseTest {

    /**
     * convStrutsActionPathメソッドのテスト
     */
    @Test
    public void testConvStrutsActionPath() {
        assertNull(TestTagConvertBase.convStrutsActionPath(null));
        assertEquals("test.do", TestTagConvertBase.convStrutsActionPath("test.do"));
        assertEquals("test.do", TestTagConvertBase.convStrutsActionPath("test"));
    }

    /**
     * getCurJspPathメソッドのテスト
     */
    @Test
    public void testGetCurJspPath() {
        TagConvertConfig tc = new TagConvertConfig();
        tc.inPath = "/test";
        tc.inFilePath = "/test/child";
        TestTagConvertBase tcb = new TestTagConvertBase();
        tcb.setConfig(tc);
        assertEquals("/child", tcb.getCurJspPath());
        tc.inPath = "\\test";
        tc.inFilePath = "\\test\\\\child";
        tcb.setConfig(tc);
        assertEquals("/child", tcb.getCurJspPath());
    }

    /**
     * nestedStartTagProcメソッドのテスト
     */
    @Test
    public void testNestedStartTagProc() {
        TestTagConvertBase tcb = new TestTagConvertBase();
        tcb.setNested(true);

        Stack<String> stack = new Stack<>();
        stack.add("name");
        tcb.setCommonStore(new Hashtable<String, Object>());
        tcb.commonStore.put("jp.co.tis.s2n.jspConverter.convert.tag.TagConvertBase.NESTED_STACK", stack);
        Node node = Node.create(Node.T_NORMAL, "test");
        node.addParam(new Token(Token.STRING1, "a1"));
        node.addParam(new Token(Token.STRING1, "a2"));
        node.addParam(new Token(Token.STRING1, "a3"));
        NodeWrapper nw = new NodeWrapper(node);
        tcb.start(nw);

        Node node2 = Node.create(Node.T_NORMAL, "test");
        node2.addParam(new Token(Token.STRING1, "name"));
        node2.addParam(new Token(Token.STRING1, "="));
        node2.addParam(new Token(Token.STRING1, "name"));
        NodeWrapper nw2 = new NodeWrapper(node2);
        tcb.start(nw2);
    }

    /**
     * setCommonPropertyAsObjectメソッドのテスト
     */
    @Test
    public void testSetCommonPropertyAsObject() {
        TestTagConvertBase tcb = new TestTagConvertBase();
        tcb.setCommonStore(new Hashtable<String, Object>());
        tcb.setCommonPropertyAsObject("test1", "test1");
        assertNotNull(tcb.commonStore.get("test1"));

        tcb.setCommonPropertyAsObject("test1", null);
        assertNull(tcb.commonStore.get("test1"));
    }

    /**
     * setCommonPropertyAsObjectメソッドのテスト０１
     */
    @Test
    public void testConvertPath01() {
        TestTagConvertBase tcb = new TestTagConvertBase();
        assertNull(tcb.convertPath(null, null, null, null, null));

    }

    /**
     * setCommonPropertyAsObjectメソッドのテスト０２
     */
    @Test(expected = NullPointerException.class)
    public void testConvertPath02() {
        TestTagConvertBase tcb = new TestTagConvertBase();
        tcb.convertPath(null, null, "forward", null, null);
    }
}

class TestTagConvertBase extends TagConvertBase {

    @Override
    protected void convertTagName(NodeWrapper nw) {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    protected void convertStartProc(NodeWrapper nw) {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    protected void convertEndProc(NodeWrapper nw) {
        // TODO 自動生成されたメソッド・スタブ

    }

}