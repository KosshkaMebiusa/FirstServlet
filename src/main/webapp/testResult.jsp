<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LA Test</title>
</head>
<body>

<h1>Test ${algorithm}</h1>
<br>

Q = ${Q}

<br>
<br>

<table border="1px" cellpadding="8px">
    <tr>
        <th>Object</th>
        <th>LA Answer</th>
        <th>Real Answer</th>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
        <td>

        <c:forEach items="${item.object}" var="weather">
            ${weather}<br>
        </c:forEach>

        </td>
        <td>${item.answer}</td>
        <td>${item.realAnswer}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
