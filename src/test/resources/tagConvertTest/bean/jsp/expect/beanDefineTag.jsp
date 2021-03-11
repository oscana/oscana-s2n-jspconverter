
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

  <c:set var="test1_string" value="${test1.stringProperty}"  /><%Object test1_string=pageContext.findAttribute("test1_string");%>
  <c:set var="test1_value" value="ABCDE"  />
<%Object test1_value=pageContext.findAttribute("test1_value");%> <c:set var="name" value='<%=name%>' />    <c:set var="test1_value" value="${[name]}" />

 <%-- // TODO ツールで変換できません 未サポート属性：clientValidate="true"  --%>
<n:submit type="submit" uri="submit" value="test"  />
<%Object test1_value=pageContext.findAttribute("test1_value");%></n:form>
</body>
</html>