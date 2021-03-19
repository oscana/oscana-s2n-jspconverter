<!DOCTYPE html>
<html>
<head>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*","java.awt.*" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-" prefix="example" %>
<%@ taglib uri="http://struts.apache.org/tags-" prefix="example" %>
<%@ taglib uri="http://sastruts.seasar.org" prefix="example" %>
<%@ taglib uri="http://www.tis.co.jp/s_web" prefix="example" %>
<%@ taglib uri="http://www.tis.co.jp/taglib_1_0" prefix="example" %>
<%@ taglib uri="http://www.tis.co.jp/taglib-tiles_1_0" prefix="example" %>
<%@ taglib uri="http://www.x.y" prefix="example" %>

<title>^=tag test ^tag</title>
</head>
<body>
<s:form enctype="multipart/form-data">
  <bean:cookie id="sess" name="JSESSIONID" value="JSESSIONID-IS-UNDEFINED" />
  <bean:cookie id="sess" name="<%=JSESSIONID%>" value="JSESSIONID-IS-UNDEFINED" />

  <bean:cookie id="sess" name="\\JSESSIONID\\" value="JSESSIONID-IS-UNDEFINED" />
  <!-- TokenMgr.procLargeThan(int, StringBuilder, PushbackReader) -->
  <bean:cookie id="sess" name="test" value="JSESSIONID-IS-UNDEFINED" >=fsd</bean:cookie>
  <s:submit property="submit" clientValidate="true">"\\test\\"</s:submit>
  <s:submit property="submit" clientValidate="true">'\\test'</s:submit>
</s:form>
<a:b/>
<!-- TokenMgr.procNumeric(int, StringBuilder, PushbackReader) のTEST -->
.00+3-1b-2B+2b-2E+1+2-1e-1.2-2+1e+b+1E+B+2sb+1SB+4.5+2B+2b+2D+1d+2Q+2B+2b+1q+2L+0..1240_$
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
<s:submit property="submit" >< test >test</s:submit>

$$b:x<br>
__a.c<br>
@@c_c<br>
/**



 */
 //test
■.
■,
■:
■;
■>
■(
■)
■
[aa]
{x}
}ss
]cc
123.33_33
..003
/*
/**/
/*////
a.
b:
</body>
</html>