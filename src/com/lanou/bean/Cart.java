package com.lanou.bean;

import java.io.Serializable;

public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer userid;
	
	private Integer productid;
	
	private String uname;
	
	private String pname;
	
	private String phone;
	
	private Double price;
	
	public Cart() {
		super();
	}
	
	public Cart(Integer id, Integer userid, Integer productid,String uname, String pname, String phone, Double price) {
		super();
		this.id = id;
		this.userid = userid;
		this.productid = productid;
		this.uname = uname;
		this.pname = pname;
		this.phone = phone;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

}
