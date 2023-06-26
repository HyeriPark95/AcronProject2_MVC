package model.dao;

public class GoodsSearch {
	String gno;
	String img;
	String gname;
	int price;
	String color;
	int qty;
	
	//getter , setter
	public String getGno() {
		return gno;
	}
	public void setGno(String gno) {
		this.gno = gno;
	}
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
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	//생성자
	public GoodsSearch(){}
	public GoodsSearch(String gno, String img, String gname, int price, String color,
			int qty) {
		super();
		this.gno = gno;
		this.img = img;
		this.gname = gname;
		this.price = price;
		this.color = color;
		this.qty = qty;
	}
	
	
	
	@Override
	public String toString() {
		return "Goods [gno=" + gno + ", gname=" + gname
				+ ", price=" + price + ", color=" + color + ", qty=" + qty
				+ "]";
	}
	

	
	
}
