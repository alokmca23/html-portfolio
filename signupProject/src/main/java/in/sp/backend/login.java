package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class login extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
//		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
		String email = req.getParameter("email");
		String mypass = req.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM student_info WHERE Email=? AND Password=?");
			ps.setString(1, email);
			ps.setString(2, mypass);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				HttpSession session = req.getSession();
				session.setAttribute("session_name", rs.getString("Name"));
				RequestDispatcher rd = req.getRequestDispatcher("profile.jsp");
				rd.include(req,res);
				
			}
			else {
				PrintWriter out = res.getWriter();
				out.print("<h3 style='color:red'>Email id or password didn't match</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.include(req,res);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			PrintWriter out = res.getWriter();
			out.print("<h3 style='color:red'>Exception occured :"+e.getMessage()+"</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.include(req,res);
		}
	}

}
