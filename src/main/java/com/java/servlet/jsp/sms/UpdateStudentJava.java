package com.java.servlet.jsp.sms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update-student")
public class UpdateStudentJava extends HttpServlet{
	
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 int studentId=Integer.parseInt(req.getParameter("studentId"));
		String studentName=req.getParameter("studentName");
		String studentEmail=req.getParameter("studentEmail");
		int studentAge=Integer.parseInt(req.getParameter("studentAge"));
		String studentCourse=req.getParameter("studentCourse");
		String studentCity=req.getParameter("studentCity");
		
	//JDBC Code
		
		
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/servlet_student-managment-system","root","sagar123");
			
			PreparedStatement pst=conn.prepareStatement(
					"update student set studentName=?,studentEmail=?,studentAge=?,studentCourse=?,studentCity=? where studentId=?");
			
			pst.setString(1, studentName);
			pst.setString(2, studentEmail);
			pst.setInt(3, studentAge);
			pst.setString(4,studentCourse);
			pst.setString(5, studentCity);
			pst.setInt(6, studentId);
			
			pst.execute();
			resp.sendRedirect("display-all-students");
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			if(conn!=null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
			
}
 }

