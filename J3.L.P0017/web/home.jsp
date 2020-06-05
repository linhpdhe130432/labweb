<%-- 
    Document   : home
    Created on : Feb 19, 2020, 1:01:17 AM
    Author     : DuongDT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="./css/home.css" />
        <link rel="stylesheet" href="./css/styleForAll.css" />
    </head>
    <body onload="setBold()">
        <div id="menu" data-page="Menu"></div>    
        <%@ include file="header.jsp" %>
        <div class="container">
            <div class="content">
                <div class="main-content">
                    <div class="intro">
                        <img class="intro-image" src="${info.imgDes}">
                        <i>${info.sortDes}</i>
                    </div>
                    <div class="view-gallery">
                        <c:forEach var="g" items="${gallery}">
                            <div class="gallery-card">
                                <img class="image-card" src="${g.descriptionImage}"> 
                                <div class="content-card">
                                    <a href="gallery?id=${g.galleryCode}&pageNumber=1">View ${g.nameGallery}</a>
                                    <p>${g.description}</p>

                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div>
                        <ul class="pagination">

                            <c:forEach var="i" begin="1" end="${total}" step="1">
                                <li><a id="${i}-page" href="?pageNumber=${i}">${i}</a></li>
                                </c:forEach>

                        </ul>
                    </div>          
                    <div class="about-me">
                        <div class="about-title">
                            About me
                        </div>
                        <p>
                            ${info.aboutMe}
                        </p>
                    </div>
                </div>
                <%@ include file="adver.html" %>
            </div>
        </div>
        <%@ include file="footer.jsp" %>
    </body>
    <script src="./js/activePagging.js"></script>
</html>
