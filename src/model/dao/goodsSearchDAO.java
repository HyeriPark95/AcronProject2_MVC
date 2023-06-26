
package model.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.GoodsSearch;

public class goodsSearchDAO {
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
	
	
	public ArrayList<GoodsSearch> getGoodsItem(){
		dbcon();
		String sql=" select * from tbl_goods ";
		ArrayList<GoodsSearch> glist = new ArrayList<>();
		
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
				
				GoodsSearch goods = new GoodsSearch(gno,img,gname,price,color,qty);
				glist.add(goods);
			}
			/*
			GNO   NOT NULL VARCHAR2(30)  
			IMG   NOT NULL VARCHAR2(500) 
			GNAME NOT NULL VARCHAR2(30)  
			PRICE NOT NULL NUMBER(10)    
			COLOR NOT NULL VARCHAR2(30)  
			QTY   NOT NULL NUMBER(10)   
			*/
			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return glist;
	}
	
	public void insertGoods(GoodsSearch g){
		dbcon();
		String sql = " insert into tbl_goods values(?,?,?,?,?,?) ";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, g.getGno());
			pst.setString(2, g.getImg());
			pst.setString(3, g.getGname());
			pst.setInt(4, g.getPrice());
			pst.setString(5, g.getColor());
			pst.setInt(6, g.getQty());
			pst.executeQuery();
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteGoods(String gno){
		dbcon();
		String sql = " delete tbl_goods where gno= ? ";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, gno);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editGoods(GoodsSearch g){
		dbcon();
		String sql = " update tbl_goods set img=?, gname=?, price=?, color=?, qty=? where gno=? ";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, g.getImg());
			pst.setString(2, g.getGname());
			pst.setInt(3, g.getPrice());
			pst.setString(4, g.getColor());
			pst.setInt(5, g.getQty());
			pst.setString(6, g.getGno());
			pst.executeUpdate();
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	public static void main(String[] args){
		goodsSearchDAO dao = new goodsSearchDAO();
		ArrayList<GoodsSearch> list = dao.getGoodsItem();
		
		//System.out.println(list);
		//Goods good = new Goods("test","img:test","시계테스트",9999,"black",100);
		//dao.insertGoods(good);
		
		
		//Goods good = new Goods();
//		dao.deleteGoods();
		
		System.out.println(list);
	}
	
	
}


