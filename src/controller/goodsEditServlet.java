package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.GoodsSearch;
import model.dao.goodsSearchDAO;

@WebServlet("/goodsEdit")
public class goodsEditServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String editgno  = request.getParameter("editgno");
		String editgimg = request.getParameter("editgimg");
		String editgname = request.getParameter("editgname");
		String editgprice_ = request.getParameter("editgprice");
		int editgprice = Integer.parseInt(editgprice_);
		String editgcolor = request.getParameter("editgcolor");
		String editgqty_ = request.getParameter("editgqty");
		int editgqty = Integer.parseInt(editgqty_);
		
		System.out.println(editgno + " " + editgimg + " " + editgname + " " 
					+ editgprice + " " +editgcolor + " " +editgqty);
		//System.out.println(editgnoarray[1]);
		GoodsSearch g = new GoodsSearch(editgno, editgimg, editgname,editgprice,editgcolor,editgqty);
		goodsSearchDAO dao  = new goodsSearchDAO();
		dao.editGoods(g);
		response.sendRedirect("/project/goodsSearch");
		
	}
			
}
