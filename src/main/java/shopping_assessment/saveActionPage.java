package shopping_assessment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/save")
public class saveActionPage extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
	String name= request.getParameter("name");
	String email= request.getParameter("email");
	String mobile= request.getParameter("mobile");
	String password= request.getParameter("password");
	
	try{
		Connection con = ConnectionProvider.getCon();
		PreparedStatement ps = con.prepareStatement("insert into users values(?,?,?,?)");
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3, mobile);
		ps.setString(4, password);
		ps.executeUpdate();
		response.sendRedirect("signup.jsp?msg=valid");
	}
	catch(Exception e)
	{
		System.out.println(e);
		response.sendRedirect("signup.jsp?msg=invalid");
		
		
	}
	
	
	}

}
