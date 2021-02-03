package com.lanou.service;

import java.util.List;

import com.lanou.bean.Admin;
import com.lanou.dao.AdminDaoImpl;
import com.lanou.dao.IAdminDao;

public class AdminServiceImpl implements IAdminService{

	private IAdminDao iaDao = new AdminDaoImpl();
	
	public Admin AdminLogin(String adminname,String adminpwd) throws Exception{
	
		return iaDao.AdminLogin(adminname, adminpwd);
	}

	@Override
	public List<Admin> getByPage(int pagenum, int pagecount) throws Exception {
		
		return iaDao.getByPage(pagenum, pagecount);
	}

	@Override
	public int getCount() throws Exception {
		
		return iaDao.getCount();
	}

	@Override
	public void delById(String id) throws Exception {
		
		iaDao.delById(id);
	}

	@Override
	public void addAdmin(String adminname, String adminpwd) throws Exception {
		
		iaDao.addAdmin(adminname, adminpwd);
	}

	@Override
	public void editAdmin(String id, String adminname, String adminpwd) throws Exception {
		
		iaDao.editAdmin(id, adminname, adminpwd);
	}
}
