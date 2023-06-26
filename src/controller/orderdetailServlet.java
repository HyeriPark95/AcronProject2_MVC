package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.Orderlist;
import model.dao.orderlistDAO;


@WebServlet(name = "OrderdetailServlet", urlPatterns = { "/OrderdetailServlet" })
public class orderdetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		System.out.println("kkkkkd65446");
		
		//String id = "tpgml";
		orderlistDAO dao = new orderlistDAO();
		 ArrayList<Orderlist> list = dao.getOrderlist(id);
		 System.out.println(list);
		
		 

		 request.setAttribute("list", list); //(키,값)
		 request.getRequestDispatcher("WEB-INF/views/orderlist.jsp").forward(request, response);

		 
	}

}
