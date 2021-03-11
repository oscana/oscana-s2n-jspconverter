
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
	<%-- // TODO ツールで変換できません 未サポート属性：unEditableName="doRegist"  unEditableValue="�o�^"  --%>
<n:button name="doConfirm" value="�m�F"   onclick="javascript:ConfirmOrRegist(1,2)" cssClass="button" uri="#" >�m�F</n:button>
	<%-- // TODO ツールで変換できません 未サポート属性：unEditableName="doRegist"  unEditableValue="�o�^"  --%>
<n:button name="doConfirm" value="�m�F"    onclick="javascript:ConfirmOrRegist(1,2)" cssClass="button" uri="#" >�m�F</n:button>
	<n:button name="doConfirm" value="�m�F" onclick="javascript:ConfirmOrRegist(1,2)" cssClass="button" uri="#" >�m�F</n:button>
   </n:form>
</body>
</html>