package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.Member_minju;
import model.dao.MemberDAO;

@WebServlet("/reg")
public class regServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/reg.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String id = request.getParameter("uid");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		System.out.println(name + " " + id + " " + pw + " " + tel + " " + addr);
		
		Member_minju member = new Member_minju(name, id, pw, tel, addr);
		MemberDAO dao = new MemberDAO();
		dao.insertMember(member);
		
		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
		
	}

}
