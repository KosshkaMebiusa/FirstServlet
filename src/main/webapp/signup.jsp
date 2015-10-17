<%@ page import="java.util.*, java.text.*" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page isELIgnored = "false" %>
<html>
<head>
    <title>
        Sign Up
    </title>
</head>

<body>

    <h2>Unknown user. Please, sign up.</h2>
    <FORM name="form1" action="signup" method="post">
        Login: <INPUT type="text" name="login" size="20" maxlength="20"><BR>
        Password: <INPUT type="text" name="password" size="20" maxlength="20"><BR>
        City: <INPUT type="text" name="city" size="20" maxlength="20">
        <BR><BR><BR>

        <INPUT type="submit" value="Sign Up"/><BR>
    </FORM>

</body>
</html>