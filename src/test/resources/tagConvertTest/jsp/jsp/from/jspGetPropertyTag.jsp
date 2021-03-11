<%@ page import=""%>
<%@ page language="value" %>
<%@ page import="java.io.*,org.seasar.struts.annotation.IntegerType"%>
<!DOCTYPE html>
<html>
<head>
<title>tag test</title>
</head>
<body>
   <jsp:getProperty name="sess" property="value" />
   <jsp:getProperty name=123 property=123 />
   <jsp:getProperty name=123 />
</body>
</html>