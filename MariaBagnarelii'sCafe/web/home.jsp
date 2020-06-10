<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en-US" class="">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link href="css/style_1.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style type="text/css">
            .fancybox-margin{
                margin-right:17px;
            }
            .body{
               background-image:url(../img/blur-redblack.jpg) !important;
            }
        </style>
    
    </head>
    <body data-pid="118937146" data-iid="" background="img/blur-redblack.jpg">
        <div class="container-fluid site-wrapper"> <!-- this is the Sheet -->
            <div class="container-fluid header-wrapper " id="header"> <!-- this is the Header Wrapper -->
                <div class="container">
                    <div class="title-wrapper">
                        <div class="title-wrapper-inner">
                            <a rel="nofollow" class="logo " href="http://www.simplesite.com/us-123cafe/">

                            </a>
                            <div class="title">
                                Maria Bagnarelli's Cafe
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
                                <a rel="nofollow" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse" title="Toggle menu">
                                    <span class="menu-name">Menu</span>
                                    <span class="menu-bars">
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                    </span>
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
                                <div class="content">
                                    <div class="section article">
                                        
                                        
                                        <c:forEach items="${listIntro}" var="intro"> 
                                      
                                            <div class="content">
                                                <div class="img-simple span3 pull-left">
                                                    <div class="image">
                                                        <a rel="nofollow" data-ss="imagemodal" data-href=""><img src="img/${intro.imgLink}"></a>
                                                    </div>
                                                </div>
                                                <p><span style="font-family: georgia, palatino; font-size: 24px;">
                                                        <span style="font-family: georgia, palatino;">${intro.title}</span></span>
                                                </p> 
                                                <p>${intro.content}</p>   
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <div class="section">
                                        <div class="content">
                                            <ul class="thumbnails column-article-section">
                                               <%-- <c:forEach items="${listCakeTop2}" var="cake"> --%>
                                               <c:forEach items="${listCake}" var="cake">
                                                    <li class="span6">
                                                        <div class="img-simple span12 ">
                                                            <div class="image">
                                                                <a rel="nofollow" data-ss="imagemodal" ><img src="img/${cake.imgLink}"></a>
                                                            </div>
                                                        </div>

                                                        <h4>
                                                            <a href="./CakeDetailController?cakeId=${cake.id}">${cake.name}</a></h4>

                                                        <p>${cake.shortContent}</p>
                                                    </li>
                                                </c:forEach>

                                            </ul>
                                        </div>
                                    </div>
                                    <div class="section article">
                                        <c:forEach items="${listContact}" var="contact">
                                            <c:if test="${contact.isOnHomePage == true}">
                                                <div class="content">
                                                    <p><span style="font-family: times new roman; font-size: 24px;">Visit my cafe</span></p>
                                                    <p>${contact.name}</p> 
                                                    <p>${contact.address}</p>
                                                    <p>Phone: ${contact.tel}</p>
                                                </div>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                    <div class="section signature">
                                        <div class="content">

                                            <div class="signature-text-noimg">
                                                <p>Kind regards</p>
                                                <div class="signature-sign" style="font-family: Dancing Script;serif;">
                                                    Maria Bagnarelli
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                            </div>
                        </div>
                        <div id="right" class="span3">
                            <div class="sidebar">
                                <div class="wrapper share-box">
                                    <div class="heading">
                                        <h4>Share this page</h4>
                                    </div>

                                    <div class="content"><span> <ul>
                                                <li><a id="share-facebook" href="http://us-123sushi.simplesite.com/#"><i
                                                            class="icon-facebook-sign fa fa-facebook"></i><span>Share on
                                                            Facebook</span></a></li>
                                                <li><a id="share-twitter" href="http://us-123sushi.simplesite.com/#"><i
                                                            class="icon-twitter-sign fa fa-twitter"></i><span>Share on Twitter</span></a>
                                                </li>
                                                <li><a id="share-google-plus" href="http://us-123sushi.simplesite.com/#"><i
                                                            class="icon-google-plus-sign fa fa-google"></i><span>Share on
                                                            Google+</span></a></li>
                                            </ul></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>        
                </div>
            </div>  <!-- the controller has determined which view to be shown in the content -->

            <div class="container-fluid footer-wrapper" id="footer"> <!-- this is the Footer Wrapper -->
                <div class="container">
                    <div class="footer-info">
                        <div class="footer-powered-by">
                            <a rel="nofollow" href="http://www.simplesite.com/">Created with SimpleSite</a>
                        </div>
                    </div>
                    <div class="footer-page-counter" style="display: block;">
                        <span class="footer-page-counter-item">0</span>

                        <span class="footer-page-counter-item">2</span>

                        <span class="footer-page-counter-item">2</span>

                        <span class="footer-page-counter-item">9</span>

                        <span class="footer-page-counter-item">7</span>

                        <span class="footer-page-counter-item">5</span>
                    </div>
                    <div id="css_simplesite_com_fallback" class="hide"></div>
                </div>
            </div>  <!-- this is the Footer content -->
        </div>


        <input type="hidden" id="anti-forgery-token" value="vFZIp11QDd7w1cZjYdzwVVw3rTHgQi1lpMMqomvLq/qGfx85dADIn6rd+jb5+yvdIjnIKNejlFu6vxL7J8Np5XDrvUyMasUYb8PZlmgROpWgWhFTGjCoyYPRNAZ57HUVr4c6QnvYhoYJLJG8dWLP2NhmdVJF+RhKEwkT1Q7ogGGTSddnANm69E10QsexY3DV5L0XqDr1VHHaGc7ZSxM2ktc82EJ4KYkwEXssuv2a0gNK9Zc8XKu5Ft28qiKVqNsj3YTpteTqb5UM9+U6Dtk4R+nJWQ1rw7NgjMDh9hCABmCHxgiQJBhPooojs3CleKjorvDjhc1vLhNfhEdOaEJSAXy1zHip7yoxj/Ybn86swSis7wnW/YTVdMos5ci15FQjUaRrceo96E4ZmaEsI4j7d2dJviNnjw9VnDDLYCThHK9Dva50cRw9n1Fu3di4AKXlxn8Tq15ySYRRdKFjrnxozw==">




        <div id="sm2-container" class="movieContainer high_performance" style="z-index: 10000; position: fixed; width: 8px; height: 8px; bottom: 0px; left: 0px; overflow: hidden; visibility: hidden;"><embed name="sm2movie" id="sm2movie" src="/Images/sm297/soundmanager2_flash9.swf" quality="high" allowscriptaccess="always" bgcolor="#ffffff" pluginspage="www.macromedia.com/go/getflashplayer" title="JS/Flash audio component (SoundManager 2)" type="application/x-shockwave-flash" wmode="transparent" haspriority="true"></div></body></html>