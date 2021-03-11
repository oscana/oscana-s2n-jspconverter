
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
     <n:textarea name="userId" rows="3" cols="29" cssClass="input-textarea" errorCss="input-textareaErr" onblur="newObjList(sougouJsParam2, document.forms[0])" onfocus="copy(sougouJsParam2, document.forms[0])"/>
     <n:textarea name="userId" cssClass="input-textarea" errorCss="input-textareaErr" onblur="newObjList(sougouJsParam2, document.forms[0])" onfocus="copy(sougouJsParam2, document.forms[0])" cols="20" rows="2"/>
  </n:form>
</body>
</html>