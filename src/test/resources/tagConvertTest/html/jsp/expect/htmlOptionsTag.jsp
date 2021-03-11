
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

            <select name="multipleSelect" size="10" multiple="multiple">
<c:forEach var="vn_pv_3d32d9b4" items="${multipleValues}">              
<option value="${vn_pv_3d32d9b4}">${vn_pv_3d32d9b4}</option></c:forEach>            </select>

           <select name="multipleSelect" size="10" multiple="multiple">
              
            </select>

             <select name="multipleSelect" size="10" multiple="multiple">
<c:forEach var="vn_pv_3d32d9b4" items="${multipleValues}">              
<option value="${vn_pv_3d32d9b4}">${vn_pv_3d32d9b4}</option></c:forEach>            </select>

             <select name="multipleSelect" size="10" multiple="multiple">
<c:forEach var="vc_collect" items="collect">              
<option value="${vc_collect.value}">${vc_collect.label}</option></c:forEach>            </select>

     <n:submit type="submit" uri="/html-cancel-false.do"/>
  </n:form>
</body>
</html>