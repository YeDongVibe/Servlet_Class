<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>내장 객체 - request</title></head>
<body>
	<%request.setCharacterEncoding("UTF-8"); %>
	<%
	request.setCharacterEncoding("UTF-8");  
	//요청할때 정보를 읽어오는 것을 getParameter이기에 get이덩 post이던지 이걸로 받아옴 ! 기억하자 이놈!
	String id = request.getParameter("id");  
	String sex = request.getParameter("sex");
	String[] favo = request.getParameterValues("favo");  
	String favoStr = "";
	if (favo != null) {  
    	for (int i = 0; i < favo.length; i++) {
        favoStr += favo[i] + " ";
    	}
	}
	//String intro1 = request.getParameter("intro").replace("\r\n", "<br/>");  
	//null.replace하면 null이라서 error뜸. 즉 데이터가 아무것도 입력되지 않았기에 에러가 뜨는거.
	String intro1 = request.getParameter("intro");
	String intro = "Empty";
	if(intro1 != null)
		intro = intro1.replace("\r\n", "<br/>");
	%>
<ul>
    <li>아이디 : <%= id %></li>
    <li>성별 : <%= sex %></li>
    <li>관심사항 : <%= favoStr %></li>
    <li>자기소개 : <%= intro %></li>
</ul>
</body>
</html>