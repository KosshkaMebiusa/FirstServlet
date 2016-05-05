<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Machine Learning in Weather Forecasting</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
    <link rel="shortcut icon" href="css/images/icon.png"/>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all"/>
    <!--[if IE 6]>
    <link rel="stylesheet" href="css/ie6.css" type="text/css" media="all"/>
    <script src="js/png-fix.js" type="text/javascript"></script>
    <![endif]-->
    <script src="js/jquery-1.4.2.js" type="text/javascript"></script>
    <script src="js/jquery.jcarousel.js" type="text/javascript"></script>
    <script src="js/js-func.js" type="text/javascript"></script>
</head>
<body>
<!-- Header -->
<div id="header">
    <div class="shell">
        <h1 id="logo" class="notext"><a href="">Machine Learning - Weather Forecasting</a></h1>

        <div id="navigation">
            <ul>
                <li><a href="">Home</a></li>
                <li><a href="">DataBase</a></li>
                <li><a href="#">Services</a>

                    <div class="dd-holder">
                        <div class="dd-t"></div>
                        <div class="dd">
                            <ul>
                                <li><a href="#">Sub Level 1</a></li>
                                <li><a href="#">Sub Level 1</a></li>
                                <li><a href="#">Sub Level 1</a></li>
                                <li><a href="#">Sub Level 1</a></li>
                            </ul>
                        </div>
                        <div class="dd-b"></div>
                    </div>
                </li>
                <li><a href="" class="active">Test LA</a></li>
                <li><a href="signin.jsp">SignIn</a></li>
                <li><a href="signup.jsp">SignUp</a></li>
            </ul>
        </div>
    </div>
</div>
<!-- End Header -->

</div>
<!-- End Slider -->
<!-- Main -->
<div id="main">
    <div class="shell">
        <div id="sidebar">
            <div class="text-container" style="color: black">
                <h2>Current weather</h2>
                <center>
                    <br>
                    <script language="JavaScript" type="text/javascript">
                        document.write('<script language="JavaScript" src="http://www.worldweatheronline.com/widget/v4/weather-widget.ashx?q=Saint+Petersburg%2c+Russia&width=220&custom_header=Saint Petersburg, Russia&num_of_day=0&title_bg_color=020202&title_text_color=FFFFFF&widget_bg_color=FFFFFF&widget_text_color=020202&type=js&ak=s%2baUvsrgZuXf5iFdUGFfLu8RkGcbaXDNRmRXYzVS7vtFYpQDPVCxCZtRmhZnKk0GK8CI7efLNmIOCr5A5SyEQ3bdLsaRovSozsv2yf0UJmI%3d&cb=' + Math.random() + '" type="text/javascript"><\/scr' + 'ipt>');
                    </script>
                    <noscript><a href="http://www.worldweatheronline.com" alt="7 day Saint Petersburg, Russia weather">7
                        day Saint Petersburg, Russia weather</a> provided by <a
                            href="http://www.worldweatheronline.com">World Weather Online</a></noscript>
                </center>
            </div>
            <div class="post">
                <h2>Chosse DataBase to start</h2>
                <FORM name="form2" class="my_form" action="chooseDB" method="post">
                    <INPUT type="submit" value="Choose Database"/>

                </FORM>
            </div>
        </div>
        <div id="content">
            <div class="col">
                <div class="post">


                    <form class="my_form" action="test" method="get" name="test_form">
                        <h2>Please, choose algorithm and parametrs</h2>
                        <ul>
                            <li>
                                <select name="testitem">
                                    <option value="1"> Temperature</option>
                                    <option value="2"> Pressure</option>
                                    <option value="3"> Humidity</option>
                                    <option value="4"> Wind Speed</option>
                                    <option value="4"> Wind Direction</option>
                                    <option value="6"> Weather Condition</option>
                                </select>

                            </li>
                            <li>
                                <select name="algorithm">
                                    <optgroup label="Metric">
                                        <option value="kNN"> KNearestNeighbor</option>
                                        <option value="KDtreeKNN"> KDtreeKNN</option>
                                        <option value="MFV"> MeanFeatureVoting</option>
                                        <%--<option value="AbstrMean">AbstractMean</option> --%>
                                        <option value="NearestMean">NearestMean</option>
                                        <option value="ZeroR">ZeroR</option>
                                    </optgroup>
<%--                                    <optgroup label="Tree">
                                        <option value="RandTree"> RandomTree</option>
                                    </optgroup>--%>
                                    
                                </select>

                            </li>
                            <li>
                                <INPUT type="submit" value="Test!"/>
                            </li>

                        </ul>
                    </form>

                    <form class="my_form" action="chooseLA" method="post" name="choose_form">
                        <h2>Please, choose item</h2>
                        <ul>
                            <select name="chooseitem">
                                <option value="1"> Temperature</option>
                                <option value="2"> Pressure</option>
                                <option value="3"> Humidity</option>
                                <option value="4"> Wind Speed</option>
                                <option value="4"> Wind Direction</option>
                                <option value="6"> Weather Condition</option>
                            </select>
                            <li>
                                <INPUT type="submit" value="Choose best algorithm"/>
                            </li>
                        </ul>
                    </form>

                    <div class="cl">&nbsp;</div>
                </div>
            </div>
        </div>
        <div class="cl">&nbsp;</div>
    </div>
</div>
<!-- End Main -->
<!-- Footer -->
<div id="footer">
    <div class="shell">
        <p class="right">
            Copyright &copy; PlainPlan 2010 | Valid CSS &amp; HTML | Design by <a href="http://chocotemplates.com"
                                                                                  target="_blank"
                                                                                  title="The Sweetest CSS Templates WorldWide">Chocotemplates.com</a>
        </p>
    </div>
</div>
<!-- End Footer -->
</body>
</html>