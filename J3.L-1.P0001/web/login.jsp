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
        <link rel="stylesheet" href="./css/login.css" />
    </head>
    <body>
            <div class="ground">
                <div class="border-bar"></div>
            <div class="block">
            <%@ include file="header.jsp" %>    
            <div class="container">
                <h5>Login Form</h5>
                <div class="login-form">
                    <p class="error-noti" id="noti">${error}</p>
                    <form action="login" method="POST" onSubmit="return validateLoginForm()">
                        <table>
                            <tr>
                                <td class="green-label">User Name: </td>
                                <td><input type="text" name="username" id="username" value="${username}"></td>
                            </tr>
                            <tr>
                                <td class="green-label">Password: </td>
                                <td><input type="password" id="password" name="password"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Sign in"><a href="register" class="green-label">Register</a></td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="./js/login.js" ></script>
</html>
