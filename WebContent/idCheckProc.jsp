<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.dao.MemberDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

	a{
		text-decoration : none;
		border : 1px solid black;
		color : black;
		padding : 5px;
		border-top-right-radius: 5px;
		border-bottom-left-radius: 5px;
	}
	hr{
		margin-top : 20px;
		margin-bottom : 20px;
	}
	a:hover{
		cursor : pointer;
		transition : 0.5s;
		background-color : black;
		color : white;
	}
</style>
</head>
<body>
	<div style="text-align: center">
	<h3>아이디 중복 확인 결과 </h3>
<%
    //1) 사용가능한 아이디일 경우, 아이디 입력 폼에 넣기 위함
    MemberDAO dao = new MemberDAO();
    String id=request.getParameter("cInput");
    int cnt=dao.idCheck(id);
    out.println("입력 ID : <strong>" + id + "</stong>");
    if(cnt==0){
    	out.println("<p>사용 가능한 아이디입니다.</p>");
	out.println("<a href='javascript:apply(\"" + id + "\")'>적용</a>");
%>

	<script>
    	function apply(id){
            //2) 중복확인 id를 부모창에 적용
            //부모창 opener
            opener.document.frm.pInput.value=id;
            window.close(); //창닫기
        }//apply () end
    </script>
 <%
 	}else{
    	out.println("<p style='color: red'>해당 아이디는 사용하실 수 없습니다.</p>");
    }//if end
 %>
 <hr>
 <a href="javascript:history.back()">다시시도</a>
 &nbsp; &nbsp;
 <a href="javascript:window.close()">창닫기</a>
 </div>
 </body>
 </html>