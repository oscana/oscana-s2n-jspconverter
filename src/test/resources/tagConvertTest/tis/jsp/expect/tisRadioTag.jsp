
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
   <n:form enctype="multipart/form-data">
<n:radioButtons name="radio001_021"  listName="option001_021" elementValueProperty="true" elementLabelProperty="label" />
<n:radioButtons name="radio001_021"  listName="option001_021" />
<n:codeRadioButtons name="radio001_021"  codeId="option001_021" />
<n:radioButton name="radio001_021"  />
   </n:form>
</body>
</html>