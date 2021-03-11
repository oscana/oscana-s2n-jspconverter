<!DOCTYPE html>
<html>
<head>
<title>tag test</title>
</head>
<body>
  <html:form action="/html-cancel-false">

     <html:frame page="frame_1.jsp" />

     <html:frame page="frame_2.jsp" module="test" />

     <html:frame forward="frame_2.jsp" module="test" />

     <html:submit property="submit"/>
  </html:form>
</body>
</html>