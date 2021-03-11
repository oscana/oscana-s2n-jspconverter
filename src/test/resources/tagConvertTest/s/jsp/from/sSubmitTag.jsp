<!DOCTYPE html>
<html>
<head>
<title>tag test</title>
</head>
<body>
  <s:form enctype="multipart/form-data">
      <s:submit property="submit" clientValidate="true">tag test</s:submit>

      <!-- test -->
      <s:submit property="submit">
        <bean:message key="test" />
      </s:submit>
      <s:submit property="submit">
        <bean:message messageId="test" />
      </s:submit>
      <s:submit property="submit">　</s:submit>
  </s:form>
</body>
</html>