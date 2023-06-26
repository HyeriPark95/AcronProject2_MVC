<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.dao.Goods" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>    
    <script
      src="https://kit.fontawesome.com/4ec79785b5.js"
      crossorigin="anonymous"
	></script>
<style>
		/*🔴haeder*/
		@font-face {
        font-family: "Pretendard-Regular";
        src: url("https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff")
          format("woff");
        font-weight: 400;
        font-style: normal;
      }
	  *{
        padding: 0;
        margin: 0;
        font-family: "Pretendard-Regular";
      }
      body{
        min-width: 1050px;
      }
      header {
        margin: 0 auto;
        margin-top: 20px;
        width: 1050px;
        height: 100px;
        display: flex;
        align-items: center;
        justify-content: space-between;
        position: relative;
      }
      .logo {
        display: flex;
        align-items: center;
      }
      .logo img {
        width: 150px;
      }
      .search {
        padding-left: 5px;
        width: 400px;
        height: 45px;
        border: 1px solid black;
        border-radius: 5px;
      }
      .search i {
        font-size: 18px;
        cursor: pointer;
      }
      .search input {
        border: 0;
        outline: none;
        font-size: 16px;
        padding: 0;
        height: 44px;
        width: 340px;
        margin-right: 20px;
      }
      .user i {
        text-decoration: none;
        color: black;
        font-size: 25px;
        padding: 10px;
      }
      .user i:hover {
        color: rgb(113, 113, 113);
      }
      
      
     
    /*🔴section*/
  section{
        width: 100%;
        height: 500px;
        padding-top: 100px;
  }
  #frm{
        margin: 0 auto;
  }
	#order{
        width: 800px;
        display: flex;
        justify-content: space-between;
        flex-wrap: wrap;
        margin: 0 auto;
      }
	#order li{
		border: 1px solid black;
		width: 200px;
		height: 200px;
		margin: 3px;
	    list-style:none;
	    text-align: center;
	    }
	#order img{
		width: 400px;
		height: 400px;
		object-fit: contain;
	}
  #mainimg {
    width: 300px;
    height: 300px;
  }

  #order{
    display: flex;
  }
  #infobox{
    font-size: 18px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
  }
  #infobox h2{
    font-size: 40px;
  }
  .opt-wrap{
    display: flex;
  }
  .opt-right, .opt-left{
    display: inline-block;
  }
  .opt-left{
    width: 100px;
    font-weight: 600;
  }
  

  #orderbtn{
    width: 300px;
    height: 60px;
    font-size: 18px;
    background-color: rgb(223, 223, 223);
    border: 0;
    border-radius: 5px;
    cursor: pointer;
  }
  #orderbtn:hover{
    background-color: black;
    color: white;
  }
    
	
	
	/*🔴footer*/
	footer{
	box-shadow: 1px 1px 3px 1px rgb(201, 201, 201);
    width: 100%;
  }
  #info{
    width: 1200px;
    padding-top: 30px;
    margin: 30px auto;
  }

  .qbox{
    display: flex;
  }
  #call{
    margin-bottom: 30px;
  }
  #callnumber{
    font-size: 28px;
  }
  #call span{
    margin-right: 10px;
  }
  .qbox{
    padding: 5px 0px;
  }
  .qbox div{
    color: gray;
    font-size: 14px;
    line-height: 20px;
  }
  .qbox button{
    width: 180px;
    height: 40px;
    margin-right: 20px;
    border:1px solid rgb(206, 206, 206);
    padding: 8px 40px;
    background-color: white;
    cursor: pointer;
  }
  footer h2{
    padding: 20px 0;
  }
  #info{
    display: flex;
    justify-content: space-between;

  }
  #info2 ul{
    padding: 20px 0 20px 0;
    list-style: none;
    display: flex;
    margin-bottom: 50px;
    
  }
  #info2 ul li{
    margin-right: 15px;
  }
  #info2 p{
    font-size: 13px;
    color: gray;
    padding: 4px;
  }

  #icons{
    font-size: 30px;
    color: gray;
    margin-top: 20px;
  }
  #copyright{
    height: 100px;
    line-height: 100px;
    background-color: rgb(238, 238, 238);
    text-align: center;
    padding: 0 30px 0 30px;
    font-size: 12px;
    color: rgb(122, 122, 122);
    margin-top: 30px;
  }
</style>
    
<% 
	Goods goods = (Goods)request.getAttribute("item");
	System.out.println(goods);
	
%>
<script>
	function checkAmt(){
		let amt = document.getElementById("amt").value;
		if(amt><%=goods.getQty()%>){
			alert("주문가능 수량을 초과했습니다")
			return false;
		}else if(amt==""){
			alert("수량을 입력해주세요");
			return false;
		}{
			return true;
		}
	}
</script>
</head>

<body>
<header>
      <div class="logo">
        <a href="/project/goodslist"> <img src="data:image/png;base64,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" alt="" /> </a>
      </div>
      <div class="search">
        <input type="text"/>
        <i onclick="search(this)" class="fa-solid fa-magnifying-glass"></i>
      </div>
<%
 String id = (String)session.getAttribute("id");

if(id==null){
%>       
      <div class="user">
        <a href="/project/login"><i class="fa-solid fa-user"></i></a>
      </div>
<%}else{ %>
	</div>
      <div class="user">
        <a href="/project/OrderdetailServlet"><i class="fa-solid fa-user"></i></a>
        <a href="/project/logout"><i class="fa-solid fa-right-from-bracket"></i></a>
      </div>



<%} %>

    </header>
  
  
    <section>
      <form id="frm" action="/project/order" method="post" onsubmit="return checkAmt()">
        <div id="order">
          <img id="mainimg" src=<%=goods.getImg()%>>
          <div id="infobox">
            <h2><%=goods.getGname() %></h2>
            <div class="opt-wrap"><div class="opt-left">색상</div><div class="opt-right"><%=goods.getColor() %></div></div>
            <div class="opt-wrap"><div class="opt-left">가격</div><div class="opt-right" id="price"><%=goods.getPrice()%></div></div>
            <div class="opt-wrap"><div class="opt-left">재고</div><input type="hidden" name="qty" value="<%=goods.getQty() %>"><div class="opt-right"><%=goods.getQty() %> 개</div></div>
            <hr>
            <div class="opt-wrap"><div class="opt-left">주문수량</div><div class="opt-right"><input type="hidden" name="gno" value="<%=goods.getGno() %>"><input type="text" id="amt" name="amt" placeholder="수량입력"></div></div>
            <input id="orderbtn" type="submit" value="주문하기"></input>
        </div>
     </form>
    </section>
    
        <footer>
        <div id="info">
          <div id="info1">
            <h2>고객행복센터</h2>
              <div id="call"><span id="callnumber"><strong>1644-1107</strong></span><span>월~토요일 오전7시 - 오후 6시</span></div>
              <div class="qbox">
              <button>카카오톡 문의</button>
              <div>
                월~토요일| 오전7시 - 오후 6시<br>
                일~공휴일| 오전7시 - 오후 1시
              </div>
            </div>
            <div class="qbox">
              <a href="service.html"><button>1:1  문의</button></a>
              <div>
                365일<br>
                고객센터 운영시간에 순차적으로 답변드리겠습니다.
              </div>
            </div>
            <div class="qbox">
              <a href="service.html"><button>대량주문 문의</button></a>
              <div>
                월~금요일| 오전9시 - 오후 6시<br>
                점심시간| 오후1시 - 오후 2시
              </div>
            </div>
          </div>
          <div id="info2">
            <ul>
              <li>에이콘소개</li>
              <li>에이콘소개영상</li>
              <li>인재채용</li>
              <li>이용약관</li>
              <li>개인정보처리방침</li>
              <li>이용안내</li>
            </ul>
            <p>법인명(상호):주식회사 에이콘 | 사업자 등록번호:61-254-25225 사업자 정보확인</p>
            <P>통신판매업:제2018-서울강남-55566호 | 개인정보보호책임자:이원준</P>
            <P>주소:서울특별시 강남구 테헤란로 133,18층(역삼동) | 대표이사:양양양</P>
            <P>입점문의:입점문의하기| 제휴문의:ksjfdlssfljk@dlkjdl.com</P>
            <p>채용문의:sksdkf@kdfjsld.com</p>
            <p>팩스: 070-555-5545</p>
            <div id="icons">
              <i class="fa-brands fa-instagram"></i>
              <i class="fa-brands fa-facebook"></i>
              <i class="fa-brands fa-youtube"></i>
  
            </div>
          </div>
        </div>
        <div id="copyright">
          에이콘에서 판매되는 상품중에는 에이콘에 입접한 개별 판매자가 판매하는 오픈 마켓 상품이 포함되어 있습니다.
          ACORN CORP.ALL RIGHT RESERVED
        </div>
      </footer>
    
    
</body>
</html>