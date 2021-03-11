package jp.co.tis.s2n.jspConverter.node;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jp.co.tis.s2n.converterCommon.util.CustomTagUtils.CustomTagType;
import jp.co.tis.s2n.jspConverter.file.S2nFileWriter;
import jp.co.tis.s2n.jspConverter.keyword.JspKeyword;
import jp.co.tis.s2n.jspConverter.token.Token;


/**
 * ノートユーティリティクラス。
 *
 * @author Fumihiko Yamamoto
 */
public class NodeUtil implements JspKeyword {

    // selectタグのname値を保存しておく
    public static String selectTagName = null;
    public static String logicIterateTagId = null;

    /**
     * すべてのノードをリストに投入して返す。<br>
     * topNode自身は返さない。topNodeの子要素以下を再帰的に走査してリストにつめて返す。
     * @param topNode トップノード
     * @return ノードリスト
     */
    public static List<Node> findAllNode(Node topNode) {

        List<Node> findList = new ArrayList<>();
        findAllNode(topNode, findList);
        return findList;

    }

    private static void findAllNode(Node node, List<Node> findList) {

        findList.add(node);
        for (Node e : node.getChildren()) {
            findAllNode(e, findList);
        }

    }

    /**
     * このノードに対するTopノードを取得する。
     * @param node ノード
     * @return トップノード
     */
    public static Node getTopNode(Node node) {

        Node curNode = node;
        Node parent = node.getParent();

        while (parent != null) {
            curNode = parent;
            parent = curNode.getParent();
        }
        return curNode;

    }

    /**
     * Node検索を複数のキーで一括で実施する。
     * @param node ノード
     * @param keys キー
     * @param findList ノードリスト
     * @param ignoreList 無視したノードリスト
     */
    public static void findTagStartsWithAllNode(Node node, String[] keys, List<Node> findList, List<Node> ignoreList) {
        if (node.getParams().size() > 2) {
            if (node.getParams().get(0).getText().equals("<")) {
                if (node.getParams().get(1).getText().equals("/")) {
                    boolean findAndAdd = false;
                    for (int i = 0; i < keys.length; i++) {
                        String key = keys[i];
                        if (node.getParams().get(2).getText().startsWith(key)) {
                            findList.add(node);
                            findAndAdd = true;
                            break;
                        }
                    }
                    if (!findAndAdd) {
                        //ignoreListが付与された状況で、findListに入れなかった:付きノードがあればignoreListに保存
                        if (ignoreList != null && node.getParams().get(2).getText().contains(":")) {
                            ignoreList.add(node);
                        }

                    }

                } else {
                    boolean findAndAdd = false;
                    for (int i = 0; i < keys.length; i++) {
                        String key = keys[i];
                        if (node.getParams().get(1).getText().startsWith(key)) {
                            findList.add(node);
                            findAndAdd = true;
                            break;
                        }
                    }
                    if (!findAndAdd) {
                        //ignoreListが付与された状況で、findListに入れなかった:付きノードがあればignoreListに保存
                        if (ignoreList != null && node.getParams().get(1).getText().contains(":")) {
                            ignoreList.add(node);
                        }

                    }
                }
            }
        }

        for (Node e : node.getChildren()) {
            findTagStartsWithAllNode(e, keys, findList, ignoreList);
        }

    }

    /**
     * <%@～%>のディレクティブ行を抽出する。
     * @param node ノード
     * @param type タイプ(page, taglib など)
     */
    public static List<Node> findAllDirectiveNode(Node topNode, String type) {
        List<Node> findList = new ArrayList<>();
        findAllDirectiveNode(topNode, type, findList);
        return findList;

    }

    /**
     * <%@～%>のディレクティブ行を抽出する。
     * @param node ノード
     * @param type タイプ(page, taglib など)
     * @param findList ノードリスト
     */
    public static void findAllDirectiveNode(Node node, String type, List<Node> findList) {
        if (node.getString().startsWith("<%@ " + type) || node.getString().startsWith("<%@" + type)) {
            findList.add(node);
        }

        for (Node e : node.getChildren()) {
            findAllDirectiveNode(e, type, findList);
        }

    }

    /**
     * <%～%>のスクリプトレットを抽出する。<br>
     * このとき、<%@ のディレクティブは抽出しない。
     * @param topNode トップノード
     * @return ノードリスト
     */
    public static List<Node> findAllScriptletNode(Node topNode) {
        List<Node> findList = new ArrayList<>();
        findAllScriptletNode(topNode, findList);
        return findList;

    }

    /**
     * <%～%>のスクリプトレットを抽出する。<br>
     * このとき、<%@ のディレクティブは抽出しない。
     * @param node ノード
     * @param findList ノードリスト
     */
    public static void findAllScriptletNode(Node node, List<Node> findList) {

        if (node.getParams().size() > 2) {
            if (node.getParams().get(0).getText().equals("<")) {
                if (node.getParams().get(1).getText().equals("%")) {
                    //スクリプトレットかディレクティブ確定
                    if (node.getParams().get(2).getText().equals("@")) {
                        //ディレクティブ確定＝抽出対象外
                    } else {
                        //スクリプトレットでありディレクティブではないので抽出する
                        findList.add(node);
                    }
                }
            }
        }

        for (Node e : node.getChildren()) {
            findAllScriptletNode(e, findList);
        }

    }

    /**
     * 指定したノードをファイル出力用に変換する。
     * @param fw ファイル出力
     * @param node ノード
     * @throws IOException 例外
     */
    public static void fprintAll(S2nFileWriter fw, Node node) throws IOException {

        if (node.getType() != Node.T_MODULE) {
            fw.fprint(node.getName());
            for (Token token : node.getParams()) {
                fw.fprint(token.getText());
            }
        }
        for (Node node1 : node.getChildren()) {
            fprintAllSub(fw, node1, 0);
        }

    }

    private static void fprintAllSub(S2nFileWriter fw, Node node, int depth) throws IOException {

        fw.fprint(node.getName());
        for (Token token : node.getParams()) {
            fw.fprint(token.getText());
        }

        depth++;
        for (Node node1 : node.getChildren()) {
            fprintAllSub(fw, node1, depth);
        }

    }

    /**
     * このノードをカスタムタグとしてみたときに、そのbodyの要素となるnodeをかえす。
     * @param nw ノードラッパ
     * @return ノードリスト
     */
    public static List<Node> getBodyAsCustomTag(NodeWrapper nw) {
        Node curNode = nw.getNode();
        List<Node> customTagBased = new ArrayList<Node>();
        List<Node> allNodeList = findAllNode(getTopNode(curNode));
        int pos = allNodeList.indexOf(curNode);
        String tagName = nw.getTagName();
        for (int i = pos + 1; i < allNodeList.size(); i++) {
            Node tNode = allNodeList.get(i);
            NodeWrapper tNodeWrapper = new NodeWrapper(tNode);
            if (tNodeWrapper.getNodeType() == CustomTagType.EndTag) {
                //終了タグ検出
                if (tNodeWrapper.getTagName().equals(tagName)) {
                    return customTagBased;
                }
            } else {
                customTagBased.add(tNode);
            }
        }
        //終了タグが見つからないなら空にする
        customTagBased.clear();
        return customTagBased;
    }

    /**
     * タグのボディをコメントアウトする。
     * @param bodyList ボディ部が格納されたリスト
     */
    public static void commentoutBody(List<Node> bodyList) {
        NodeUtil.insertPrev(bodyList.get(0), Node.create(new Token(Token.JSP_COMMENT, "<%--")));
        NodeUtil.insertAfter(bodyList.get(bodyList.size() - 1), Node.create(new Token(Token.JSP_COMMENT, "--%>")));
    }

    /**
     * ボディを丸ごと変数に代入する。
     * @param vname 変数
     * @param bodyList ボディ部が格納されたリスト
     */
    public static void assignBodytoVariable(String vname, List<Node> bodyList) {
        NodeUtil.insertPrev(bodyList.get(0),
                Node.create(new Token(Token.JSP_COMMENT, "<c:set var=\"" + vname + "\">")));
        NodeUtil.insertAfter(bodyList.get(bodyList.size() - 1), Node.create(new Token(Token.JSP_COMMENT, "</c:set>")));
    }

    /**
     * targetNodeで指定したノードの次に新規ノードを追加する。
     * @param targetNode 挿入位置基準となるノード
     * @param create 新規ノード
     */
    public static void insertAfter(Node targetNode, Node create) {
        int pos = targetNode.getParent().getChildren().indexOf(targetNode); //getChildrenで正しい
        targetNode.getParent().getChildren().add(pos + 1, create);
        create.setParent(targetNode.getParent());
    }

    /**
     * targetNodeで指定したノードの次に新規テキストノードを追加する。<br>
     * 追加するノードはToken.NAMEとなる。
     * @param targetNode 挿入位置基準となるノード
     * @param nodeText 挿入するテキスト
     */
    public static void insertAfter(Node targetNode, String nodeText) {
        insertAfter(targetNode, Node.create(new Token(Token.NAME, nodeText)));

    }

    /**
     * targetNodeで指定したノードの前に新規ノードを追加する。
     * @param targetNode 挿入位置基準となるノード
     * @param create 新規ノード
     */
    public static void insertPrev(Node targetNode, Node create) {
        int pos = targetNode.getParent().getChildren().indexOf(targetNode);//getChildrenで正しい
        addChildNode(targetNode.getParent(), pos, create);
        create.setParent(targetNode.getParent());
    }

    /**
     * 既存ノードをtargetNodeで指定したノードの前に移動する。
     * @param targetNode 挿入位置基準となるノード
     * @param moveNode 移動するノード
     */
    public static void movePrev(Node targetNode, Node moveNode) {

        //移動元から削除
        removeChildNode(moveNode);
        //移動先へ移動
        int pos = targetNode.getParent().getChildren().indexOf(targetNode);//getChildrenで正しい
        addChildNode(targetNode.getParent(), pos, moveNode);
        moveNode.setParent(targetNode.getParent());
    }

    /**
     * targetNodeで指定したノードの前に新規テキストノードを追加する。<br>
     * 追加するノードはToken.NAMEとなる。
     * @param targetNode 挿入位置基準となるノード
     * @param nodeText 挿入するテキスト
     */
    public static void insertPrev(Node targetNode, String nodeText) {
        insertPrev(targetNode, Node.create(new Token(Token.NAME, nodeText)));
    }

    /**
     * 指定した親ノードの指定した位置に子ノードを追加する。<br>
     * 親→子、子→親の相互リンクを形成する。
     * @param parent 追加する親ノード
     * @param pos 追加位置インデックス
     * @param trgNode 追加する子ノード
     */
    public static void addChildNode(Node parent, int pos, Node trgNode) {
        parent.getChildren().add(pos, trgNode);
        trgNode.setParent(parent);
    }

    /**
     * 指定したノードを親ノードから切り離す。<br>
     * 親ノードはtrgNode.getParentで確認する。<br>
     * 親→子、子→親の相互リンクを削除する。
     * @param trgNode 削除するノード
     */
    public static void removeChildNode(Node trgNode) {
        trgNode.getParent().getChildren().remove(trgNode);
        trgNode.setParent(null);

    }

}
