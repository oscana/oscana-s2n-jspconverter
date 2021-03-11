<!DOCTYPE html>
<html>
<head>
<title>tag test</title>
</head>
<body>
<s:form enctype="multipart/form-data">

    <bean:include id="welcome" page="/welcome.jsp" />
    <bean:include id="welcome" href="/welcome.jsp" anchor="anchor"/>
    <bean:include id="welcome" anchor="anchor"/>
 <s:submit property="submit" clientValidate="true">test</s:submit>
</s:form>
</body>
</html>