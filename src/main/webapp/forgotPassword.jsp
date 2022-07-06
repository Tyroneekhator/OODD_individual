<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/signup-style.css">
<title>ForgotPassword</title>
</head>
<body>
<div id='container'>
  <div class='signup'>
    <form action="forgotPasswordAction.jsp" method ="post">
     	<input type="email" name="email" placeholder="Enter email" required>
    	<input type="password" name="newpass" placeholder="Enter  new password" required>
    	<input type ="submit" value="Save">
  
  </form>
     
      <h2><a href="login.jsp">Login</a></h2>
  </div>
  <div class='whyforgotPassword'>

 
 <% 
 String msg =  request.getParameter("msg");
if("done".equals(msg))
{
%>	
<h1>Password Changed Successfully! Please log in</h1>
<%} %>
<%
if("invalid".equals(msg))
{
%>	<h1>Some thing Went Wrong! Try Again !</h1>
<%} %>  



    <h2>Online Shopping</h2>
    <p>forgot password ? no problem! please enter a new one</p>
  </div>
</div>
</body>
</html>