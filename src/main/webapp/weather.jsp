<%@ page import="java.util.*, java.text.*" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page isELIgnored = "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>
        Weather
    </title>
</head>

<body>

    <h1>Hello, ${login}!</h1>
    <br>
<%--    <h2>
        Now in ${city}: <br><br>
        OpenWeatherMap:<br>
        ${weatherConditionOWM}<br>
        ${temperatureOWM} degrees, ${pressureOWM} mb, humiduty ${humidityOWM}% <br>
        wind: speed ${windspeedOWM} m/s, direction: ${winddirectionOWM} degrees <br>
        <br> WorldWeatherOnline:<br>
        ${weatherConditionWWO}<br>
        ${temperatureWWO} degrees, ${pressureWWO} mb, humiduty ${humidityWWO}% <br>
        wind: speed ${windspeedWWO} m/s, direction: ${winddirectionWWO} degrees <br>
     </h2>--%>

    <FORM name="form1" action="download" method="post">
        <BR><BR>
        <INPUT type="submit" value="Download Historical Data"/>
        <BR><BR>
    </FORM>


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
             <c:forEach items="${weatherList}" var="weather" >
                <tr>
                    <td>${weather.date}</td>
                    <td>${weather.time}</td>
                    <td>${weather.weatherCondition}</td>
                    <td>${weather.temperature}</td>
                    <td>${weather.pressure}</td>
                    <td>${weather.humidity}</td>
                    <td>${weather.windSpeed}</td>
                    <td>${weather.windDirection}</td>
                </tr>
             </c:forEach>
         </table>

</body>
</html>