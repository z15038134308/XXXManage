package com.lanou.dao;

import java.util.List;

import com.lanou.bean.User;

public interface IUserDao {

	public User getuserByNameAndPwd(String name,String pwd) throws Exception;
	
	public User UserLogin(String name,String pwd) throws Exception;
	
	public User UserqueryAll() throws Exception;
	
	public List<User> getByPage(int pagenum,int pagecount) throws Exception;
	
	public int getCount() throws Exception;
	
	public void addUser(String name,String pwd,String phone,String mail,String address) throws Exception;
	
	public void editUser(String id,String name,String pwd,String phone,String mail,String address) throws Exception;
	
	public void delUser(String id) throws Exception;
}
