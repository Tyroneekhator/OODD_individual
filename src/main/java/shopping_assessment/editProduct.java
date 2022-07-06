package shopping_assessment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

@WebServlet("/edit")
public class editProduct extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String price = request.getParameter("price");
		String active = request.getParameter("active");
		String quantity= request.getParameter("quantity");
		
		
		try{
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
		
			st.executeUpdate("update product set name='"+name+"',category='"+category+"',price='"+price+"',active='"+active+"',quantity='"+quantity+"'where id ='"+id+"'");
			if(active.equals("out of stock")) 
			{
				st.executeUpdate("delete from cart where product_id='"+id+"' and email is NULL");
			}
			response.sendRedirect("admin/allProductEditProduct.jsp?msg=done");
		}
		catch(Exception e)
		{
			System.out.println(e);
			response.sendRedirect("admin/allProductEditProduct.jsp?msg=wrong");
			
			
		}
		
		
	}

}
