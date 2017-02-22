<%-- 
    Document   : uploadResult
    Created on : Feb 19, 2017, 9:55:04 PM
    Author     : Haseeb Khizar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     
<html>
<head>
<meta charset="UTF-8">
<title>Upload Result</title>
</head>
<body>
    <jsp:include page="_menu.jsp"/>
    
    <h3>Uploaded Files:</h3>
     
    Description: ${description}
     
    <br/>
     
    <c:forEach items="${uploadedFiles}" var="file">
           - ${file} <br>
    </c:forEach>
 
</body>
</html>
