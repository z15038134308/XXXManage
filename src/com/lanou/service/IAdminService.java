package com.lanou.service;

import java.util.List;

import com.lanou.bean.Admin;

public interface IAdminService {

	public Admin AdminLogin(String adminname,String adminpwd) throws Exception;
	
	public List<Admin> getByPage(int pagenum,int pagecount) throws Exception;
	
	public int getCount() throws Exception;
	
	public void delById(String id) throws Exception;
	
	public void addAdmin(String adminname,String adminpwd) throws Exception;
	
	public void editAdmin(String id,String adminname,String adminpwd) throws Exception;
}
