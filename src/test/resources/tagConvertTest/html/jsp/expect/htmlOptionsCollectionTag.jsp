
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

<select name="beanCollectionSelect" size="10" multiple="multiple">
<c:forEach var="voc_pv_de7714fa" items="${testbean.beanCollection}">   
<option value="${voc_pv_de7714fa.value}">${voc_pv_de7714fa.label}</option></c:forEach></select>

     <n:submit type="submit" uri="/html-cancel-false.do"/>
  </n:form>
</body>
</html>