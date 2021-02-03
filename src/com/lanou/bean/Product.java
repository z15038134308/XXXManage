package com.lanou.bean;

public class Product {

	private Integer id;
	
	private String pname;
	
	private String pimg;
	
	private Double price;
	
	private String ptitle;
	
	private Integer pv;
	
	private String typeidname;
	
	private Integer typeid;
	
	public Product() {
		super();
	}

	public Product(Integer id, String pname, String pimg, Double price, String ptitle, Integer pv, String typeidname) {
		super();
		this.id = id;
		this.pname = pname;
		this.pimg = pimg;
		this.price = price;
		this.ptitle = ptitle;
		this.pv = pv;
		this.typeidname = typeidname;
	}

	
	public Product(String pname, String pimg, Double price, String ptitle, Integer pv, String typeidname) {
		super();
		this.pname = pname;
		this.pimg = pimg;
		this.price = price;
		this.ptitle = ptitle;
		this.pv = pv;
		this.typeidname = typeidname;
	}

	public Product(int id, String pname, String pimg, Double price, String ptitle, int pv, int typeid) {
		this.id = id;
		this.pname = pname;
		this.pimg = pimg;
		this.price = price;
		this.ptitle = ptitle;
		this.pv = pv;
		this.typeid = typeid;
	}

	public Product(String pname, String pimg, Double price) {
		this.pname = pname;
		this.pimg = pimg;
		this.price = price;
	}

	public String getPname() {
		return pname;
	}



	public void setPname(String pname) {
		this.pname = pname;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPimg() {
		return pimg;
	}

	public void setPimg(String pimg) {
		this.pimg = pimg;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public Integer getPv() {
		return pv;
	}

	public void setPv(Integer pv) {
		this.pv = pv;
	}

	public String getTypeidname() {
		return typeidname;
	}

	public void setTypeidname(String typeidname) {
		this.typeidname = typeidname;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	
}
	
