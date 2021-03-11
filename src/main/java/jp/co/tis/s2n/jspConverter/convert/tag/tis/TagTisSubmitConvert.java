package jp.co.tis.s2n.jspConverter.convert.tag.tis;

import jp.co.tis.s2n.converterCommon.util.StringUtils;
import jp.co.tis.s2n.jspConverter.node.NodeWrapper;

/**
 * TisSubmitタグ変換用クラス。
 *
 * @author Fumihiko Yamamoto
 *
 */
public class TagTisSubmitConvert extends TagTisConvertBase {
    @Override
    protected void convertStartProc(NodeWrapper nw) {

        String refPath = StringUtils
                .getDirectoryFromFilePath(StringUtils.relativeFilePath(config.inPath, config.inFilePath));
        String actionUri = refPath.replace("\\", "/") + nw.getValueAsString("name");

        nw.addKeyValue("uri", actionUri);

        nw.renameKeyString("styleClass", "cssClass");
        nw.renameKeyString("styleId", "id");
        logNotSupported(nw, "keyValue");
        logNotSupported(nw, "unEditableName");
        logNotSupported(nw, "unEditableValue");
        logNotSupported(nw, "unEditableKeyValue");
        logNotSupported(nw, "unEditable");
        logNotSupported(nw, "indexed");

        if (!nw.isContainsKey("type")) {
            nw.addKeyValue("type", "submit");
        }

    }
}
