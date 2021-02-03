package com.lanou.service;

import java.util.List;

import com.lanou.bean.User;
import com.lanou.dao.IUserDao;
import com.lanou.dao.UserDaoImpl;

public class UserServiceImpl implements IUserService{

	IUserDao iuDao = new UserDaoImpl();
	@Override
	public User UserqueryAll() throws Exception {
	
		return iuDao.UserqueryAll();
	}

	@Override
	public List<User> getByPage(int pagenum, int pagecount) throws Exception {
		
		return iuDao.getByPage(pagenum, pagecount);
	}

	@Override
	public int getCount() throws Exception {
		
		return iuDao.getCount();
	}

	@Override
	public void addUser(String name, String pwd, String phone, String mail, String address) throws Exception {
		
		iuDao.addUser(name, pwd, phone, mail, address);
	}

	@Override
	public void editUser(String id, String name, String pwd, String phone, String mail, String address)
			throws Exception {
		
		iuDao.editUser(id, name, pwd, phone, mail, address);
	}

	@Override
	public void delUser(String id) throws Exception {
		
		iuDao.delUser(id);
	}

	@Override
	public User UserLogin(String name, String pwd) throws Exception {
		
		return iuDao.UserLogin(name, pwd);
	}

}
