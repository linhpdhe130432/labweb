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
        <title>View Gallery</title>
        <link rel="stylesheet" href="./css/gallery.css" />
        <link rel="stylesheet" href="./css/styleForAll.css" />
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <div class="container">
            <div class="content">
                <div class="main-content">
                    <c:if test="${empty gallery.nameGallery}">
                        <div class="noti">
                            <p>The data you requested does not exist</p>
                            <a href="home">Go back to home page</a>
                        </div>

                    </c:if> 

                    <c:if test="${not empty gallery.nameGallery}">


                        <c:if test="${not empty gallery}">
                            <h1>${gallery.nameGallery}</h1>

                            <c:if test="${empty gallery.imageList}">
                                <div>
                                    <p>This page don't have data</p>

                                </div>

                            </c:if>   
                            <c:if test="${not empty gallery.imageList}">
                                <div class="slide-show">
                                    <c:forEach var="i" items="${gallery.imageList}">
                                        <div class="image-slide hiden-image">
                                            <img src="${i}">

                                        </div>
                                    </c:forEach>

                                </div>
                            </c:if>  


                            <div class="detail-gallery">

                                <c:forEach var="i" items="${gallery.imageList}">
                                    <div class="wrap-card">
                                        <div class="shadow"></div>
                                        <div class="image-card">
                                            <img class="image-small" src="${i}">
                                        </div>
                                    </div>

                                </c:forEach>

                            </div>

                            <div>
                                <ul class="pagination">

                                    <c:forEach var="i" begin="1" end="${pageSize}" step="1">
                                        <li><a id="${i}-page" href="?id=${param.id}&pageNumber=${i}">${i}</a></li>
                                        </c:forEach>

                                </ul>
                            </div>                    
                        </c:if>
                    </c:if>    




                </div>
                <%@ include file="adver.html" %>
            </div>
        </div>
        <%@ include file="footer.jsp" %>
    </body>
    <script src="./js/gallery.js"></script>
    <script src="./js/activePagging.js"></script>
</html>
