package model.service;

import java.util.ArrayList;

import model.dao.Member;
import model.dao.MemberDAO;


public class MemberService {

	MemberDAO dao;

	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	public ArrayList<Member> getMemberList() {
		
		ArrayList<Member> list = dao.getMemberList();
		return list;
	}
	
}
