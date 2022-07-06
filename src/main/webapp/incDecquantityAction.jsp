<%@page import="shopping_assessment.ConnectionProvider"%>
<%@page import="java.sql.*"%>

<%

String email= session.getAttribute("email").toString();
String id = request.getParameter("id");
String incdec=request.getParameter("quantity");
int price = 0;
int quan = 0;
int total = 0;
int final_total = 0;
try
{
	Connection con = ConnectionProvider.getCon();
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("select *from cart where email='"+email+"' and product_id='"+id+"' and mobileNumber is NULL");
	while(rs.next())
	{
		price = rs.getInt(4);
		total = rs.getInt(5);
		quan = rs.getInt(3);
	}
	if(quan== 1 && incdec.equals("dec"))
		response.sendRedirect("myCart.jsp?msg=notPossible");
	else if(quan !=1 && incdec.equals("dec"))
	{
		total = total - price;
		quan-=1;
		st.executeUpdate("update cart set total='"+total+"',quantity='"+quan+"' where email='"+email+"' and product_id='"+id+"' and mobileNumber is NULL");
		response.sendRedirect("myCart.jsp?msg=dec");
	}
	else{
		total = total + price;
		quan+= 1;
		st.executeUpdate("update cart set total='"+total+"',quantity='"+quan+"' where email='"+email+"' and product_id='"+id+"'and mobileNumber is NULL");
		response.sendRedirect("myCart.jsp?msg=inc");
	}
	}
catch(Exception e)
{
	System.out.println(e);
}

%>