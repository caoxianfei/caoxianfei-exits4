package com.caoxianfei.exits4.bean;

public class Coupon {

	private Integer cid;
	
	private String cname;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Coupon(Integer cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}

	public Coupon() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Coupon [cid=" + cid + ", cname=" + cname + "]";
	}
	
	
	
}
