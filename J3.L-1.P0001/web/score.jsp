<%-- 
    Document   : login
    Created on : Mar 9, 2020, 10:32:47 PM
    Author     : DuongDT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="./css/styleForAll.css" />
        <link rel="stylesheet" href="./css/score.css" />
    </head>
    <body>
        <div class="ground">
            <div class="border-bar"></div>
            <div class="block">
                <%@ include file="header.jsp" %>    
                <div class="container">
                    <div class="score-number">
                    <div class="green-label">
                        Your score
                    </div>
                    <c:if test="${pass}">
                        <div class="score blue-label">
                            ${score}
                        </div>
                    </c:if>
                    <c:if test="${not pass}">
                        <div class="score error-noti">
                            ${score}
                        </div>
                    </c:if>     
                    
                </div>
                <div class="retake">
                    Take another test
                    <a href="take?number=${total}"><button class="retake-btn">Start</button></a>
                </div>
                </div>
            </div>
        </div>
    </body>

</html>
