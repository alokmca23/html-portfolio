package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class register extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		
		PrintWriter out = res.getWriter();
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String city = req.getParameter("city");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
			PreparedStatement ps = con.prepareStatement("INSERT INTO student_info VALUES (?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, gender);
			ps.setString(5, city);
			
			int count = ps.executeUpdate();
			if(count > 0) {
				res.setContentType("text/html");
				out.print("<h3 style='color:green'>User registered successfully</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.include(req, res);
			}
			else {
				res.setContentType("text/html");
				out.print("<h3 style='color:red'>User not registered due to some error</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.include(req, res);
			}
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			res.setContentType("text/html");
			out.print("<h3 style='color:red'>Exception occured :"+e.getMessage()+"</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.include(req, res);
		}
		
	}

}
