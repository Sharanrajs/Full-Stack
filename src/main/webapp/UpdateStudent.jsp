<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%ResultSet rs=(ResultSet)request.getAttribute("resultSet");
rs.next();%>
<form  action="update-student" method="post">
<input type="number"  value="<%= rs.getInt(1)%>" name="studentId" readonly="readonly" ><br>
<input  type="text"  name="studentName" value="<%= rs.getString(2)%>"><br>
<input type="text" name="studentEmail" value="<%= rs.getString(3)%>"><br>
<input  type="number" name="studentAge" value="<%=rs.getInt(4)%>"><br>
<input  type="text"  name="studentCourse" value="<%= rs.getString(5)%>"><br>
<input  type="text"  name="studentCity" value="<%= rs.getString(6)%>"><br>
<input type="submit" value="UPDATE">
</form>

</body>
</html>