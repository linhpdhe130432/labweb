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
        <link rel="stylesheet" type="text/css" href="./css/search.css">
        <link rel="stylesheet" type="text/css" href="./css/styleForAll.css">
    </head>
    <body>
        <div class="wrap">
            <%@ include file="header.jsp" %> 
            <div class="wrap-container">
                <div class="container">
                    <c:if test="${empty listSearch}">
                        <div class="content">
                            <h3>Not found any result or keyword invalid</h3>
                        </div>    
                    </c:if>
                    <c:if test="${not empty listSearch}">
                        <div class="content">
                            <c:forEach var="s" items="${listSearch}">
                                <div class="search-result">
                                    <div class="title"><a href="detail?id=${s.id}">${s.title}</a></div>
                                    <div class="content-search new-content">
                                        <img src="${s.imageDes}">
                                        ${s.shortDes}
                                    </div>
                                </div>
                            </c:forEach>
                            <div>
                                <ul class="pagination">

                                    <c:forEach var="i" begin="1" end="${total}" step="1">
                                        <li><a id="${i}-page" href="?keyword=${keyword}&pageNumber=${i}">${i}</a></li>
                                        </c:forEach>

                                </ul>
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
<script src="./js/search.js"></script>
</html>
