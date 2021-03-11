
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="n" uri="http://tis.co.jp/nablarch" %>
<%@ taglib prefix="f" uri="https://github.com/oscana/oscana-s2n-runtime-sastruts" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="value" %>
<%@ page import="java.io.*,oscana.s2n.validation.ParseInt"%>
<!DOCTYPE html>
<html>
<head>
<title>tag test</title>
</head>
<body>
   <n:write name="sess.value"  />
   <n:write name=123.123  />
   <n:write name=123 />
</body>
</html>