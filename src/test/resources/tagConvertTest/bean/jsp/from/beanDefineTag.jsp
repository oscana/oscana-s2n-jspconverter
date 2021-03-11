<!DOCTYPE html>
<html>
<head>
<title>tag test</title>
</head>
<body>
<s:form enctype="multipart/form-data">

  <bean:define id="test1_string" name="test1" property="stringProperty" />
  <bean:define id="test1_value" value="ABCDE" />
    <bean:define id="test1_value" name="<%=name%>" />

 <s:submit property="submit" clientValidate="true">test</s:submit>
</s:form>
</body>
</html>