<%@ page import="java.util.*, java.text.*" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page isELIgnored = "false" %>
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
        ${temperatureOWM} degrees, ${pressureOWM} mm Hg, humiduty ${humidityOWM}% <br>
        wind: speed ${windspeedOWM} m/s, direction: ${winddirectionOWM} degrees <br>
        <br> WorldWeatherOnline:<br>
        ${weatherConditionWWO}<br>
        ${temperatureWWO} degrees, ${pressureWWO} mm Hg, humiduty ${humidityWWO}% <br>
        wind: speed ${windspeedWWO} m/s, direction: ${winddirectionWWO} degrees <br>
     </h2>

</body>
</html>