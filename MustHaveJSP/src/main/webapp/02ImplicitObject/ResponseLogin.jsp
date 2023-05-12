<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>"C:/Users/user/Downloads/musthave_jsp-main/musthave_jsp-main/WebContent/02ImplicitObject/OutMain.jsp"
<head><title>내장 객체 - Response</title></head>
<body>
	<%
	String id = request.getParameter("user_id");
	String pwd = request.getParameter("user_pwd"); 
	if (id.equalsIgnoreCase("must") && pwd.equalsIgnoreCase("1234")) {
		//sendRedirect : 브라우져에서 서버에 어떤 기능을 호출하기 위해 실행하면(LogI(n.jsp) 서버가 클라이언트한테 재요청함. 로그인이 되었으니 welcome페이지를 다시 호출하라고 브라우져한테 알려주는거
		//즉. 브라우져가 서버에 요청해서 서버가 sendRedirect를 호출하여 브라우져한테 response.sendRedirect를 요청하는 형태로 동작. 즉 두번 왕복함. 전송량이 forward보다 많음.
    	response.sendRedirect("ResponseWelcome.jsp");
	}
	else {
    	request.getRequestDispatcher("ResponseMain.jsp?loginErr=1")
    	//forward : 브라우져에서 요청해 서버로가서 처리 후 서버 내에서 reposemain.jsp로 에러 메세지를 붙여 만들어진 html을 브라우져로 보냄. 즉 한번만 왕복함. 
       	.forward(request, response); 	
	}
	%>
</body>
</html>