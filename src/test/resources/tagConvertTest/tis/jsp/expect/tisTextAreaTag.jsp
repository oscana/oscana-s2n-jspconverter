
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
     <n:text name="userId" id="loginpwd" onblur="newObjList()" onfocus="copy()" maxlength="10" size="20" readonly="false" cssClass="input-text" errorCss="input-text errorClass"  />
  </n:form>
</body>
</html>