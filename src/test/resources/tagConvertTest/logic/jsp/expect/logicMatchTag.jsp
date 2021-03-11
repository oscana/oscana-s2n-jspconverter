
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
   <c:if test="${fn:endsWith(cookie.JSESSIONID,\"0\")}"   >match</c:if>
   <c:if test="${fn:contains(cookie.JSESSIONID , \"0\")}"  >match</c:if>
   <c:if test="${fn:startsWith(cookie.JSESSIONID,\"0\")}"   >match</c:if>
   <c:if test="${fn:contains(cookie.JSESSIONID , \"0\")}"   >match</c:if>
<%-- // TODO ツールで変換できません 未サポート属性：header="User-Agent"  --%>
   <c:if test="${fn:contains(null , \"Mozilla\")}"  >match</c:if>
   <c:if test="${fn:contains(param.param1 , \"value1\")}"  >match</c:if>
   <c:if test="${fn:contains(name , \"value1\")}"   >match</c:if>
   <c:if test="${fn:contains(param.param1 , \"null\")}"  >match</c:if>
   <c:if test="${fn:contains(param.param1 , value)}"  >match</c:if>
</body>
</html>