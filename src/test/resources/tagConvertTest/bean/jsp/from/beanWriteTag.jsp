<!DOCTYPE html>
<html>
<head>
<title>tag test</title>
</head>
<body>
<s:form enctype="multipart/form-data">

   <bean:write name="test7.double" property="pty" format="#,000.00" formatKey="key1" />

    <bean:write name="test7.double" format="#,000.00" formatKey="key1" />

 <s:submit property="submit" clientValidate="true">test</s:submit>
</s:form>
</body>
</html>