<!DOCTYPE html>
<html>
<head>
<title>tag test</title>
</head>
<body>
  <html:form action="/html-cancel-false">

<html:messages property="property1" message="true" id="msg" header="messages.header" footer="messages.footer">
            <tr>
              <td>
                <%= pageContext.getAttribute("msg") %>
              </td>
            </tr>
</html:messages>

     <html:submit property="submit"/>
  </html:form>
</body>
</html>