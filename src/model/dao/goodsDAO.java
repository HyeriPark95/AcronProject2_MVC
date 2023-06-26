package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class goodsDAO {
	String driver = "oracle.jdbc.driver.OracleDriver" ;
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String password="1234";
	
	Connection con;
	
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
	
	// 상품목록 goods정보들 가져오기
	public ArrayList<Goods> getGoodsItems(){
		dbcon();
		String sql=" select * from tbl_goods";
		
		ArrayList<Goods> list = new ArrayList<>();
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				String gno = rs.getString(1);
				String img = rs.getString(2);
				String gname = rs.getString(3);
				int price = rs.getInt(4);
				String color = rs.getString(5);
				int qty = rs.getInt(6);
				
				Goods goodslist = new Goods(gno, img, gname, price, color, qty);
				//System.out.println( img);
				list.add(goodslist);
			}
			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//상세페이지에서 goods정보 가져오는 메소드
	public Goods getGoodsItem(String gno){
		dbcon();
		Goods goods = new Goods();
		
		String sql="select * from tbl_goods where gno=?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, gno);
			ResultSet rs = pst.executeQuery();
					
			if(rs.next()){
				goods.setGno(rs.getString(1));
				goods.setImg(rs.getString(2));
				goods.setGname(rs.getString(3));
				goods.setPrice(rs.getInt(4));
				goods.setColor(rs.getString(5));
				goods.setQty(rs.getInt(6));
			}
			
			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goods;
	}
	
	
	
	
}
