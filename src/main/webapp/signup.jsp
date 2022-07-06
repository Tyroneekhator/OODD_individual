<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/signup-style.css">
<title>Signup</title>
</head>
<body>
<div id='container'>
  <div class='signup'>
    <form action="save" method="post">
    	<input type="text" name="name" placeholder="Enter name" required>
    	<input type="email" name="email" placeholder="Enter email" required>
    	<input type="number" name="mobile" placeholder="Enter number" required>
    	<input type="password" name="password" placeholder="Enter password" required>
    	<input type="submit" value="signup">
    </form>
      <h2><a href="login.jsp">Login</a></h2>
  </div>
  <div class='whysign'>
<% 
 String msg =  request.getParameter("msg");
if("valid".equals(msg))
{
%>	
	
<h1>Successfully Registered please log in</h1>
<%} %>
<%
if("invalid".equals(msg))
{
%>	<h1>Some thing Went Wrong! Try Again !</h1>
<%} %>








    <h2>Online registration</h2>
    <p>please sign up for an account.</p>
  </div>
</div>

</body>
</html>