
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

<c:set var="dummy" value="${header.UNKNOWN-HEADER}"   /><%Object dummy=pageContext.findAttribute("dummy");%>

 <%-- // TODO ツールで変換できません 未サポート属性：clientValidate="true"  --%>
<n:submit type="submit" uri="submit" value="test"  />
</n:form>
</body>
</html>