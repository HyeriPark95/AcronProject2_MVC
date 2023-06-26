package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.Goods;
import model.dao.goodsDAO;
import model.service.goodsService;

@WebServlet("/goodslist")
public class goodsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		goodsService service = new goodsService();
		goodsDAO dao = new goodsDAO();
		service.setDao(dao);
		
		
		ArrayList<Goods> list = service.getGoodsItems();
		//System.out.println(list);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("WEB-INF/views/goods.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	
}
