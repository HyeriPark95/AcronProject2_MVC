package model.dao;

public class Member_minju {
	int mno;
	String mname;
	String id;
	String pw;
	String tel;
	int point;
	String grade;
	String addr;
	public int getMno() {
		return mno;
	}
	public String getMname() {
		return mname;
	}
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public String getTel() {
		return tel;
	}
	public int getPoint() {
		return point;
	}
	public String getGrade() {
		return grade;
	}
	public String getAddr() {
		return addr;
	}
	public Member_minju(int mno, String mname, String id, String pw, String tel,
			int point, String grade, String addr) {
		this.mno = mno;
		this.mname = mname;
		this.id = id;
		this.pw = pw;
		this.tel = tel;
		this.point = point;
		this.grade = grade;
		this.addr = addr;
	}
	
	public Member_minju(String mname, String id, String pw, String tel, String addr) {
		this.mname = mname;
		this.id = id;
		this.pw = pw;
		this.tel = tel;
		this.addr = addr;
	}
	public Member_minju() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Member [mno=" + mno + ", mname=" + mname + ", id=" + id
				+ ", pw=" + pw + ", tel=" + tel + ", point=" + point
				+ ", grade=" + grade + ", addr=" + addr + "]";
	}

	
	
}
