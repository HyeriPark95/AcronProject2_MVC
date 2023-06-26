package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.Goods;
import model.dao.goodsDAO;

@WebServlet("/detail")
public class detailServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String gno=request.getParameter("gno");
		
		goodsDAO dao = new goodsDAO();
		Goods goods = dao.getGoodsItem(gno);
		
		request.setAttribute("item", goods);
		request.getRequestDispatcher("WEB-INF/views/detail.jsp").forward(request, response);
	}
	
	
	
	
}

