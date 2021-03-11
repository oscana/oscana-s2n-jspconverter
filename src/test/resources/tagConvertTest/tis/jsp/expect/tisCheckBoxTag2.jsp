
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
<%-- // TODO ツールで変換できません 未サポート属性：errorStyleId="chk_esid"  --%>
<c:set var="labelstr">
<%-- // TODO ツールで変換できません 未サポート属性：errorStyleId="chk_esid"  --%>
<c:set var="labelstr">
<%-- // TODO ツールで変換できません 未サポート属性：errorStyleId="chk_esid"  --%>
<c:set var="labelstr">
<%-- // TODO ツールで変換できません 未サポート属性：errorStyleId="chk_esid"  --%>
<c:set var="labelstr">
<%-- // TODO ツールで変換できません 未サポート属性：errorStyleId="chk_esid"  --%>
<c:set var="labelstr">

   <%-- // TODO ツールで変換できません 未サポート属性：errorStyleId="chk_esid"  --%>
<n:checkboxes listName="check001_012" label="item"  elementValueProperty="true" elementLabelProperty="label"  >
<%-- // TODO ツールで変換できません 未サポート属性：styleId="lbl_sid"  --%>
      <n:write name="label001_011"  />
</c:set>   <n:checkbox name="check001_012" label="item" id="chk_sid" label="${labelstr}" value="on"  /></c:set>   <n:checkbox name="check001_012" value="on" label="item" id="chk_sid" label="${labelstr}"  /></c:set>   <n:checkboxes listName="check001_012" label="item"  label="${labelstr}"  /></c:set>   <n:codeCheckboxes codeId="check001_012" label="item"  label="${labelstr}" listFormat="sp"  /></c:set>   <n:checkboxes listName="check001_012" label="item"  elementValueProperty="true" elementLabelProperty="label" label="${labelstr}"  />   </n:checkbox value="on">
   </n:form>
</body>
</html>
