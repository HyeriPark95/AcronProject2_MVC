package model.dao;

public class adminOrder {
	int ono;
	String gname;
	int amt;
	int mno;
	String mname;
	int price;
	String date;
	
	public adminOrder(){};
	public adminOrder(int ono, String gname, int amt, int mno, String mname,
			int price, String date) {
		super();
		this.ono = ono;
		this.gname = gname;
		this.amt = amt;
		this.mno = mno;
		this.mname = mname;
		this.price = price;
		this.date = date;
	}
	public int getOno() {
		return ono;
	}
	public void setOno(int ono) {
		this.ono = ono;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	@Override
	public String toString() {
		return "adminOrder [ono=" + ono + ", gname=" + gname + ", amt=" + amt
				+ ", mno=" + mno + ", mname=" + mname + ", price=" + price
				+ ", date=" + date + "]";
	}
	
	
	
	
	
}
