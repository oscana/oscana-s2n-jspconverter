<!DOCTYPE html>
<html>
<head>
<title>tag test</title>
</head>
<body>
   <logic:equal name="bean" property="booleanProperty" value="<%= bool1 %>">equal</logic:equal>
   <logic:equal name="bean" property="booleanProperty" value="2">equal</logic:equal>
   <nested:equal property="xxx" value="xxx">
      case1
   </nested:equal>
</body>
</html>