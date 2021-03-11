
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
      <c:forEach var="element" items="${bean.stringArray}" varStatus="status_index" begin="1" end="3"     >
<%Object index=pageContext.findAttribute("status_index.index");%><c:set var="index" value="${status_index.index}"/>        <li>
         <n:write name="element" />
        </li>
      </c:forEach>

     <c:forEach var="element"  >
        <li>
         <n:write name="element" />
        </li>
      </c:forEach>

     <c:forEach var="element" items="stringArray"  >
        <li>
         <n:write name="element" />
        </li>
      </c:forEach>
</body>
</html>