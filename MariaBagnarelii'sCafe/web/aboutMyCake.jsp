<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en-US" class="objectfit object-fit">
    <head>

        <title>About my Cakes</title>
       
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
       
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/style_1.css" rel="stylesheet" type="text/css"/>
    
        <style>
            .body{
               background-image:url(../img/blur-redblack.jpg);
            }
        </style>
    </head>
    <body data-pid="118937148" data-iid="" style="line-height: normal;" class="stefan-asafti" cz-shortcut-listen="true">

        <div class="container-fluid site-wrapper">
            <!-- this is the Sheet -->
            <div class="container-fluid header-wrapper " id="header"> <!-- this is the Header Wrapper -->
                <div class="container">
                    <div class="title-wrapper">
                        <div class="title-wrapper-inner">
                            <a class="logo " href="http://www.simplesite.com/us-123cafe/">
                            </a>
                            <div class="title ">
                                <a class="title  title-link" href="http://www.simplesite.com/us-123cafe/">
                                    Maria Bagnarelli's Cafe
                                </a> 
                            </div>
                            <div class="subtitle">
                                Welcome to my website
                            </div>
                        </div>
                    </div>  <!-- these are the titles -->
                    <div class="navbar navbar-compact">
                        <div class="navbar-inner">
                            <div class="container">
                                <!-- .btn-navbar is used as the toggle for collapsed navbar content -->
                                <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse" title="Toggle menu">
                                    <span class="menu-name">Menu</span>
                                </a>



                                <!-- Everything you want hidden at 940px or less, place within here -->
                                <div class="nav-collapse collapse">
                                    <ul class="nav" id="topMenu" data-submenu="horizontal">
                                       <li class=" active " style="">
                                            <a rel="nofollow" href="./HomeController">Home</a>
                                        </li><li class="  " style="">
                                            <a rel="nofollow" href="./AboutMyCakeController">About my Cakes</a>
                                        </li><li class="  " style="">
                                            <a rel="nofollow" href="./ContactController">Find Maria's Cafe</a>
                                        </li>                </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- this is the Menu content -->
                </div>
            </div>  <!-- this is the Header content -->
            <div class="container-fluid content-wrapper" id="content"> <!-- this is the Content Wrapper -->
                <div class="container">
                    <div class="row-fluid content-inner">
                        <div id="left" class="span9"> <!-- ADD "span12" if no sidebar, or "span9" with sidebar -->
                            <div class="wrapper ">
                                <c:forEach items="${listCake}" var="cake">
                                <div class="content">
                                    <div class="row-fluid layout5-row  margins-topbottom padding-all ">
                                        <div class="sections-wrapper">
                                            <div class="span12 ">
                                                <div class="outer-margin-on first last">
                                                    <div class="section article margins-on">
                                                        <style>    .wordwrapfix {
                                                                word-wrap:break-word;
                                                            }
                                                        </style>
                                                        <div class="heading wordwrapfix">
                                                            <h3>${cake.name}</h3>
                                                        </div>

                                                        <div class="content">
                                                            <div class="img-simple span6 pull-right">
                                                                <div class="image">
                                                                    <a data-ss="imagemodal" rel="group" has-arrows="False"><img src="img/${cake.imgLink}"></a>
                                                                </div>
                                                            </div>
                                                            <p><span>${cake.fullContent}</span>
                                                            </p>
                                                              </div>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                </c:forEach>

                            </div>
                        </div>
                        <div id="right" class="span3  ">
                            <div class="sidebar">
                                <div class="wrapper share-box">
                                    <style>    .wordwrapfix {
                                            word-wrap:break-word;
                                        }
                                    </style>
                                    <div class="heading wordwrapfix">
                                        <h4>Share this page</h4>
                                    </div>

                                    <div class="content"><div>
                                            <ul>
                                                <li><a id="share-facebook" href="http://us-123sushi.simplesite.com/#"><i
                                                            class="icon-facebook-sign fa fa-facebook"></i><span>Share on
                                                            Facebook</span></a></li>
                                                <li><a id="share-twitter" href="http://us-123sushi.simplesite.com/#"><i
                                                            class="icon-twitter-sign fa fa-twitter"></i><span>Share on Twitter</span></a>
                                                </li>
                                                <li><a id="share-google-plus" href="http://us-123sushi.simplesite.com/#"><i
                                                            class="icon-google-plus-sign fa fa-google"></i><span>Share on
                                                            Google+</span></a></li>
                                            </ul>
                                        </div></div>
                                </div>
                            </div>
                        </div>
                    </div>        
                </div>
            </div>
            
            <div class="pagination" style="margin-left:30px;"> 
                <%for (int i = 1 ; i <= (int)request.getAttribute("pageCount"); i++){ %>
                                    <a href="./AboutMyCakeController?page=<%=i%>"><%=i%></a>
                <%}%>
            </div> 
            <!-- the controller has determined which view to be shown in the content -->
            <div class="container-fluid footer-wrapper" id="footer">
                <!-- this is the Footer Wrapper -->
                <div class="container">
                    <div class="footer-info">
                    </div>
                    <div class="footer-page-counter" style="display: block;">
                        <span class="footer-page-counter-item">0</span>

                        <span class="footer-page-counter-item">3</span>

                        <span class="footer-page-counter-item">7</span>

                        <span class="footer-page-counter-item">0</span>

                        <span class="footer-page-counter-item">9</span>

                        <span class="footer-page-counter-item">1</span>
                    </div>
                    <div id="css_simplesite_com_fallback" class="hide"></div>
                </div>
            </div>

            <!-- this is the Footer content -->
        </div>



        <div id="fb-root" class=" fb_reset"><div style="position: absolute; top: -10000px; width: 0px; height: 0px;"><div></div></div></div></body></html>