package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderDAO {
	String driver = "oracle.jdbc.driver.OracleDriver" ;
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String password="1234";
	
	Connection con;
	int seq=0;
	
	private void dbcon(){

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			if(con!=null){
				System.out.println("dbok");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//테이블 공통 시퀀스 값을 생성
	public int seq(){
		dbcon();
		
		String sql = "select onoseq.nextval from dual";
		try {
			PreparedStatement pst =  con.prepareStatement(sql);
			
			ResultSet rs =  pst.executeQuery();
			if(rs.next()){
				seq = rs.getInt(1);
			}
			System.out.println("다음 시퀀스");
			System.out.println(seq);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seq;
		
	}
	
	//id값을 가져와서 mmo으로 반환
	public int idToMno(String id){
		dbcon();
		int Mno=0;
		System.out.println("id =" + id);
		String sql = "select mno from tbl_member where id=?";
		
		System.out.println( sql);
		try {
			PreparedStatement pst =  con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				System.out.println("sfd");
				Mno = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Mno;
	}
	
	
	public void insertOrder(int mno){
		dbcon();
		String sql="insert into tbl_order values(?,?,?)";  //시퀀스
		//String sql="insert into tbl_order values(?,?,?)";
		System.out.println("order시작");
		//오늘날짜 넣기
		LocalDate now= LocalDate.now();
		DateTimeFormatter odate_ = DateTimeFormatter.ofPattern("yyyyMMdd");
		String odate = now.format(odate_);
		System.out.println(odate);
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, seq);
			pst.setString(2, odate);
			pst.setInt(3, mno);

			
			pst.executeUpdate();
			System.out.println("tbl_order 업뎃완료");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertOrderItem(int amt,String gno){
		dbcon();
		String sql="insert into order_item values(?,?,?)";
		

		System.out.println("orderItem시작");
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, amt);
			pst.setInt(2, seq);
			pst.setString(3, gno);
			
			pst.executeUpdate();
			System.out.println("order_item 업뎃완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//구매한 수량만큼 qty값 수정
	public void subQty(int newqty,String gno){
		dbcon();
		String sql=" update tbl_goods set qty=? where gno=? " ;
		
		try {
			PreparedStatement pst =  con.prepareStatement(sql);
			pst.setInt(1, newqty);
			pst.setString(2, gno);
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[]  args){
		
		OrderDAO dao = new OrderDAO();
		
		dao.idToMno("tpgml");
		
	}
}
