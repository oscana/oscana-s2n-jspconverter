package jp.co.tis.s2n.jspConverter.node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jp.co.tis.s2n.converterCommon.util.CustomTagUtils;
import jp.co.tis.s2n.converterCommon.util.CustomTagUtils.CustomTagType;
import jp.co.tis.s2n.jspConverter.token.Token;

/**
 * JSPタグNodeの操作を簡素化するラッパクラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class NodeWrapper {

    private Node node;

    public NodeWrapper(Node node) {
        this.node = node;
    }

    /**
     * Nodeを取得する。
     * @return ノード
     */
    public Node getNode() {
        return this.node;
    }

    /**
     * ノードに指定したキーが含まれるか確認する。
     * @param key キー
     * @return チェック結果、含まれる場合：true、その以外：false
     */
    public boolean isContainsKey(String key) {
        for (Token token : node.getParams()) {
            if (token.getText().equals(key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 指定した属性の値を取得する。
     * @param key キー
     * @return 値の格納されたトークン
     */
    public Token getValueAsToken(String key) {
        for (int i = 0; i < node.getParams().size(); i++) {
            Token token = node.getParams().get(i);
            if (token.getText().equals(key)) {
                return node.getParams().get(i + 2);
            }
        }
        return null;
    }

    /**
     * 指定した属性値を取得する。<br>
     * WithoutQuoteにて取得するのでSTRING1、STRING2の場合のクオートは取りずされる。
     * @param key キー
     * @return クオート無しの値
     */
    public String getValueAsString(String key) {
        Token token = getValueAsToken(key);
        if (token != null) {
            return token.getTextWithoutQuote();
        } else {
            return null;
        }
    }

    /**
     * 指定した属性値を設定する。<br>
     * WithoutQuoteにて設定するのでSTRING1、STRING2の場合のクオートは自動的に付与される。
     * @param key キー
     * @param value クオート無しの値
     */
    public void setValueAsString(String key, String value) {
        Token t = getValueAsToken(key);
        t.setTextWithoutQuote(value);

    }

    /**
     * キーがあれば別の名前に変更する。
     * @param srcKey 変更元キー
     * @param destKey 変更後キー
     * @return 変更したならtrue
     */
    public boolean renameKeyString(String srcKey, String destKey) {
        for (Token token : node.getParams()) {
            if (token.getText().equals(srcKey)) {
                token.setText(destKey);
                return true;
            }
        }
        return false;
    }

    /**
     * キーがあれば削除する。
     * @param srcKey 削除対象キー
     * @return 削除したならtrue
     */
    public boolean removeKeyValue(String srcKey) {
        for (int i = 0; i < node.getParams().size(); i++) {
            Token token = node.getParams().get(i);
            if (token.getText().equals(srcKey)) {
                node.getParams().remove(i);
                node.getParams().remove(i);
                node.getParams().remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * データを新しく追加する。
     * @param key 登録するキー
     * @param value 登録する値
     */
    public void addKeyValue(String key, String value) {

        int pos = -1;

        for (int i = (node.getParams().size() - 1); i >= 0; i--) {
            Token token = node.getParams().get(i);
            if (token.getType() == Token.NAME
                    || token.getType() == Token.STRING1
                    || token.getType() == Token.STRING2) {
                pos = (i + 1);
                break;
            }
        }
        node.getParams().add(pos++, new Token(Token.SPACE, " "));
        node.getParams().add(pos++, new Token(Token.NAME, key));
        node.getParams().add(pos++, new Token(Token.EQ1, "="));
        node.getParams().add(pos++, new Token(Token.STRING2, "\"" + value + "\""));

    }

    /**
     * タグのToken値を書き換える。<br>
     * 各トークンに対してString.replaceを実施し、置換文字列に一致すれば置換する。
     * @param srcName 置換元文字列（正規表現ではない）
     * @param destName 置換先文字列
     */
    public void replaceTag(String srcName, String destName) {
        for (Token token : this.node.getParams()) {
            if (token.getText().startsWith(srcName)) {
                token.setText(token.getText().replace(srcName, destName));
            }
        }
    }

    /**
     * カスタムタグとしてノードを評価したときのノードタイプを取得する。
     * @return ノードタイプ
     */
    public CustomTagType getNodeType() {
        return CustomTagUtils.evalAsJSPTag(this.node.getParamsString());
    }

    /**
     * タグの名前を取得する。
     * @return タグ名
     */
    public String getTagName() {
        //TagTest
        if (getNodeType() == CustomTagType.NotCustomTag) {
            //タグでないならnull
            return null;
        }

        for (Token token : this.node.getParams()) {
            if (token.getText().matches("^\\w+:\\w+$")) {
                //名前の Token
                return token.getText();
            }
        }
        return null;
    }

    /**
     * タグ名を置換する。
     * @param toTagName 置換先名称  "n:text"のようなフル形式を指定すること
     */
    public void renameTagName(String toTagName) {
        replaceTag(getTagName(), toTagName);
    }

    /**
     * このノードのすべてのトークンを削除する。<br>
     * ノードオブジェクトは残りますが、出力しても空文字になるので出力上は消去と同じ。
     */
    public void removeAllTokens() {
        this.node.getParams().clear();
    }

    /**
     * このノードのシグネチャを取得する。
     * @return シグネチャ
     */
    public String getSignature() {
        List<Token> tokens = this.node.getParams();
        List<String> keys = new ArrayList<String>();
        String paramData = null;
        Token prevNameToken = null;
        int searchStep = 0;
        for (Token curToken : tokens) {
            if (searchStep == 0) {
                //Key Search
                if (curToken.getType() == Token.NAME) {
                    //NAMEトークンがあれば名前候補としてprevNameTokenに保持
                    prevNameToken = curToken;
                } else if (curToken.getType() == Token.EQ1) {
                    //EQトークンがあればprevNameTokenに保持していたトークンが名前であることが確定する
                    paramData = prevNameToken.getText();
                    searchStep = 1;
                }
            } else {
                //Value Search
                switch (curToken.getType()) {
                case Token.STRING1:
                case Token.STRING2:
                    searchStep = 0;
                    keys.add(paramData);
                    break;
                case Token.NUMERIC:
                    searchStep = 0;
                    keys.add(paramData);
                    break;
                case Token.EQ1:
                case Token.EQ2:
                case Token.SYMBOL:
                case Token.COLON:
                case Token.SEMICOLON:
                    //パラメータではないので抽出をキャンセル
                    searchStep = 0;
                    break;
                default:
                    break;
                }
            }
        }
        Collections.sort(keys);
        StringBuffer sb = new StringBuffer();
        for (String key : keys) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(key);
        }
        return sb.toString();
    }
}
