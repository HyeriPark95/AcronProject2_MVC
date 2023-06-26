package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.goodsSearchDAO;

@WebServlet("/goodsDelete")
public class goodsDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String gno =  request.getParameter("gno");
		//System.out.println(gno);
		goodsSearchDAO dao = new goodsSearchDAO();
		dao.deleteGoods(gno);
		
		
		response.sendRedirect("/project/goodsSearch");
	}
}
