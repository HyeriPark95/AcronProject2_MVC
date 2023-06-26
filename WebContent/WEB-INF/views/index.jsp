<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 로그인 되었습니다 </h1>
	<% 
		String id = (String)session.getAttribute("id");
		if ( id == null ) {
	%>
	<a href="/project/login">로그인</a>
	
	<% }else{ %>
	
	<a href="/project/login">
	<%=id %> 님 ㅎㅇㅎㅇ <br>
	 로그아웃 </a>
	 
	 <%} %>
</body>
</html>