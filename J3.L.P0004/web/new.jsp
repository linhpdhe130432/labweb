<%-- 
    Document   : new
    Created on : Mar 31, 2020, 1:20:02 AM
    Author     : DuongDT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="./css/new.css">
        <link rel="stylesheet" type="text/css" href="./css/styleForAll.css">
    </head>
    <body>
        <div class="wrap">
            <%@ include file="header.jsp" %> 
            <div class="wrap-container">
                <div class="container">
                    <c:if test="${empty article}">
                        <div class="content">
                            <h3>The article you wan't does not exist </h3>
                        </div>
                        
                    </c:if>
                    <c:if test="${not empty article}">
                        <div class="content">
                            <div class="new">
                                <div class="title">
                                    ${article.title}
                                </div>
                                <div class="image">
                                    <img src="${article.imageDes}">
                                </div>
                                <div>
                                    <p class="new-content">
                                        ${article.content}
                                    </p>
                                </div>
                            </div>
                            <div class="author">
                                <div class="logo cmt"></div>
                                <div class="logo time"></div>
                                <div class="new-content author-label">By ${article.author} | ${article.createdAt}</div>
                            </div>
                        </div>
                    </c:if>    

                    <%@ include file="slide.jsp" %> 
                </div>
            </div>
            <div class="footer">

            </div>
        </div>
    </div>

</body>
</html>
