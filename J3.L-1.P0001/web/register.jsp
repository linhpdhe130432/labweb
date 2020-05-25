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
                <h5>Registration Form</h5>
                <div class="login-form">
                    <p class="error-noti" id="noti">${error}</p>
                    <form action="register" method="POST" onSubmit="return validateRegisterForm()">
                        <table>
                            <tr>
                                <td class="green-label">User Name: </td>
                                <td><input type="text" name="username" id="username" value="${username}"></td>
                            </tr>
                            <tr>
                                <td class="green-label">Password: </td>
                                <td><input type="password" name="password" id="password"></td>
                            </tr>
                            <tr>
                                <td class="green-label">User Type: </td>
                                <td>
                                    <select name="role">
                                        
                                        <c:if test="${isStudent}">
                                            <option value="teacher">Teacher</option>
                                            <option value="student" selected="true">Student</option>
                                        </c:if>
                                        <c:if test="${not isStudent}">
                                            <option value="teacher" selected="true">Teacher</option>
                                            <option value="student">Student</option>
                                        </c:if>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                    <td class="green-label">Email: </td>
                                    <td><input type="text" name="email" id="email" value="${email}"></td>
                                </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Register"></td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="./js/register.js" ></script>
</html>
