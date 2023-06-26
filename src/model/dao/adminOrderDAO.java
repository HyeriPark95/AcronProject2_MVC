package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class adminOrderDAO {
	
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
	
	public ArrayList<adminOrder> getAdminOrderList(){
		dbcon();
		String sql = "select o.ono, g.gname, oi.amt, m.mno, m.mname, g.price*oi.amt, o.odate ";
						sql += " from order_item oi ";
						sql += " join tbl_order o on oi.ono=o.ono ";
						sql += " join tbl_goods g on oi.GNO=g.gno ";
						sql += " join tbl_member m on o.MNO = m.mno order by ono";
							
		ArrayList<adminOrder> list = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				System.out.println("kkkkk");
				int ono = rs.getInt(1);
				String gname = rs.getString(2);
				int amt = rs.getInt(3);
				int mno = rs.getInt(4);
				String mname = rs.getString(5);
				int price = rs.getInt(6);
				String odate = rs.getString(7);
				adminOrder amindorder = new adminOrder(ono,gname,amt,mno,mname,price,odate);
				list.add(amindorder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args){
		adminOrderDAO dao = new adminOrderDAO();
		ArrayList<adminOrder> list = (ArrayList<adminOrder>)dao.getAdminOrderList();
		System.out.println(list);
		
	}
	
	
	
}
