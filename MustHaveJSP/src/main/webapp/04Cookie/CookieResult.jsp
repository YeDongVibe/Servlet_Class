<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CookieResult.jsp</title>
</head>
<body>쿠키명 : myCookie - 쿠키값 : 쿠키맛나요
<h2>쿠키값 확인하기(쿠키가 생성된 이후의 페이지)</h2>
<%
Cookie[] cookies = request.getCookies();
if(cookies != null) {
	//확장된 for(아래의 코드보다 더 안정적. 왜냐면 그냥 cookie에 저장되는 모든 값을 다 불러오기에)
	for(Cookie c : cookies) {
		String cookieName = c.getName();
		String cookieValue = c.getValue();
		out.println(String.format("쿠키명 : %s - 쿠키값 : %s<br />", cookieName, cookieValue));
	}
	
// 	for(int i = 0; i< cookies.length; i++) {
// 		String cookieName = cookies[i].getName();
// 		String cookieValue = cookies[i].getValue();
// 		out.println(String.format("쿠키명 : %s - 쿠키값 : %s<br />", cookieName, cookieValue));
// }
}
%>
</body>
</html>