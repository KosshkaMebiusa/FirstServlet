<%@ page import="java.util.*, java.text.*" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page isELIgnored = "false" %>
<%-- <%@ taglib prefix="c" uri="http://java.sun.ru/jstl/core" %> --%>
<html>
<head>
    <title>
        Weather
    </title>
</head>

<body>

    <h1>Hello, ${login}!</h1>
    <br>
    <h2>
        Now in ${city}: <br><br>
        OpenWeatherMap:<br>
        ${weatherConditionOWM}<br>
        ${temperatureOWM} degrees, ${pressureOWM} mb, humiduty ${humidityOWM}% <br>
        wind: speed ${windspeedOWM} m/s, direction: ${winddirectionOWM} degrees <br>
        <br> WorldWeatherOnline:<br>
        ${weatherConditionWWO}<br>
        ${temperatureWWO} degrees, ${pressureWWO} mb, humiduty ${humidityWWO}% <br>
        wind: speed ${windspeedWWO} m/s, direction: ${winddirectionWWO} degrees <br>
     </h2>

<%-- Here are all authors matching your search critera:
    <table>
      <TH>Name</th>
      <TH>Id</th>
      <c:forEach items="${authors}" var="current">
        <tr>
          <td><c:out value="${current.name}" /><td>
          <td><c:out value="${current.id}" /><td>
        </tr>
      </c:forEach>
    </table>
--%>

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
                    <td>!!!${weatherList[0].date}</td>
                    <td>!!!${weatherList[0].time}</td>
                    <td>${weather[0].weatherCondition}</td>
                    <td>${weatherList[c].temperature}</td>
                    <td>${weather.pressure}</td>
                    <td>${weather.humidity}</td>
                    <td>${weather.windSpeed}</td>
                    <td>${weather.windDirection}</td>
                </tr>
             </c:forEach>
         </table>

</body>
</html>