<%@page import="shopping_assessment.ConnectionProvider"%>
<%@page import="java.sql.*"%>
<%



String email = session.getAttribute("email").toString();
String product_id=request.getParameter("id");
try
{
	Connection con= ConnectionProvider.getCon();
	Statement st = con.createStatement();
	st.executeUpdate("delete from cart where email='"+email+"' and product_id='"+product_id+"' and mobileNumber is NULL ");
	response.sendRedirect("myCart.jsp?msg=removed");

}
catch(Exception e)
{
	System.out.println(e);
}



%>