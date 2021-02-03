package com.lanou.bean;

import java.io.Serializable;

public class Lunbo implements Serializable{
	private Integer id;
	private String timg;

	public Lunbo() {
		super();
	}

	public Lunbo(String timg) {
		super();
		this.timg = timg;
	}
	
	public Lunbo(Integer id, String timg) {
		super();
		this.id = id;
		this.timg = timg;
	}

	public String getTimg() {
		return timg;
	}

	public void setTimg(String timg) {
		this.timg = timg;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
