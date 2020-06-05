<%-- 
    Document   : header
    Created on : Feb 19, 2020, 12:48:25 AM
    Author     : DuongDT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./css/header.css" />
    </head>
    <body onload="setBold()">
    <div>
        <div class="navi">
            <div class="navi-bar">
                <a id="home"  class="navi-text" href="home"><div class="navi-item">My front page</div></a>
                <c:forEach var="gi" items="${galleryInHeader}">
                    <a id="gallery${gi.galleryCode}" class="navi-text" href="gallery?id=${gi.galleryCode}&pageNumber=1"><div class="navi-item">${gi.nameGallery}</div></a>
                </c:forEach>
                <a id="contact" class="navi-text" href="contact"><div class="navi-item">Contact</div></a>
            </div>
        </div>
        <div class="title-header">
            <div class="title-content">
                    <div class="title-logo">
                            
                    </div>
                    <div class="title-web">
                        <div class="name-web">
                            <a>PHOTOGRAPHER</a>
                        </div>
                        <div>
                            Welcome to this website
                        </div>
                    </div>
            </div>
            
        </div>
    </div>
    </body>
    <script src="./js/activePage.js"></script>
</html>
