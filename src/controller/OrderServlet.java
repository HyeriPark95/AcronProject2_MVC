package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.OrderDAO;

@WebServlet("/order")
public class OrderServlet extends HttpServlet{
	//상세페이지에서 주문하기 클릭했을 때에 넘어오는 서블릿
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//로그인 확인여부 체크
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		//String id="tpgml";
		System.out.println(id);
		if(id!=null){
			System.out.println("doPost");
			OrderDAO dao= new OrderDAO();
			
			int mno = dao.idToMno(id);
			
			
			//int mno=3;
			
			//시퀀스 만들기
			int seq = dao.seq();
			System.out.println(seq);
			
			// 주문생성
			dao.insertOrder(mno);	
			String gno = request.getParameter("gno");
			String amt_ = request.getParameter("amt");
			int amt = Integer.parseInt(amt_);
			
			// 주문번호를    사용  insert  
			dao.insertOrderItem(amt, gno);
			
			// qty 줄이기
			
			String qty_ = request.getParameter("qty").trim();
			System.out.println(qty_);
			
			int qty = Integer.parseInt(qty_);
			System.out.println("홀홀:" +qty);
			int newqty = qty-amt;
			System.out.println("새로운: "+newqty);
			dao.subQty(newqty, gno);
			
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('주문되었습니다')");
			out.println(" window.location.href='/project/goodslist'");
			out.println("</script>");
			
			//response.sendRedirect("/project/goodslist");
			
			
		}else{
			//로그인 안한경우
			response.sendRedirect("/project/login");
		}
	}

}
