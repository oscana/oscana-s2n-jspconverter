
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
    <c:if test="${!(empty cookie.JSESSIONID)}" >
            <c:if test="${fn:endsWith(cookie.JSESSIONID,\"0\")}"   >match</c:if>
            <c:if test="${!fn:endsWith(cookie.JSESSIONID,\"0\")}"   >notMatch</c:if>
  </c:if>
</body>
</html>