<!DOCTYPE html>
<html>
<head>
<title>tag test</title>
</head>
<body>
   <c:forEach var="i" varStatus="s" items="${testDtoList}">
     <tis:checkbox property="testDtoList" suffix="item" indexed="true" id="chk_id_idx"/>
   </c:forEach>

   <c:forEach var="i" items="${testDtoList}">
     <tis:checkbox property="testDtoList" suffix="item" indexed="true" id="chk_id_idx"/>
   </c:forEach>
</body>
</html>