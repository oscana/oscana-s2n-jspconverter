<!DOCTYPE html>
<html>
<head>
<title>tag test</title>
</head>
<body>
   <s:form enctype="multipart/form-data">
	<tis:button name="button5" keyValue="labels.bVal1" unEditableName="bUnEdiNm" unEditableKeyValue="labels.bUnEdiVal" disabled="false" />
	<tis:button name="button5" keyValue="labels.bVal1" unEditable="true" unEditableName="bUnEdiNm" unEditableKeyValue="labels.bUnEdiVal" disabled="false" />
	<tis:button name="button5" value="labels.bVal1" unEditableName="bUnEdiNm" unEditableKeyValue="labels.bUnEdiVal" disabled="false" />
	<tis:button name="button5" keyValue="labels.bVal1" disabled="false" />
	<tis:button name="button5" value="labels.bVal1" disabled="false" />
	<tis:button name="doConfirm" value="test" unEditableName="doRegist" unEditableValue="test" onclick="javascript:ConfirmOrRegist(1,2)" styleClass="button" />
	<tis:button name="doConfirm" value="test" unEditable="" unEditableName="doRegist" unEditableValue="test" onclick="javascript:ConfirmOrRegist(1,2)" styleClass="button" >ボタン</tis:button>
	<tis:button name="doConfirm" value="test" unEditable="true" unEditableName="doRegist" unEditableValue="test" onclick="javascript:ConfirmOrRegist(1,2)" styleClass="button" />
	<tis:button name="doConfirm" value="" unEditable="true" unEditableName="doRegist" unEditableValue="test" onclick="javascript:ConfirmOrRegist(1,2)" styleClass="button" />


   </s:form>
</body>
</html>