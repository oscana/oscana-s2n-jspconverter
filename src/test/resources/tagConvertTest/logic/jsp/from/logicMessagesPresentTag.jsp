<!DOCTYPE html>
<html>
<head>
<title>tag test</title>
</head>
<body>
    <logic:messagesPresent message="true">
      <html:messages message="true" id="msg">
          <p><strong><bean:write name="msg" /></strong></p>
      </html:messages>
    </logic:messagesPresent>
    <logic:messagesPresent name="name" message="true">
      <html:messages message="true" id="msg">
          <p><strong><bean:write name="msg" /></strong></p>
      </html:messages>
    </logic:messagesPresent>
    <logic:messagesPresent property="property" message="true">
      <html:messages message="true" id="msg">
          <p><strong><bean:write name="msg" /></strong></p>
      </html:messages>
    </logic:messagesPresent>
    <logic:messagesPresent name="name" property="property" message="true">
      <html:messages message="true" id="msg">
          <p><strong><bean:write name="msg" /></strong></p>
      </html:messages>
    </logic:messagesPresent>
</body>
</html>