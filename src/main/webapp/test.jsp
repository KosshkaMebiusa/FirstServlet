<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LA Test</title>
</head>
<body>

    <h1>Please, choose algorithm and parametrs</h1>
    <br>

    <select name="Algorithm">
        <option value="NN"> NearestNeighbor</option>
    </select>

    <select name="n">
        <option value="5"> 5</option>
    </select>

    <FORM name="form1" action="test" method="get">
        <BR><BR>
        <INPUT type="submit" value="Test!"/>
        <BR><BR>
    </FORM>

</body>
</html>
