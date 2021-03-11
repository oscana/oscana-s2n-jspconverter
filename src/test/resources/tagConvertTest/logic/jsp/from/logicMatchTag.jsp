<!DOCTYPE html>
<html>
<head>
<title>tag test</title>
</head>
<body>
   <logic:match cookie="JSESSIONID" location="end" value="0">match</logic:match>
   <logic:match cookie="JSESSIONID" value="0">match</logic:match>
   <logic:match cookie="JSESSIONID" location="start" value="0">match</logic:match>
   <logic:match cookie="JSESSIONID" location="sxs" value="0">match</logic:match>
   <logic:match header="User-Agent" value="Mozilla">match</logic:match>
   <logic:match parameter="param1" value="value1">match</logic:match>
   <logic:match parameter="param1" name="<%=name%>" value="value1">match</logic:match>
   <logic:match parameter="param1" value="">match</logic:match>
   <logic:match parameter="param1" value="<%=value%>">match</logic:match>
</body>
</html>