package model.dao;

public class Orderlist {
	String img;
	String gname;
	int price;
	String color;
	String odate;
	int amt;
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	@Override
	public String toString() {
		return "Orderlist [img=" + img + ", gname=" + gname + ", price="
				+ price + ", color=" + color + ", odate=" + odate + ", amt="
				+ amt + "]";
	}
	public Orderlist(){};
	public Orderlist(String img, String gname, int price, String color,
			String odate, int amt) {
		super();
		this.img = img;
		this.gname = gname;
		this.price = price;
		this.color = color;
		this.odate = odate;
		this.amt = amt;
	}
	

}