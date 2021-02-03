package com.lanou.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.Type;
import com.lanou.util.JDBCUtil;

public class TypeDaoImpl implements ITypeDao{

	@Override
	public List<Type> getByParentIdAndLevel(int parentid) throws Exception {
		List<Type> typelist = new ArrayList<Type>();
		String sql = "select * from pro_type where parentid=?";
		Object[] os = {parentid};
		ResultSet rs = JDBCUtil.queryUtil(sql, os);
		while(rs.next()) {
			int id = rs.getInt("id");
			String typename = rs.getString("typename");
			Type type = new Type(id, typename, parentid, null);
			typelist.add(type);
		}
		return typelist;
	}

	@Override
	public void AddType(String title, int parentid) throws Exception {
		String sql = "insert into pro_type(typename,parentid) values ('"+title+"',"+parentid+")";
		JDBCUtil.ZengShanGai(sql);
	}

	@Override
	public void editType(int id, String title) throws Exception {
		String sql = "update pro_type set typename='"+title+"' where id="+id;
		JDBCUtil.ZengShanGai(sql);
	}

	@Override
	public void delType(int id) throws Exception {
		String sql = "delete from pro_type where id="+id;
		JDBCUtil.ZengShanGai(sql);
	}

	@Override
	public Type getType(int typeid) throws Exception {
		String sql="select * from pro_type where id="+typeid+"";
		ResultSet rs=JDBCUtil.queryUtil(sql, null);
		while(rs.next()) {
			Integer id=rs.getInt("id");
			String typename = rs.getString("typename");
			Integer parentid=rs.getInt("parentid");
			Type type = new Type(id, typename, parentid);
			return type;
		}
		return null;
	}

	@Override
	public List<Type> getFirstList() throws Exception {
		String sql="select * from pro_type where parentid=0";
		ResultSet re=JDBCUtil.queryUtil(sql, null);
		List<Type> typelist1=new ArrayList<>();
		while(re.next()) {
			Integer id=re.getInt("id");
			String typename=re.getString("typename");
			Integer parentid=re.getInt("parentid");
			Type type=new Type(id, typename, parentid);
			typelist1.add(type);
		}
		return typelist1;
	}

	@Override
	public List<Type> getSecondList(String parentid) throws Exception {
		String sql="select * from pro_type where parentid='"+parentid+"'";
		ResultSet re=JDBCUtil.queryUtil(sql, null);
		List<Type> typelist2=new ArrayList<>();
		while(re.next()) {
			Integer id=re.getInt("id");
			String typename=re.getString("typename");
			Type type=new Type(id, typename, Integer.parseInt(parentid));
			typelist2.add(type);
		}
		return typelist2;
	}

	@Override
	public List<Type> getThirdList(String parentid) throws Exception {
		String sql="select * from pro_type where parentid='"+parentid+"'";
		ResultSet re=JDBCUtil.queryUtil(sql, null);
		List<Type> typelist3=new ArrayList<>();
		while(re.next()) {
			Integer id=re.getInt("id");
			String typename=re.getString("typename");
			Type type=new Type(id, typename, Integer.parseInt(parentid));
			typelist3.add(type);
		}
		return typelist3;
	}

	@Override
	public int getTypeid(String title) throws Exception {
		String sql="select * from pro_type where typename='"+title+"'";
		ResultSet re=JDBCUtil.queryUtil(sql, null);
		if(re.next()) {
			Integer id=re.getInt("id");
			return id;
		}
		return 0;
	}

}
