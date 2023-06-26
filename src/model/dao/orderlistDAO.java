package model.dao;
import java.sql.*;
import java.util.ArrayList;
public class orderlistDAO {
		
		  String driver = "oracle.jdbc.driver.OracleDriver" ;
		  String url="jdbc:oracle:thin:@localhost:1521:xe";
		  String user="system";
		  String password="1234";	 
		  Connection con;	
		

		private void dbcon(){
			
			try {
				Class.forName(driver);
				con=DriverManager.getConnection(url, user, password);
				if( con != null) System.out.println("ok");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
}
		
		public  ArrayList<Orderlist> getOrderlist(String id){
			dbcon();
			
			
			String sql = " select g.img, g.gname, g.price, g.color, o.odate, oi.amt from tbl_goods g join order_item oi on g.GNO=oi.GNO join tbl_order o on o.ONO=oi.ONO ";
			sql += " join TBL_MEMBER M on m.mno =o.mno where M.id=? ";
			
			ArrayList<Orderlist> members = new ArrayList<>();
			
			
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, id);
				ResultSet rs = pst.executeQuery();
				
				
				while(rs.next()){
					String img = rs.getString(1);
					String gname = rs.getString(2);
					int price = rs.getInt(3);
					String color = rs.getString(4);			
					String odate = rs.getString(5);
					int amt = rs.getInt(6);
					Orderlist order = new Orderlist(img,gname,price,color,odate,amt);
					members.add(order);
					
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return members;
			
		}
		
		
		
		
		
		
		
}