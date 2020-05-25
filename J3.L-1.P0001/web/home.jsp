<%-- 
    Document   : home
    Created on : Mar 18, 2020, 11:14:55 AM
    Author     : DuongDT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./css/styleForAll.css" />
    </head>
    <body>
        <div class="ground">
            <div class="border-bar"></div>
            <div class="block">
                <%@ include file="header.jsp" %>    
                <div class="container">
                    <c:if test="${not empty sessionScope.user}">
                        Hello ${sessionScope.user.userName}
                    </c:if>
                    <c:if test="${empty sessionScope.user}">
                        <a href="login" class="green-label">Please Log in before use our function</a> 
                    </c:if>

                </div>
            </div>
        </div>

    </body>
</html>
