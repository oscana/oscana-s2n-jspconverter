
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

     <n:submit uri="/html-cancel-false.do" type="submit" />

     <n:submit type="submit" uri="/html-cancel-false.do" />

      <c:set var="buttonsave">
<n:message messageId="button.save"/>
</c:set>
<n:submit type="submit2" uri="/html-cancel-false.do" value="${buttonsave}">      </n:submit>

  </n:form>
</body>
</html>