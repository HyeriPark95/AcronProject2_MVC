package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.adminOrder;
import model.dao.adminOrderDAO;

@WebServlet("/adminOrder")
public class adminOrderServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//가져오기
		adminOrderDAO dao= new adminOrderDAO();
		ArrayList<adminOrder> list = (ArrayList<adminOrder>)dao.getAdminOrderList();
		System.out.println(list);
		
		//던져주기
		request.setAttribute("list", list);
		request.getRequestDispatcher("WEB-INF/views/adminOrder.jsp").forward(request, response);
	}
	
}
