
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
   <c:forEach var="i" varStatus="s" items="${testDtoList}">
     <n:checkbox name="testDtoList[${s.index }]" label="item"  id="chk_id_idx" value="on"/>
   </c:forEach>

   <c:forEach var="i" items="${testDtoList}" varStatus="s">
     <n:checkbox name="testDtoList[${s.index }]" label="item"  id="chk_id_idx" value="on"/>
   </c:forEach>
</body>
</html>