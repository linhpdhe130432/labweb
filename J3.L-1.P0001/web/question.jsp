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
        <link rel="stylesheet" href="./css/question.css" />
    </head>
    <body onload="countdown(${remain})">
        <div class="ground">
            <div class="border-bar"></div>
            <div class="block">
                <%@ include file="header.jsp" %>    
                <div class="container">
                    <div class="welcome">
                        <div class="green-label">
                            Welcome
                        </div>
                        <div class="user-name blue-label">
                            ${name}
                        </div>
                    </div>
                    <div class="timer">
                        <div>Time remaining </div>
                        <div id="time"></div>
                    </div>
                    <div class="test">
                        <div class="question">${content}</div>
                        <div class="option">
                            <form action="test?question=${number}" method="POST">
                                <c:forEach var="i" items="${options}" varStatus="loop">
                                    <div class="option-item">
                                        <input type="checkbox" 
                                               <%--check if index of option have in chosen list of user, checked this checkbox --%>

                                               <c:forEach var="z" items="${chosen}" >
                                                   <c:if test="${ loop.index+1 eq z}">
                                                       checked="true"
                                                   </c:if>
                                               </c:forEach>
                                               id="option${loop.index+1}" name="option${loop.index+1}" value="checked">
                                        <label for="option${loop.index+1}" class="label">${i}</label>
                                    </div>
                                </c:forEach>
                                <input type="submit" class="submit-btn" value="Next">
                            </form>
                        </div>
                    </div>
                    <c:if test="${isLastQuest}">
                        <a href="result" class="green-label" onclick="return confirm('Are you sure, you want to finish quiz now')">Finish now</a>           
                    </c:if>

                </div>
            </div>
        </div>
    </body>
    <script src="./js/question.js">
    </script>
</html>
