
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="n" uri="http://tis.co.jp/nablarch" %>
<%@ taglib prefix="f" uri="https://github.com/oscana/oscana-s2n-runtime-sastruts" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*","java.awt.*" %>
<title>^=tag test ^tag</title>
</head>
<body>
<n:form enctype="multipart/form-data">
  <n:set var="sess" value="${cookie.JSESSIONID}"   />
 <c:set var="JSESSIONID" value="<%=JSESSIONID%>" />  <n:set var="sess" value="${cookie[JSESSIONID]}"   />

  <n:set var="sess" value="${cookie.\\JSESSIONID\\}"   />
  <!-- TokenMgr.procLargeThan(int, StringBuilder, PushbackReader) -->
  <bean:cookie var="sess"   >=fsd value="${cookie.test}"</n:set>
<%-- // TODO ツールで変換できません 未サポート属性：clientValidate="true"  --%>
  <n:submit type="submit" uri="submit" value=""\\test\\""  />
<%-- // TODO ツールで変換できません 未サポート属性：clientValidate="true"  --%>
  <n:submit type="submit" uri="submit" value="'\\test'"  />
</n:form>
<!-- TokenMgr.procNumeric(int, StringBuilder, PushbackReader) のTEST -->
.00+3-1b-2B+2b-2E+1+2-1e-1.2-2+1e+b+1E+B+2sb+1SB+4.5+2B+2b+2D+1d+2Q+2B+2b+1q+2L+0..1240
<!-- TokenMgr.procLessThan(int, StringBuilder, PushbackReader) -->
<=-- test --=>
<%-d test --%>
<!-- TokenMgr.procJspComment(StringBuilder, PushbackReader) -->
<%-- test --%>
<%--- test ---%%>
<%-----test--%>
<!-- TokenMgr.procOr(int, StringBuilder, PushbackReader) -->
|TEST
||T
<!-- TokenMgr.procSingleQuote(int, StringBuilder, PushbackReader, int) -->
'\\test'
\r<a>:</a>;
<!-- TokenMgr.procAster(int, StringBuilder, PushbackReader) -->
**TEST
*TEST
</body>
</html>