<!DOCTYPE html>
<html>
<head>
<title>tag test</title>
</head>
<body>
      <logic:iterate id="element" name="bean" property="stringArray" indexId="index" offset="1" length="3">
        <li>
         <bean:write name="element" />
        </li>
      </logic:iterate>

     <logic:iterate id="element" property="stringArray" >
        <li>
         <bean:write name="element" />
        </li>
      </logic:iterate>

     <logic:iterate id="element" collection="stringArray" >
        <li>
         <bean:write name="element" />
        </li>
      </logic:iterate>
</body>
</html>