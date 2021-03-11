<!DOCTYPE html>
<html>
<head>
<title>tag test</title>
</head>
<body>
     <logic:notMatch cookie="JSESSIONID" location="end" value="0">notMatch</logic:notMatch>
     <logic:notMatch cookie="JSESSIONID" value="0">notMatch</logic:notMatch>
     <logic:notMatch cookie="JSESSIONID" location="start" value="0">notMatch</logic:notMatch>
     <logic:notMatch cookie="JSESSIONID" location="xxx" value="0">notMatch</logic:notMatch>
</body>
</html>