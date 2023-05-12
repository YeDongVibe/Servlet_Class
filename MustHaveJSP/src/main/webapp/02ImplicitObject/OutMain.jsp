<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 - out</title>
<body>
    <%
    //PrintWriter out = resp.getWriter();이라고 선언하지 않아도 java로 컨버전 될 때 거기서 이미 선언되어 있기에 그냥 사용 가능.
    // 버퍼 내용 삭제하기
    out.print("출력되지 않는 텍스트");  // 버퍼에 저장  
    out.clearBuffer();  // 버퍼를 비움(윗 줄의 출력 결과 사라짐) 

    out.print("<h2>out 내장 객체</h2>");

    // 버퍼 크기 정보 확인
    //buffer : 네트워크를 통해 데이터가 전송이 되는데, 메모리 한부분을 할당하여 그 메모리가 차면 한번에 전송하는데 이것을 데이터양으로 측정 된다. 여기서 전송하는 데이터(체크섬 , 아이디 등 외의 순수한 전송목적으로 가진 데이터)를 버퍼라고 함.
    out.print("출력 버퍼의 크기 : " + out.getBufferSize() + "<br>");
    out.print("남은 버퍼의 크기 : " + out.getRemaining() + "<br>"); 

    out.flush();  // 버퍼 내용 출력 
    out.print("flush 후 버퍼의 크기 : " + out.getRemaining() + "<br>");

    // 다양한 타입의 값 출력
    out.print(1);
    out.print(false);
    out.print('가');
    %>
</body>
</html>