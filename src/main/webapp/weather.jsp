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
        Now in ${city}: <br>
        ${temperature} degrees <br>
     </h2>

</body>
</html>