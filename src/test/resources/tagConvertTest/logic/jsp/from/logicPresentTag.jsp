<!DOCTYPE html>
<html>
<head>
<title>tag test</title>
</head>
<body>
  <logic:present cookie="JSESSIONID">
            <logic:match cookie="JSESSIONID" location="end" value="0">match</logic:match>
            <logic:notMatch cookie="JSESSIONID" location="end" value="0">notMatch</logic:notMatch>
  </logic:present>

  <logic:present header="header">
            <logic:match cookie="JSESSIONID" location="end" value="0">match</logic:match>
            <logic:notMatch cookie="JSESSIONID" location="end" value="0">notMatch</logic:notMatch>
  </logic:present>
</body>
</html>