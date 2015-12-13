<%@ page import="java.util.*, java.text.*" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page isELIgnored = "false" %>

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
                <li><a href="index.html">Home</a></li>
                <li><a href="/signin">DataBase</a></li>
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
                <li><a href="test">Test LA</a></li>
                <li><a href="signin.jsp">SignIn</a></li>
                <li><a href="signup.jsp" class="active">SignUp</a></li>
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
        </div>
        <div id="content">
            <div class="col">
                <div class="post">


                    <form class="my_form" action="signup" method="post" name="signup_form">
                        <h2>Unknown user. Please, sign up</h2>
                        <ul>
                            <li>
                                <label>Login:</label>
                                <input type="text" name="login" required/>
                            </li>
                            <li>
                                <label>Pasword:</label>
                                <input type="password" name="password" required/>
                            </li>
                            <li>
                                <label>City:</label>
                                <input type="text" name="city" required/>
                            </li>
                            <li>
                                <input type="submit" name="signin" value="Sign Up"/>
                            </li>
                        </ul>
                    </form>

                    <FORM name="form1" action="" method="POST">
                        <BR>
                    </FORM>

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
