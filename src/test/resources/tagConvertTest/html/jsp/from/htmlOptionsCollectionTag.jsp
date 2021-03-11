<!DOCTYPE html>
<html>
<head>
<title>tag test</title>
</head>
<body>
  <html:form action="/html-cancel-false">

<html:select property="beanCollectionSelect" size="10" multiple="true">
   <html:optionsCollection name="testbean" property="beanCollection" />
</html:select>

     <html:submit property="submit"/>
  </html:form>
</body>
</html>