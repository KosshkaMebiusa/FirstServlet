<%@ page import="java.util.*, java.text.*" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                <li><a href="" class="active">DataBase</a></li>
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
                <li><a href="">Test LA</a></li>
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
                    <h2>Hello, ${login}!</h2>
                    <center>
                        <FORM name="form1" class="my_form" action="download" method="post">
                            <br>
                            <INPUT type="submit" value="Download Historical Data from"/>
                            <br><br>
                            <select name="day">
                                <option value="01"> 1</option>
                                <option value="02"> 2</option>
                                <option value="03"> 3</option>
                                <option value="04"> 4</option>
                                <option value="05"> 5</option>
                                <option value="06"> 6</option>
                                <option value="07"> 7</option>
                                <option value="08"> 8</option>
                                <option value="09"> 9</option>
                                <option value="10"> 10</option>
                                <option value="11"> 11</option>
                                <option value="12"> 12</option>
                                <option value="13"> 13</option>
                                <option value="14"> 14</option>
                                <option value="15"> 15</option>
                                <option value="16"> 16</option>
                                <option value="17"> 17</option>
                                <option value="18"> 18</option>
                                <option value="19"> 19</option>
                                <option selected value="20"> 20</option>
                                <option value="21"> 21</option>
                                <option value="22"> 22</option>
                                <option value="23"> 23</option>
                                <option value="24"> 24</option>
                                <option value="25"> 25</option>
                                <option value="26"> 26</option>
                                <option value="27"> 27</option>
                                <option value="28"> 28</option>
                                <option value="29"> 29</option>
                                <option value="30"> 30</option>
                                <option value="31"> 31</option>
                            </select>
                            <select name="month">
                                <option value="01"> January</option>
                                <option value="02"> February</option>
                                <option value="03"> March</option>
                                <option selected value="04"> April</option>
                                <option value="05"> May</option>
                                <option value="06"> Juny</option>
                                <option value="07"> July</option>
                                <option value="08"> August</option>
                                <option value="09"> September</option>
                                <option value="10"> October</option>
                                <option value="11"> November</option>
                                <option value="12"> December</option>
                            </select>
                            <select name="year">
                                <option selected value="2016"> 2016</option>
                            </select>
                        </FORM>

                        <br>

                        <FORM name="form2" class="my_form" action="test" method="post">
                            <INPUT type="submit" value="Test LA"/>

                        </FORM>
                    </center>
                    <br>
                    <table border="1px" cellpadding="8px">
                        <tr>
                            <th>Date</th>
                            <th>Time</th>
                            <th>Weather Condition</th>
                            <th>Temperature</th>
                            <th>Pressure</th>
                            <th>Humidity</th>
                            <th>Wind Speed</th>
                            <th>Wind Direction</th>
                        </tr>
                        <c:forEach items="${weatherList}" var="item">
                            <tr>
                                <td>${item.date}</td>
                                <td>${item.time}</td>
                                <td>${item.weatherCondition}</td>
                                <td>${item.temperature}</td>
                                <td>${item.pressure}</td>
                                <td>${item.humidity}</td>
                                <td>${item.windSpeed}</td>
                                <td>${item.windDirection}</td>
                            </tr>
                        </c:forEach>
                    </table>


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
