<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="css/login.css" />
</head>
<body>
    <div class="signup-header">
    <h2>Login to <mark>B.A.D Shop</mark></h2>
    </div>

    <form method="post" action="login">
	 
        <input type="hidden" name="page" value="login-form">

        <font color="#F24638"><c:out value="${msg}"></c:out></font>
	 
        <div class="signup-group">
            <label>Username</label>
            <input type="text" name="username" placeholder="Your Username" value="<c:out value='${username}'></c:out>">
        </div>
	<div class="signup-group">
            <label>Password</label>
            <input type="password" name="password" placeholder="Enter password">
	</div>
	 <div class="signup-group">
            <button type="submit" name="login" class="signup-btn">Log in</button>
	</div>
	<p>
            New to B.A.D Shop? <a href="it_signup.jsp" style="color:#F24638;">Create Account</a>
	</p>
    </form>
	<br><br><br>
    <footer style="position: fixed;bottom: 14em;left: 36em;width: 100%;">
        <div class="footer"> &copy; 2021 Copyright:
	<a href="Home"> B.A.D Shop</a>
	</div>
    </footer>
</body>
</html>
