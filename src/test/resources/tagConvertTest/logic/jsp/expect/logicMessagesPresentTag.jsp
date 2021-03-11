
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
<%-- // TODO ツールで変換できません 未サポート属性：message="true"  --%>
    <c:if test="${!empty errors}" >
<%-- // TODO ツールで変換できません 未サポート属性：id="msg"  message="true"  --%>
<n:write name="messages"/>       <%--
          <p><strong><n:write name="msg" /></strong></p>
--%>      
    </c:if>
<%-- // TODO ツールで変換できません 未サポート属性：message="true"  --%>
    <c:if test="${!empty errors.getMessage('name')}"  >
<%-- // TODO ツールで変換できません 未サポート属性：id="msg"  message="true"  --%>
<n:write name="messages"/>       <%--
          <p><strong><n:write name="msg" /></strong></p>
--%>      
    </c:if>
<%-- // TODO ツールで変換できません 未サポート属性：message="true"  --%>
    <c:if test="${!empty errors.getMessage('property')}"  >
<%-- // TODO ツールで変換できません 未サポート属性：id="msg"  message="true"  --%>
<n:write name="messages"/>       <%--
          <p><strong><n:write name="msg" /></strong></p>
--%>      
    </c:if>
<%-- // TODO ツールで変換できません 未サポート属性：message="true"  --%>
    <c:if test="${!empty errors.getMessage('name.property')}"   >
<%-- // TODO ツールで変換できません 未サポート属性：id="msg"  message="true"  --%>
<n:write name="messages"/>       <%--
          <p><strong><n:write name="msg" /></strong></p>
--%>      
    </c:if>
</body>
</html>