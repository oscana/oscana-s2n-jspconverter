
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
 <c:set var="pv_4a529699" value="<%= bool1 %>" />   <c:if test="${bean.booleanProperty == pv_4a529699}"   >equal</c:if>
   <c:if test="${bean.booleanProperty == \"2\"}"   >equal</c:if>
   <c:if test="${form.xxx == \"xxx\"}"   >
      case1
   </c:if>
</body>
</html>