package com.lanou.bean;

public class Order {

	private int id;
	
	private int userid;
	
	private int productid;
	
	private int status;

	public Order() {
		super();
	}

	public Order(int id, int userid, int productid, int status) {
		super();
		this.id = id;
		this.userid = userid;
		this.productid = productid;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
