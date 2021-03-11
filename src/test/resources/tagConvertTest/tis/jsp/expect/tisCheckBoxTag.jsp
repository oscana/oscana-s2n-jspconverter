
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
   <n:checkbox name="check001_012" label="item" id="chk_sid" value="on"  />
<%-- // TODO ツールで変換できません 未サポート属性：errorStyleId="chk_esid"  --%>
   <n:checkbox name="check001_012" value="on" label="item" id="chk_sid"  />
<%-- // TODO ツールで変換できません 未サポート属性：errorStyleId="chk_esid"  --%>
   <n:checkboxes listName="check001_012" label="item"   />
<%-- // TODO ツールで変換できません 未サポート属性：errorStyleId="chk_esid"  --%>
   <n:codeCheckboxes codeId="check001_012" label="item"  listFormat="sp"  />
<%-- // TODO ツールで変換できません 未サポート属性：errorStyleId="chk_esid"  --%>
   <n:checkboxes listName="check001_012" label="item"  elementValueProperty="true" elementLabelProperty="label"  />
<%-- // TODO ツールで変換できません 未サポート属性：errorStyleId="chk_esid"  --%>
   <n:checkboxes listName="check001_012" label="item"  elementValueProperty="true" elementLabelProperty="label"  >
<%-- // TODO ツールで変換できません 未サポート属性：styleId="lbl_sid"  --%>
     <n:write name="label001_011"  />
   <n:checkbox value="on"/>
   </n:form>
</body>
</html>
