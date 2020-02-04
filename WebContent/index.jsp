<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>advbuilder running</title>
  </head>
  <body>
  
  
    <h1>Create Jar file</h1>
   <form method="post" action="JarBuilderServlet">
   <fieldset>
	<legend>output jar details:</legend>
	<div>
		<label for="jarLocation">
      <span class="visuallyhidden">buildPath </span>buildPath:
    </label><br>
		<input type="text" name="buildPath" id="buildPath">
	</div>
	<div>
		<label for="jarLocation">jarLocation:
    </label><br>
		<input type="text" name="jarLocation" id="jarLocation">
	</div>
  <div>
    <label for="manifestFileLocation">manifestFileLocation:</label><br>
    <input type="text" name="manifestFileLocation" id="manifestFileLocation">
  </div>
  <div>
    <label for="classFilesLocation">classFilesLocation:</label><br>
    <input type="text" name="classFilesLocation" id="classFilesLocation">
  </div>
  <div>
    <label for="outputFileName">outputFileName</label><br>
    <input type="text" name="outputFileName" id="outputFileName">
  </div>
  <div>
    <label for="status" id="jarCreationStatus" ><%=request.getAttribute("jarCreationStatus")%></label><br>
    
  </div>
  <input type="submit" name="Submit" value="CreateFile" onclick="fileCreationStatus();"/>
</fieldset>
</form>
  </body>
</html>