package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "system";
	String password = "1234";
	
	Connection con;
	private void dbcon(){
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
			if(con!=null){
				System.out.println("ok");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Member> getMemberList(){
		dbcon();
		String sql = "select * from tbl_member";
		ArrayList<Member> mlist = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				int mno = rs.getInt(1);
				String mname = rs.getString(2);
				String id = rs.getString(3);
				String pw = rs.getString(4);
				String tel = rs.getString(5);
				int point = rs.getInt(6);
				String grade = rs.getString(7);
				String addr = rs.getString(8);
				Member member = new Member(mno, mname, id, pw, tel, point, grade, addr);
				mlist.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mlist;
	}
	
	
	public void insertMember(Member_minju m){
		dbcon(); 
		String sql = " insert into tbl_member(MNO, MNAME, ID, PW,TEL,ADDR) values (?,?,?,?,?,?) ";
		ArrayList<Member> list = getMemberList();
		try {
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, list.size()+1);
			pst.setString(2, m.getMname());
			pst.setString(3, m.getId());
			pst.setString(4, m.getPw());
			pst.setString(5, m.getTel());
			pst.setString(6, m.getAddr());
			pst.executeUpdate();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean login(String id, String pw){
		dbcon();
		String sql=" select pw from tbl_member where id=?";
		
		try{
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			
			if( rs.next()){
				if( rs.getString(1).equals(pw)){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}catch (SQLException e ){
			e.printStackTrace();
			return false;
		}
	
	}
	
	public int idCheck(String id){
		dbcon();
		String sql = " select * from tbl_member where id=? ";
		int result = 0;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				result = 1;
			}else{
				System.out.println("아이디가 없습니다.");
				result = 0;
			}
			
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args){
		MemberDAO dao = new MemberDAO();
		//dao.dbcon();
		
		//Member member = new Member("테스트","idtest","pwtest","010-1234-1234","서울테스트");
		//dao.insertMember(member);
		
		//ArrayList<Member> list = dao.getMemberList();
		
		//System.out.println(list);
		dao.idCheck("sun123");
		
		
		
	}
}
