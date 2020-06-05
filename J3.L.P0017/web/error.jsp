<%-- 
    Document   : home
    Created on : Feb 19, 2020, 1:01:17 AM
    Author     : DuongDT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>404</title>
        <link rel="stylesheet" href="./css/error.css" />
        <link rel="stylesheet" href="./css/styleForAll.css" />
    </head>
    <body>
    <%@ include file="header.jsp" %>
    <div class="container">
        <div class="content">
            <div class="main-content">
                <h2>This page isn't available</h2> 
                <p>The link you followed may be broken, or the page may have been removed.</p>
                <a href="home">Go back to home page</a>
            </div>
    <%@ include file="adver.html" %>
        </div>
    </div>
    <%@ include file="footer.jsp" %>
    </body>
    <script src="./js/gallery.js"></script>
</html>
