<!DOCTYPE html>
<html>
<head>
<title>tag test</title>
</head>
<body>
<s:form enctype="multipart/form-data">

   <bean:size id="stringSize" name="bean" property="stringArray" collection="collect"/>
   <bean:size id="stringSize" name="bean" property="stringArray" />

 <s:submit property="submit" clientValidate="true">test</s:submit>
</s:form>
</body>
</html>