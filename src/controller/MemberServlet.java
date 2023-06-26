package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.Member;
import model.dao.MemberDAO;
import model.service.MemberService;


@WebServlet("/membercheck")
public class MemberServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberService service = new MemberService();
		MemberDAO dao = new MemberDAO();
		service.setDao(dao);
		
		ArrayList<Member> list = service.getMemberList();
		//System.out.println( list);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("WEB-INF/views/회원조회.jsp").forward(request, response);
		
		
	}
}
