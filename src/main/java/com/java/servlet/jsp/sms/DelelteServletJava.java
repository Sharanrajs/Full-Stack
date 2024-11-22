package com.java.servlet.jsp.sms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete-student")
public class DelelteServletJava extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int studentId=Integer.parseInt(req.getParameter("studentId"));
		Connection con=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/servlet_student-managment-system","root","sagar123");
		PreparedStatement pst=con.prepareStatement("delete from student where studentId=?");
		
		pst.setInt(1, studentId);
		pst.execute();
		resp.sendRedirect("display-all-students");
		}
		catch(SQLException|ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		
		finally {
			if(con!=null)
			{
				try {
				con.close();
			}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
		}
	}
	
	}
}
