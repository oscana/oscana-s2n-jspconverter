<!DOCTYPE html>
<html>
<head>
<title>tag test</title>
</head>
<body>
  <html:form action="/html-cancel-false">

<logic:iterate id="element" name="bean" property="stringArray" indexId="index" offset="1" length="3">
              <html:radio property="overallSatisfaction" value="<%=satBean.getValue()%>">
                <%=satBean.getLabel()%>
              </html:radio>
</logic:iterate>


<html:radio property="overallSatisfaction" value="<%=satBean.getValue()%>" />

     <html:submit property="submit"/>
  </html:form>
</body>
</html>