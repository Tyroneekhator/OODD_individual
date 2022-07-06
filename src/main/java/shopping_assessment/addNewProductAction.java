package shopping_assessment;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;



@WebServlet("/servlet")
public class addNewProductAction extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String id= request.getParameter("id");
		String name= request.getParameter("name");
		String category= request.getParameter("category");
		String price= request.getParameter("price");
		String quantity= request.getParameter("quantity");
		String active= request.getParameter("active");
	
		
	try
	{
		Connection con = ConnectionProvider.getCon();
		PreparedStatement ps = con.prepareStatement("insert into product values(?,?,?,?,?,?)");
		ps.setString(1, id);
		ps.setString(2, name);
		ps.setString(3, category);
		ps.setString(4, price);
		ps.setString(5, active);
		ps.setString(6, quantity);
		ps.executeUpdate();
		response.sendRedirect("admin/addNewProduct.jsp?msg=done");
		//addNewProduct.jsp
	

	}
	catch(Exception e)
	{
		response.sendRedirect("admin/addNewProduct.jsp?msg=wrong");
	}
	}

}
