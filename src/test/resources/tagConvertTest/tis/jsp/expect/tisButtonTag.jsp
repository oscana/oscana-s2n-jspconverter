
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="n" uri="http://tis.co.jp/nablarch" %>
<%@ taglib prefix="f" uri="https://github.com/oscana/oscana-s2n-runtime-sastruts" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>tag test</title>
</head>
<body>
   <n:form enctype="multipart/form-data">
	<%-- // TODO ツールで変換できません 未サポート属性：keyValue="labels.bVal1"  unEditableKeyValue="labels.bUnEdiVal"  unEditableName="bUnEdiNm"  --%>
<n:button name="button5"    disabled="false" uri="button5" >ボタン</n:button>
	<%-- // TODO ツールで変換できません 未サポート属性：keyValue="labels.bVal1"  unEditable="true"  unEditableKeyValue="labels.bUnEdiVal"  unEditableName="bUnEdiNm"  --%>
<n:button name="button5"     disabled="false" uri="button5" >ボタン</n:button>
	<%-- // TODO ツールで変換できません 未サポート属性：unEditableKeyValue="labels.bUnEdiVal"  unEditableName="bUnEdiNm"  --%>
<n:button name="button5" value="labels.bVal1"   disabled="false" uri="button5" >labels.bVal1</n:button>
	<%-- // TODO ツールで変換できません 未サポート属性：keyValue="labels.bVal1"  --%>
<n:button name="button5"  disabled="false" uri="button5" >ボタン</n:button>
	<n:button name="button5" value="labels.bVal1" disabled="false" uri="button5" >labels.bVal1</n:button>
	<%-- // TODO ツールで変換できません 未サポート属性：unEditableName="doRegist"  unEditableValue="test"  --%>
<n:button name="doConfirm" value="test"   onclick="javascript:ConfirmOrRegist(1,2)" cssClass="button" uri="doConfirm" >test</n:button>
	<%-- // TODO ツールで変換できません 未サポート属性：unEditable="null"  unEditableName="doRegist"  unEditableValue="test"  --%>
<n:button name="doConfirm" value="test"    onclick="javascript:ConfirmOrRegist(1,2)" cssClass="button" uri="doConfirm">test</n:button>ボタン</n:button>
	<%-- // TODO ツールで変換できません 未サポート属性：unEditable="true"  unEditableName="doRegist"  unEditableValue="test"  --%>
<n:button name="doConfirm" value="test"    onclick="javascript:ConfirmOrRegist(1,2)" cssClass="button" uri="doConfirm" >test</n:button>
	<%-- // TODO ツールで変換できません 未サポート属性：unEditable="true"  unEditableName="doRegist"  unEditableValue="test"  --%>
<n:button name="doConfirm" value=""    onclick="javascript:ConfirmOrRegist(1,2)" cssClass="button" uri="doConfirm" >ボタン</n:button>


   </n:form>
</body>
</html>