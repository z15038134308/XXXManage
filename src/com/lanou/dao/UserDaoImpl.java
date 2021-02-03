package com.lanou.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.Admin;
import com.lanou.bean.User;
import com.lanou.util.JDBCUtil;

public class UserDaoImpl implements IUserDao{

	@Override
	public User UserqueryAll() throws Exception {
		String sql = "select * form t_user";
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String pwd = rs.getString("pwd");
			String phone = rs.getString("phone");
			String mail = rs.getString("mail");
			String address = rs.getString("address");
			User user = new User(id, name, pwd, phone, mail, address, null, null, null);
			return user;
		}
		return null;
	}

	@Override
	public List<User> getByPage(int pagenum, int pagecount) throws Exception {
		List<User> userlist = new ArrayList<User>();
		String sql = "select * from t_user limit "+(pagenum-1)*pagecount+","+pagecount;
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String pwd = rs.getString("pwd");
			String phone = rs.getString("phone");
			String mail = rs.getString("mail");
			String address = rs.getString("address");
			User user = new User(id, name, pwd, phone, mail, address, null, null, null);
			userlist.add(user);
		}
		return userlist;
	}

	@Override
	public int getCount() throws Exception {
		String sql = "select count(*) count from t_user";
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		if(rs.next()) {
			Integer count = rs.getInt("count");
			return count;
		}
		return 0;
	}

	@Override
	public void addUser(String name, String pwd, String phone, String mail, String address)
			throws Exception {
		String sql = "insert into t_user (name,pwd,phone,mail,address) values ('"+name+"','"+pwd+"','"+phone+"','"+mail+"','"+address+"')";
		JDBCUtil.ZengShanGai(sql);
	}

	@Override
	public void editUser(String id, String name, String pwd, String phone, String mail, String address)
			throws Exception {
		String sql = "update t_user set name='"+name+"',pwd='"+pwd+"',phone='"+phone+"',mail='"+mail+"',address='"+address+"' where id="+id;
		JDBCUtil.ZengShanGai(sql);
	}

	@Override
	public void delUser(String id) throws Exception {
		String sql = "delete from t_user where id="+id;
		JDBCUtil.ZengShanGai(sql);
	}

	@Override
	public User UserLogin(String name, String pwd) throws Exception {
		String sql = "select * from t_user where name = ? and pwd = ?";
		Object[] os = {name, pwd};
		ResultSet rs = JDBCUtil.queryUtil(sql, os);
		if(rs.next()) {
			int id = rs.getInt("id");
			String phone = rs.getString("phone");
			String mail = rs.getString("mail");
			String address = rs.getString("address");
			User user = new User(id, name, pwd, phone, mail, address, null, null, null);
			return user;
		}
		return null;
	}

	@Override
	public User getuserByNameAndPwd(String name, String pwd) throws Exception {
		String sql = "select * from account where name=? and pwd = ?";
		Object[] os = {name,pwd};

		User user = null;
		
		ResultSet rs = JDBCUtil.queryUtil(sql, os);
		if(rs.next()){
			int id = rs.getInt("id");
			
			user = new User(id, name,pwd);
		}
		rs.close();
		
		return user;
	}

}
