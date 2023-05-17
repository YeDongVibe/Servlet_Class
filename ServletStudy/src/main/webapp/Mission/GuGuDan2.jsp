<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String scol = request.getParameter("col");

int col = 3;
if (scol != null) {
	col = Integer.parseInt(scol);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단을 외우자~~구구단을 외우자~~(JSP)</title>
</head>
<body>
	<h2>구구단 타입 2</h2>
<%
	for (int i = 2; i <= 9; i += col) {
		for (int k = 1; k <= 9; k++) {
			for (int j = 0; j < col; j++) {
				if (i + j > 9)
					break;
				out.print(String.format("%d * %d = %d ||  ", i + j, k, (i + j) * k));
			}
			out.print("<br>");

		}
		out.print("<br>");

	}
%>


</body>
</html>