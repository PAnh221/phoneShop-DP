<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up Page</title>
        <link rel="stylesheet" href="css/login.css" />
    </head>
    <body>
        <div class="signup-header">
	 	<h2>Signup with B.A.D Shop</h2>
	 </div>

	 <form method="post" action="signup">
	 
	 <input type="hidden" name="page" value="sign-up-form">
	
	 	<font color="#F24638"><c:out value="${msg}"></c:out></font>
	 	
	 	
	 	<div class="signup-group">
	 		<label>Name</label>
	 		<input type="text" name="name" placeholder="Name goes here" value="<c:out value="${name }"></c:out>" required>
	 	</div>
	 	<div class="signup-group">
	 		<label>Email</label>
	 		<input type="email" name="email" placeholder="Your email" value="<c:out value="${email}"></c:out>" required>
	 	</div>
	 	<div class="signup-group">
	 		<label>Address</label>
	 		<input type="text" name="address" placeholder="Your address goes here" value="<c:out value="${address }"></c:out>" required>
	 	</div>
                <div class="signup-group">
	 		<label>Username</label>
	 		<input type="text" name="username" placeholder="Username goes here" value="<c:out value="${name }"></c:out>" required>
	 	</div>
	 	<div class="signup-group">
	 		<label>Password</label>
	 		<input type="password" name="password_1" placeholder="Enter password" required>
	 	</div>
	 	<div class="signup-group">
	 		<label>Confirm Password</label>
	 		<input type="password" name="password_2" placeholder="Re-enter password" required>
	 	</div>
	 	
	 	<div class="signup-group">
	 		<button type="submit" name="register" class="signup-btn">Register</button>
	 	</div>
	 	<p>
	 		Already have an account? <a href="it_login.jsp" style="color:#F24638;">Login!</a>
	 	</p>
	 </form>
	<br><br><br>
	<footer style="position: fixed;bottom: 2em;left: 36em;width: 100%;">
		<div class="footer"> &copy; 2021 Copyright:
	      <a href="home"> B.A.D Shop</a>
	    </div>
	</footer>
    </body>
</html>
