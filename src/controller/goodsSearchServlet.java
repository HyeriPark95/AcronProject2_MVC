
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.GoodsSearch;
import model.dao.goodsSearchDAO;

@WebServlet("/goodsSearch")
public class goodsSearchServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		goodsSearchDAO dao = new goodsSearchDAO();
		ArrayList<GoodsSearch> list = dao.getGoodsItem();
		

		//System.out.println(list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("WEB-INF/views/goodsSearch.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String gno = request.getParameter("gno");
		String gimg = request.getParameter("gimg");
		String gname = request.getParameter("gname");
		String gprice_ = request.getParameter("gprice");
		int gprice = Integer.parseInt(gprice_);
		String gcolor = request.getParameter("gcolor");
		String qty_ = request.getParameter("gqty");
		int qty = Integer.parseInt(qty_);
		
		//System.out.println(gno + " " + gimg + " " + gname + " " + gprice + " " 
		//		+ gcolor + " " + qty);
		GoodsSearch good = new GoodsSearch(gno,gimg,gname,gprice,gcolor,qty);
		goodsSearchDAO dao = new goodsSearchDAO();
		dao.insertGoods(good);
		
		response.sendRedirect("/project/goodsSearch");
		
		
	}
}

