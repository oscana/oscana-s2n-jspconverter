package jp.co.tis.s2n.jspConverter.parser;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import jp.co.tis.s2n.converterCommon.log.LogUtils;
import jp.co.tis.s2n.jspConverter.node.Node;
import jp.co.tis.s2n.jspConverter.token.Token;
import jp.co.tis.s2n.jspConverter.token.TokenMgr;

/**
 * Nodeツリー組み立て<br>
 * ファイルを読み込み、Tokenに分解したうえで、Nodeツリーを組み立てて返す。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class JspParser {

    /**
     * ファイルとして入力したJspソースコードをパースし、Nodeを取得する。
     * @param inFilePath 対象ファイルのあるディレクトリ
     * @param fileName 読み込むファイル
     * @param inCodeName ファイルのエンコード
     * @return ノード
     */
    public static Node parse(String inFilePath, String fileName, String inCodeName) {

        JspParseCtrl parseCtrl = new JspParseCtrl(fileName);
        try (Reader reader = new InputStreamReader(new FileInputStream(inFilePath), inCodeName)) {
            parseMain(reader, parseCtrl, fileName);
        } catch (Exception e) {
            LogUtils.warn(inFilePath, "パースに失敗しました", e);
        }
        return parseCtrl.tNode;
    }

    private static Node parseMain(Reader reader, JspParseCtrl parseCtrl, String fileName) {
        try (PushbackReader pbr = new PushbackReader(reader, 3)) {

            TokenMgr mgr = new TokenMgr(pbr, fileName);

            Token token1 = null;
            Token token2 = null;

            int tagNestCount = 0;

            for (;;) {

                token1 = mgr.getToken(tagNestCount);
                tagNestCount = judgeTagNest(tagNestCount, token1);

                if (token1.getType() == Token.EOF) {
                    break;
                }

                if (token1.getType() == Token.SPACE) {

                    token2 = mgr.getToken(tagNestCount);
                    tagNestCount = judgeTagNest(tagNestCount, token2);

                    if (token2.getText().startsWith("<")) {
                        parseCtrl.addNewNode(Node.create(token1));
                        parseCtrl.addParam(token2);
                    } else {
                        parseCtrl.addParam(token1);
                        parseCtrl.addParam(token2);
                    }
                } else {
                    if (token1.getText().startsWith("<")) {
                        parseCtrl.addNewNode(Node.create(new Token(Token.EMPTY, "")));
                        parseCtrl.addParam(token1);
                    } else {
                        parseCtrl.addParam(token1);
                    }
                }

                boolean bLoop = true;

                for (;;) {

                    token1 = mgr.getToken(tagNestCount);
                    tagNestCount = judgeTagNest(tagNestCount, token1);

                    if (token1.getType() == Token.EOF) {
                        bLoop = false;
                        break;
                    }
                    if (token1.getType() == Token.CRLF) {
                        parseCtrl.addParam(token1);
                        break;
                    }
                    parseCtrl.addParam(token1);
                }

                if (bLoop == false) {
                    break;
                }

            }

        } catch (Exception ex) {
            LogUtils.warn(fileName, "パースに失敗しました", ex);
        }

        coordinate(parseCtrl);

        return parseCtrl.tNode;
    }

    /**
     * このトークンによるタグ階層の変動を評価しtagNestCountを更新する。
     * @param tagNestCount 現在のtagNestCount
     * @param token 評価対象トークン
     * @return 変動後のtagNestCount
     */
    public static int judgeTagNest(int tagNestCount, Token token) {
        if (token.getText() != null) {
            if (token.getText().equals("<")) {
                tagNestCount++;
            } else if (token.getText().equals(">")) {
                if (tagNestCount > 0) {
                    tagNestCount--;
                }
            }
        }
        return tagNestCount;
    }

    /**
     * ノードの再精査を実施する。
     * @param parseCtrl パース
     */
    public static void coordinate(JspParseCtrl parseCtrl) {

        for (Node node : parseCtrl.tNode.getChildren()) {
            List<Token> tokenList = node.getParams();
            List<Token> backupList = new ArrayList<>();
            for (Token token : tokenList) {
                backupList.add(token);
            }
            tokenList.clear();
            node.addParam(backupList.get(0));

            coordinateSub(node, backupList);
        }

    }

    private static void coordinateSub(Node node, List<Token> backupList) {

        Node currentNode = node;
        boolean bEndTag = false;
        boolean bStartTag = true;
        for (int i = 1; i < backupList.size(); i++) {
            Token token = backupList.get(i);
            String tokenText = token.getText();
            if (tokenText.equals("<")) {
                // 次のパラメータがスペースの場合、タグとして認識したい
                // 様に制御する。
                if (backupList.get(i + 1).getType() != Token.SPACE) {
                    // bEndTag が true の時は、事前に作られた新規ノードに
                    // 対して、addParam(token)を呼ぶ様に制御する。
                    if (bEndTag == false) {
                        currentNode = Node.create(new Token(Token.EMPTY, ""));
                        node.add(currentNode);
                    }
                    currentNode.addParam(token);
                    bStartTag = true;
                    bEndTag = false;
                } else {
                    currentNode.addParam(token);
                }
            } else if (tokenText.equals(">")) {
                if (bStartTag) {
                    currentNode.addParam(token);
                    if (i < (backupList.size() - 1)) {
                        currentNode = Node.create(new Token(Token.EMPTY, ""));
                        node.add(currentNode);
                    }
                    bStartTag = false;
                    bEndTag = true;
                } else {
                    currentNode.addParam(token);
                }
            } else {
                currentNode.addParam(token);
                bEndTag = false;
            }
        }
    }

}
