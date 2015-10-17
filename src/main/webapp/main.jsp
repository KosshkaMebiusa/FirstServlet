<%@ page import="java.util.*, java.text.*" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page isELIgnored = "false" %>
<html>
<head>
    <title>
        Welcome!
    </title>
</head>
 
<body>

    <h2>Hello!</h2>
    <FORM name="form1" action="signin" method="POST">
        Login: <INPUT type="text" name="login" size="20" maxlength="20"><BR>
        Password: <INPUT type="text" name="password" size="20" maxlength="20">
        <BR><BR><BR>

        <INPUT type="submit" name="signin" value="Sign In"/><BR>
    </FORM>

</body>
</html>