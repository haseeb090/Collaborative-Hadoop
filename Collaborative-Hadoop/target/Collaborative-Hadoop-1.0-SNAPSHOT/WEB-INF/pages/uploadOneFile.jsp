<%-- 
    Document   : uploadOneFile
    Created on : Feb 19, 2017, 9:54:55 PM
    Author     : Haseeb Khizar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload One File</title>
</head>
<body>
    <jsp:include page="_menu.jsp"/>
     
    <h3>Upload Single File:</h3>
 
    <!-- UploadForm -->
    <form:form modelAttribute="UploadForm" method="POST"
                        action="" enctype="multipart/form-data">
 
        Description:
        <br>
        <form:input path="description" style="width:300px;"/>                
        <br/><br/>  
             
        File to upload: <form:input path="FileData" type="file"/><br />  
         
           
        <input type="submit" value="Upload">
         
    </form:form>
        
        
     
</body>
 
</html>