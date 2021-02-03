package com.lanou.util;

public class JSONbean {

	private String code;
	private String msg;
	private Integer count;
	private Object data;
	
	
	public JSONbean() {
		
	}
	public JSONbean(String code, String msg, Integer count, Object data) {
		
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}
