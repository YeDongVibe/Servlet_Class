<%@page import="java.sql.Connection"%>
<%@ page import = "common.JDBCConnection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
<h2>JDBC 테스트1</h2>
<%
JDBCConnection jdbcCon = new JDBCConnection();
Connection con = jdbcCon.getConnection();

jdbcCon.writeMemberToTable(con, out);

con.close();

%>

</body>
</html>