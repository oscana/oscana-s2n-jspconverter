package jp.co.tis.s2n.jspConverter.node;

import java.util.ArrayList;
import java.util.List;

import jp.co.tis.s2n.jspConverter.keyword.JspKeyword;
import jp.co.tis.s2n.jspConverter.token.Token;

/**
 * ノードクラス。<br>
 *
 * jspファイルをノード単位で読み込んで、変換を実施する。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class Node implements JspKeyword {

    public static final String SP1 = " ";

    /** * TOPノード  */
    public final static int T_MODULE = 1;
    /** * 一般ノード */
    public final static int T_NORMAL = 4;
    /** * 行コメント単体のノード  */
    public final static int T_COMMENT1 = 8;
    /** * ブロックコメント単体のノード */
    public final static int T_COMMENT2 = 16;

    private int type = T_NORMAL;

    private String name = null;;
    //１つ目のトークン
    private Token head = null;

    private List<Token> tokenList = new ArrayList<>();

    private List<Node> childNodeList = new ArrayList<>();

    private Node parent = null;


    public final static String NO_SUPPORT_LOG = "// TODO ツールで変換できません";

    private Node(int type, String name) {
        this.head = null;
        this.type = type;
        this.name = name;
    }

    private Node(Token token) {
        this.head = token;
        this.type = Node.T_NORMAL;
        this.name = token.getText();
    }

    /**
     * テキストとノードタイプを指定してノードを作成する。<br>
     * このメソッドはトークンを作らない
     * @param type ノードタイプ
     * @param name ノードのテキスト
     * @return ノード
     */
    public static Node create(int type, String name) {
        return new Node(type, name);
    }

    /**
     * 指定したトークンを１つ目のトークンに持つノードを作成する。<br>
     * タイプは一般ノード（T_NORMAL）が設定される。
     * @param token １つ目のトークン
     * @return ノード
     */
    public static Node create(Token token) {
        return new Node(token);
    }

    /**
     * ノードタイプを返す。
     * @return ノードタイプ
     */
    public int getType() {
        return type;
    }

    /**
     * ノードのテキストを取得する。<br>
     * １つ目のトークンがあれば１つ目のトークンのテキストを取得する。
     * @return ノードのテキスト
     */
    public String getName() {
        return name;
    }

    /**
     * １つ目のトークン以降のトークンを返す。<br>
     * 1つ目のトークンは含まない。<br>
     * ノード全体のトークンが必要な場合はgetAllTokensを使用する。
     * @return トークンリスト
     * @see Node#getAllTokens()
     */
    public List<Token> getParams() {
        return tokenList;
    }

    /**
     * トークンのテキスト取得する。
     * @return ノードのテキスト
     */
    public String getParamsString() {

        StringBuilder sb = new StringBuilder();
        for (Token token : tokenList) {
            if (token.getType() == Token.CRLF) {
                ;
            } else if (token.getType() == Token.SPACE) {
                sb.append(" ");
            } else {
                sb.append(token.getText());
            }
        }
        return sb.toString();

    }

    /**
     * このノードの子要素リストを返す。
     * @return ノードリスト
     */
    public List<Node> getChildren() {
        return childNodeList;
    }

    /**
     * このノードの親要素を返す。
     * @return ノード
     */
    public Node getParent() {
        return parent;
    }

    /**
     * このノード(this)の親ノードを設定する。
     * @param parent このノード(this)の親となるノード
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     * このノード(this)に子要素を追加する。<br>
     * 子要素はリストで管理され、順番が保持される。
     * @param node 子要素
     */
    public void add(Node node) {
        childNodeList.add(node);
        node.setParent(this);
    }

    /**
     * このノード(this)にトークンを追加する。
     * @param token トークン
     */
    public void addParam(Token token) {
        this.tokenList.add(token);
    }

    /**
     * Nodeの中身を文字列で応答する。
     * @return Nodeの中身（タイプは出力しない）
     */
    public String getString() {

        StringBuilder sb = new StringBuilder();

        sb.append(this.name);

        for (Token token : this.tokenList) {
            sb.append(token.getText());
        }

        return sb.toString();

    }

    /**
     * ノードの中身を改行せずに文字列形式で取得する。
     * @return ノードの文字列
     */
    public String getStringWithoutCRLF() {

        StringBuilder sb = new StringBuilder();

        if (head.getType() != Token.CRLF) {
            if (head.getType() == Token.SPACE) {
                ; //sb.append(" ");
            } else {
                sb.append(head.getText());
            }
        }

        for (Token token : this.tokenList) {
            if (token.getType() != Token.CRLF) {
                if (token.getType() == Token.SPACE) {
                    sb.append(SP1);
                } else if (token.getType() == Token.NAME) {
                    if (token.getText().equals("property")) {
                        sb.append("name");
                    } else {
                        sb.append(token.getText());
                    }
                } else {
                    sb.append(token.getText());
                }
            }
        }

        return sb.toString();

    }

}
