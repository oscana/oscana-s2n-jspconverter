
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

<%-- // TODO ツールで変換できません 未サポート属性：list="#fileList_${s.index}"  max="2"  --%>
<n:file  accept="txt|csv|xls"  name="uploadFilesList.uploadFiles"  size="30"  cssClass="input-file ime-disabled" errorCss="input-file ime-disabled input-error" />
<%-- // TODO ツールで変換できません 未サポート属性：list="#fileList_${s.index}"  max="2"  --%>
<n:file name="uploadFiles" accept="txt|csv|xls"   size="30"  cssClass="input-file ime-disabled" errorCss="input-file ime-disabled input-error" />
<%-- // TODO ツールで変換できません 未サポート属性：list="#fileList_${s.index}"  max="2"  --%>
<n:file  id="input"  name="uploadFilesList" accept="txt|csv|xls"   size="30"  cssClass="input-file ime-disabled" errorCss="input-file ime-disabled input-error" />

 </n:form>
</body>
</html>