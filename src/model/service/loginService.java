package model.service;

import model.dao.MemberDAO;

public class loginService {

	MemberDAO dao;

	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	public boolean logincheck( String id,String pw){
		
		boolean result=dao.login(id, pw);
		return result;
	}
}
