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
<title>Run Previously uploaded MR</title>
</head>
<body>
    <jsp:include page="_menu.jsp"/>
     
    <h3>Run MR:</h3>
 
    <!-- UploadForm -->
    <form:form method="POST">
        <input type="submit" value="Execute MR">
    </form:form>
        
        
     
</body>
 
</html>