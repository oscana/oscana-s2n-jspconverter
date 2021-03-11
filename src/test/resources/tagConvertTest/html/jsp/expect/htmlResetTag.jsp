
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
  <n:form >

<input type="reset" value="Reset"/><%--Reset--%>
<input type="reset" value="<n:message messageId="sdas"/>"><%--
  <n:message messageId="sdas">sdas</n:message>
--%>
<input type="reset" />

     <n:submit type="submit" uri="/html-cancel-false.do"/>
  </n:form>
</body>
</html>