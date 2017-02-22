<%-- 
    Document   : uploadMultiFile
    Created on : Feb 19, 2017, 9:54:44 PM
    Author     : Haseeb Khizar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload Multi File</title>
</head>
<body>
   <jsp:include page="_menu.jsp"/>
    
   <h3>Upload Multiple Files:</h3>
    
    <!-- UploadForm -->
    <form:form modelAttribute="UploadForm" method="POST"
                        action="" enctype="multipart/form-data">
         
        Description:
        <br>
        <form:input path="description" style="width:300px;"/>                
        <br/><br/>                 
     
        File to upload (1): <form:input path="FileData" type="file"/><br />      
        File to upload (2): <form:input path="FileData" type="file"/><br />    
        File to upload (3): <form:input path="FileData" type="file"/><br />    
        File to upload (4): <form:input path="FileData" type="file"/><br />    
        File to upload (5): <form:input path="FileData" type="file"/><br />    
         
        <input type="submit" value="Upload">
          
    </form:form>
     
     
</body>
</html>