<!DOCTYPE html>
<html>
<head>
<title>tag test</title>
</head>
<body>
   <s:form enctype="multipart/form-data">

    <tis:messages id="msg" message="true">
       <li><bean:write name="${msg}" ignore="true"/></li>
    </tis:messages>
     <tis:messages name="msg" id="msg" message="true">
       <li><bean:write name="${msg}" ignore="true"/></li>
    </tis:messages>
    <tis:messages name="msg" id="msg" message="false">
       <li><bean:write name="${msg}" ignore="true"/></li>
    </tis:messages>
    <tis:messages name="msg" id="msg" >
       <li><bean:write name="${msg}" ignore="true"/></li>
    </tis:messages>
 </s:form>
</body>
</html>