<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	input[type="text"]{
   		border: 0px;
        border-bottom: 1px solid black;
        width: 150px;
        height: 30px;
        outline-style: none;
        padding-left : 5px;   
	}
	input[type="text"]:hover{
	   transition : 0.6s;
   	   color : black;
   	   background-color : #d1d1d1;
   	   cursor : pointer;
	}
	input[type="text"]:focus{
		transition: 0.6s;
        background-color: #d1d1d1;
    }
   input[type="submit"]{
        border: 0.1mm solid rgb(85, 85, 85);
        padding: 5px;
        background-color: rgb(236, 236, 236);
        border-radius: 3px;
        font-size: 12px;
    }

    input[type="submit"]:hover{
        cursor: pointer;
        transition: 0.2s;
        background-color: rgb(226, 226, 226);
        border: 0.1mm solid rgb(65, 65, 65);
    }
</style>


<script>

  window.addEventListener("load", function(){
		 
    	 //alert( "dkfkfkf= " + opener.document.frm.pInput.value);
    	 let id = opener.document.frm.pInput.value;
    	 
    	 document.frm.cInput.value  =id;
    
  })
</script>
</head>
<body>
<div style="text-align: center">
	<h3>아이디 중복확인</h3>
	
    <form  name="frm"  method="post" action="idCheckProc.jsp" onsubmit="return blankCheck(this)">
    아이디 : <input type="text" name="cInput" maxlength="10" autofocus>
    <input type="submit" value="중복확인">
    </form>
    </div>
    
    <script>
    function blankCheck(f){
    	
    	
    	var id=f.id.value;
        id=id.trim();
        if(id.length<2){
        	alert("아이디는 2자 이상 입력해주십시오.");
            return false;
        }//if end
        return true;
    }//blankCheck() end
    </script>
 </body>
 </html>
