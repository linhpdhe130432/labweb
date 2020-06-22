<%-- 
    Document   : slide
    Created on : Mar 31, 2020, 1:23:58 AM
    Author     : DuongDT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="./css/slide.css">
    </head>
    <body>
        <div class="slide-bar">
            <div>
                <div class="title">
                    Digital New
                </div>
                <div class="short-new">
                    <p class="new-content">
                        ${top[0].shortDes}
                    </p>
                </div>
            </div>
            <div class="search">
                <div class="title">
                    Search
                </div>
                <div>
                    <form action="search" class="search-form">
                        <input class="search-input" type="text" name="keyword" value="${keyword}" required="true">
                        <input class="btn-search" type="submit" value="Go">
                    </form>
                </div>
            </div>
            <div>
                <div class="title">
                    Last Article
                </div>
                <c:forEach var="s" items="${top}">
                    <div class="top5">
                        <a href="detail?id=${s.id}" class="new-content">
                            ${s.title}
                        </a>
                    </div>
                </c:forEach>

            </div>
        </div>
    </body>
</html>
