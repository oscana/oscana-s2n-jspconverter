
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
   <n:form action="/test">
    <input type="text" id="fname" name="fname"><br><br>
<n:button uri="fname">Submit</n:button>    
  </n:form>
    <input type="text" id="fname" name="fname"><br><br>
    <input type="submit" value="Submit" name="fname">
</body>
</html>