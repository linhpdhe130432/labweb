<%-- 
    Document   : login
    Created on : Mar 9, 2020, 10:32:47 PM
    Author     : DuongDT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="./css/styleForAll.css" />
        <link rel="stylesheet" href="./css/takeQuiz.css" />
    </head>
    <body>
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
                        <div class="error-noti">
                        ${error}
                    </div>
                    <div class="input-form green-label">
                        Enter number of questions:
                        <div>
                            <form action="take" method="POST" class="form">
                                <input type="text" name="number" class="text">
                                <input type="submit" value="Start" class="submit">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script src="./js/makeQuiz.js" ></script>
</html>
