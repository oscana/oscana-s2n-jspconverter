<!DOCTYPE html>
<html>
<head>
<title>tag test</title>
</head>
<body>
  <html:form action="/html-cancel-false">

            <html:select property="multipleSelect" size="10" multiple="true">
              <html:options name="multipleValues" labelName="multipleValues" />
            </html:select>

           <html:select property="multipleSelect" size="10" multiple="true">
              <html:options labelName="multipleValues" />
            </html:select>

             <html:select property="multipleSelect" size="10" multiple="true">
              <html:options name="multipleValues" labelName="multipleValues"  collection="collect" />
            </html:select>

             <html:select property="multipleSelect" size="10" multiple="true">
              <html:options labelName="multipleValues" collection="collect" />
            </html:select>

     <html:submit property="submit"/>
  </html:form>
</body>
</html>