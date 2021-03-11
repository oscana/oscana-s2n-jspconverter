
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
     <n:a href="/add/" >tt</n:a>
<%-- // TODO ツールで変換できません 未サポート属性：module="as"  --%>
     <n:a href="/add/"  >tt</n:a>
<%-- // TODO ツールで変換できません 未サポート属性：clientValidate="true"  --%>
      <n:submit type="submit" uri="submit" value="tag test"  />
  </n:form>
</body>
</html>