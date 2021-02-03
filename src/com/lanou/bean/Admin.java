package com.lanou.bean;

public class Admin {

	private Integer id;
	
	private String adminname;
	
	private String adminpwd;
	
	private String backup1;
	
	private String backup2;
	
	private String backup3;
	

	public Admin() {
		super();
	}

	public Admin(Integer id, String adminname, String adminpwd, String backup1, String backup2, String backup3) {
		super();
		this.id = id;
		this.adminname = adminname;
		this.adminpwd = adminpwd;
		this.backup1 = backup1;
		this.backup2 = backup2;
		this.backup3 = backup3;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminpwd() {
		return adminpwd;
	}

	public void setAdminpwd(String adminpwd) {
		this.adminpwd = adminpwd;
	}

	public String getBackup1() {
		return backup1;
	}

	public void setBackup1(String backup1) {
		this.backup1 = backup1;
	}

	public String getBackup2() {
		return backup2;
	}

	public void setBackup2(String backup2) {
		this.backup2 = backup2;
	}

	public String getBackup3() {
		return backup3;
	}

	public void setBackup3(String backup3) {
		this.backup3 = backup3;
	}
	
	
}
