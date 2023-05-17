<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단을 외우자~~구구단을 외우자~~(JSP)</title>
</head>
<body>
<%
String sel = request.getParameter("sel");
String val = request.getParameter("val");

//여기는 url에 보여용
//gugudan1,2페이지를 호출함
// if(sel.equals("GuGuDanType1")) {
// 	response.sendRedirect("GuGuDan.jsp?num=" + val);
	
// }
// else {
// 	response.sendRedirect("GuGuDan2.jsp?col=" + val);

// }

//여기는 url에 안보여용
//Main페이지를 호출함.
if(sel.equals("GuGuDanType1")) {
	request.getRequestDispatcher("GuGuDan.jsp?num=" + val).forward(request, response);
	
}
else {
	request.getRequestDispatcher("GuGuDan2.jsp?col=" + val).forward(request, response);

}

%>

</body>
</html>