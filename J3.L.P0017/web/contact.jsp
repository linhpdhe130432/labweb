<%-- 
    Document   : home
    Created on : Feb 19, 2020, 1:01:17 AM
    Author     : DuongDT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact us</title>
        <link rel="stylesheet" href="./css/contact.css" />
        <link rel="stylesheet" href="./css/styleForAll.css" />
    </head>
    <body>
    <%@ include file="header.jsp" %>
    <div class="container">
        <div class="content">
            <div class="main-content">
                <h1>Contact</h1>
                <div>
                    <div class="photographer-name">
                        ${contact.namePhotographer}
                    </div>
                    
                    
                    <div class="address">
                        <table>
                        <tr>
                            <td>Address:</td>
                            <td class="info-colum">${contact.address}</td>
                        </tr>
                        <tr>
                            <td>City:</td>
                            <td class="info-colum">${contact.city}</td>
                        </tr>
                        <tr>
                            <td>Country:</td>
                            <td class="info-colum">${contact.country}</td>
                        </tr>
                        </table>
                    </div>
                    <div class="tel-mail">
                        <table>
                           <tr>
                            <td>Tel:</td>
                            <td class="info-colum">${contact.phone}</td>
                        </tr>
                        <tr>
                            <td>Email:</td>
                            <td class="info-colum">${contact.email}</td>
                        </tr> 
                        
                        </table> 
                    </div>
                        
                        <div class="map">
                                
                        </div>    
                    
                </div>
            </div>
    <%@ include file="adver.html" %>
        </div>
    </div>
    <%@ include file="footer.jsp" %>
    </body>
</html>
