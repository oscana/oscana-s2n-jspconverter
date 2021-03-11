
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
  <n:form >

<%-- // TODO ツールで変換できません 未サポート属性：module="/validator"  --%>
<n:img src="/struts-power.gif" alt="/struts-power.gif" />
<%-- // TODO ツールで変換できません 未サポート属性：module="/"  --%>
<n:img src="/struts-power.gif" alt="/struts-power.gif" />
<n:img src="/struts-power.gif" alt="/struts-power.gif"/>

     <n:submit type="submit" uri="/html-cancel-false.do"/>
  </n:form>
</body>
</html>