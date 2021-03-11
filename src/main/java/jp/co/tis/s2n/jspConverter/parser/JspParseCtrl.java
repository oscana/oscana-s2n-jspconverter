package jp.co.tis.s2n.jspConverter.parser;

import java.util.ArrayDeque;
import java.util.Deque;

import jp.co.tis.s2n.jspConverter.keyword.JspKeyword;
import jp.co.tis.s2n.jspConverter.node.Node;
import jp.co.tis.s2n.jspConverter.token.Token;

/**
 * パース経過保持。<br>
 * <br>
 * 以下の機能を提供する。<br>
 * ・パースの経過を保持する<br>
 * ・コンストラクタで作成されたTopノードを頂点としたツリーを構成する。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class JspParseCtrl implements JspKeyword {
    /**
     * TOPノード
     */
    public Node tNode = null;
    /**
    * カレント親ノード<br>
    * 現在の処理階層を意味する。新規ノードの登録はcNodeの子要素として登録される。<br>
    * indentDown, indentUpで階層を変更することができる。
    */
    public Node cNode = null;
    /**
    * 最新追加ノード<br>
    * 最後に追加されたノードを示す。<br>
    * トークンの追加はeNodeで指定されたノードに対して行われる。<br>
    * indentDown, indentUpで階層を変更しても、eNodeへの参照は変化しない。
    */
    public Node eNode = null;

    public Deque<String> selectStack = new ArrayDeque<>();

    /**
     * ノードの終端とすべきでない状態であることを表すフラグ<br>
     * このフラグがfalseである場合に、ノードの開始に相当するトークンが出現したら新規ノードが作られる。
     */
    public boolean initEnd = false;

    /**
     * 改行の直後であることを表すフラグ<br>
     * このフラグがtrueである場合は、改行の直後であることを示す。
     */
    public boolean prevCRLF = false;

    /**
     * 括弧()の入れ子レベルを表すカウンタ<br>
     * kakkoCountが0の場合は括弧外であることを表す。
     */
    public int kakkoCount = 0;

    public JspParseCtrl(String fileName) {
        tNode = Node.create(Node.T_MODULE, fileName);
        cNode = tNode;
        eNode = tNode;
        selectStack.clear();
    }

    /**
     * nodeで指定したノードをツリーに登録する。<br>
     * initEndのフラグをtrueに設定する。
     * @param node ノード
     */
    public void addNewNode(Node node) {
        this.cNode.add(node);
        this.eNode = node;
        this.initEnd = true;
    }

    /**
     * 最新追加ノード(eNode)にトークンを追加する。<br>
     * この処理ではinitEndは変更しない。
     * @param token トークン
     */
    public void addParam(Token token) {
        this.eNode.addParam(token);
    }

}
