<!DOCTYPE html>
<html>
<head>
<title>tag test</title>
</head>
<body>
   <s:form enctype="multipart/form-data">

<tis:fileUpload property="uploadFiles" accept="txt|csv|xls" list="#fileList_${s.index}" name="uploadFilesList" max="2" size="30" indexed="true" styleClass="input-file ime-disabled" errorStyleClass="input-file ime-disabled input-error" />
<tis:fileUpload property="uploadFiles" accept="txt|csv|xls" list="#fileList_${s.index}" max="2" size="30" indexed="true" styleClass="input-file ime-disabled" errorStyleClass="input-file ime-disabled input-error" />
<tis:fileUpload  styleId="input"  name="uploadFilesList" accept="txt|csv|xls" list="#fileList_${s.index}" max="2" size="30" indexed="true" styleClass="input-file ime-disabled" errorStyleClass="input-file ime-disabled input-error" />

 </s:form>
</body>
</html>