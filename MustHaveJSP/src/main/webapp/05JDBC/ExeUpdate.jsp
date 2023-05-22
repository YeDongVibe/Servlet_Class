<%@ page import = "java.sql.PreparedStatement" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "common.JDBCConnect" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
<h2>회원 추가 테스트(executeUpdate() 사용)</h2>

<%
JDBCConnect jdbc = new JDBCConnect();
Connection con = jdbc.getConnection();
	if(con == null) {
		out.println("Fail");
		return;
	}


// String id = "test1";
// String pass = "1111";
// String name = "테스트1회원";

String id = request.getParameter("id");
String pass = request.getParameter("pass");
String name = request.getParameter("name");

if(id == null) {
	out.println("Fail");
	return;
}


String sql = "INSERT INTO member (id,pass,name) values (?,?,?)";
PreparedStatement psmt = con.prepareStatement(sql);

psmt.setString(1,id);
psmt.setString(2,pass);
psmt.setString(3,name);

int inResult = psmt.executeUpdate();
out.println(inResult + "행이 입력되었습니다.");

psmt.close();

con.close();

%>

</body>
</html>