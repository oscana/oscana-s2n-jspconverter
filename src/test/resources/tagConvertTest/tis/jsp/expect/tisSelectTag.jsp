
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
<n:select name="tableNo"  listName="tableDispMap" cssClass="input-text" errorCss="input-text errorClass"   withNoneOption="true" elementValueProperty="true" elementLabelProperty="label"/>
<n:select codeid="tableno"  listName="tabledispmap" styleclass="input-text" errorstyleclass="input-text errorclass"  disponlyimiflg="true" withNoneOption="true" elementValueProperty="true" elementLabelProperty="label"/>
<n:codeSelect codeId="tableNo" multiple="multiple"  cssClass="input-text" errorCss="input-text errorClass"   withNoneOption="true"/>
  </n:form>
</body>
</html>