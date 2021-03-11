
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

<select name="resourcesSelect" size="3">
   <option <c:if test="${fn:contains(fn:join(resourcesSelect,''),'Resources 0')}">selected</c:if>  value="Resources 0"  /><n:message messageId="resources0"/>
   <option <c:if test="${fn:contains(fn:join(resourcesSelect,''),'Resources 1')}">selected</c:if>  value="Resources 1"  /><n:message messageId="resources1"/>
   <option <c:if test="${fn:contains(fn:join(resourcesSelect,''),'Resources 2')}">selected</c:if>  value="Resources 2"  /><n:message messageId="resources2"/>
   <option value="Resources 3"  />
</select>

     <n:submit type="submit" uri="/html-cancel-false.do"/>
  </n:form>
</body>
</html>