package com.lanou.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.Product;
import com.lanou.bean.Type;
import com.lanou.util.JDBCUtil;

public class ProductDaoImpl implements IProductDao{

	private ITypeDao itDao = new TypeDaoImpl();
	@Override
	public List<Product> getAll() throws Exception {
		List<Product> prolist = new ArrayList<>();
		String sql = "select * from t_product";
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String pname = rs.getString("pname");
			String pimg = rs.getString("pimg");
			Double price = rs.getDouble("price");
			String ptitle = rs.getString("ptitle");
			int pv = rs.getInt("pv");
			String typeid = rs.getString("typeid");
			Type type3 = itDao.getType(Integer.parseInt(typeid));
			Type type2 = itDao.getType(type3.getParentid());
			Type type1 = itDao.getType(type2.getParentid());
			String typeidname = type1.getTitle()+">"+type2.getTitle()+">"+type3.getTitle();
			Product product = new Product(id, pname, pimg, price, ptitle, pv, typeidname);
			prolist.add(product);
		}
		return prolist;
	}

	@Override
	public List<Product> getByPage(int pagenum, int pagecount) throws Exception {
		List<Product> prolist = new ArrayList<Product>();
		String sql = "select * from t_product limit "+(pagenum-1)*pagecount+","+pagecount;
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		while(rs.next()) {
			int id = rs.getInt("id");
			String pname = rs.getString("pname");
			String pimg = rs.getString("pimg");
			Double price = rs.getDouble("price");
			String ptitle = rs.getString("ptitle");
			int pv = rs.getInt("pv");
			String typeid = rs.getString("typeid");
			
			Type type3 = itDao.getType(Integer.parseInt(typeid));
			Type type2 = itDao.getType(type3.getParentid());
			Type type1 = itDao.getType(type2.getParentid());
			String typeidname = type1.getTitle()+">"+type2.getTitle()+">"+type3.getTitle();
			Product product = new Product(id, pname, pimg, price, ptitle, pv, typeidname);
			prolist.add(product);
		}
		return prolist;
	}

	@Override
	public int getCount() throws Exception {
		String sql = "select count(*) count from t_product";
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		if(rs.next()) {
			Integer count = rs.getInt("count");
			return count;
		}
		return 0;
	}

	@Override
	public void addProduct(String pname, String pimg, String price, String ptitle, String pv, String typeidname)
			throws Exception {
		String sql = "insert into t_product (pname,pimg,price,ptitle,pv,typeid) values ('"+pname+"','"+pimg+"','"+price+"','"+ptitle+"','"+pv+"','"+typeidname+"')";
		JDBCUtil.ZengShanGai(sql);
	}

	@Override
	public void editProduct(String id, String pname, String pimg, String price, String ptitle, String pv, String typeid)
			throws Exception {
		String sql = "update t_product set pname='"+pname+"',pimg='"+pimg+"',price='"+price+"',ptitle='"+ptitle+"',pv='"+pv+"',typeid='"+typeid+"' where id="+id;
		JDBCUtil.ZengShanGai(sql);
	}

	@Override
	public void delProduct(String id) throws Exception {
		String sql = "delete from t_product where id="+id;
		JDBCUtil.ZengShanGai(sql);
	}

	@Override
	public List<Product> getAllByTypeid(String id) throws Exception {
		List<Product> prolist = new ArrayList<Product>();
		String sql = "select * from t_product where typeid="+id;
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		while(rs.next()) {
			String pname = rs.getString("pname");
			String pimg = rs.getString("pimg");
			Double price = rs.getDouble("price");
			String ptitle = rs.getString("ptitle");
			int pv = rs.getInt("pv");
			String typeid = rs.getString("typeid");
			
			Type type3 = itDao.getType(Integer.parseInt(typeid));
			Type type2 = itDao.getType(type3.getParentid());
			Type type1 = itDao.getType(type2.getParentid());
			String typeidname = type1.getTitle()+">"+type2.getTitle()+">"+type3.getTitle();
			Product product = new Product(pname, pimg, price, ptitle, pv, typeidname);
			prolist.add(product);
		}
		return prolist;
	}

	@Override
	public List<Product> queryByProname(String proname) throws Exception {
		List<Product> productlist = new ArrayList<Product>();
		String sql = "select * from t_product where pname like '%"+proname+"%'";
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		while(rs.next()) {
			int id = rs.getInt("id");
			String pname = rs.getString("pname");
			String pimg = rs.getString("pimg");
			Double price = rs.getDouble("price");
			String ptitle = rs.getString("ptitle");
			int pv = rs.getInt("pv");
			int typeid = rs.getInt("typeid");
			Product product = new Product(id, pname, pimg, price, ptitle, pv, typeid);
			productlist.add(product);
		}
		return productlist;
	}

	@Override
	public List<Product> getAllById(String id) throws Exception {
		List<Product> prolist = new ArrayList<Product>();
		String sql = "select * from t_product where id=?";
		Object[] os = {id};
		ResultSet rs = JDBCUtil.queryUtil(sql, os);
		while(rs.next()) {
			String pname = rs.getString("pname");
			String pimg = rs.getString("pimg");
			Double price = rs.getDouble("price");
			String ptitle = rs.getString("ptitle");
			int pv = rs.getInt("pv");
			int typeid = rs.getInt("typeid");
			
			Product product = new Product(Integer.parseInt(id), pname, pimg, price, ptitle, pv, typeid);
			prolist.add(product);
		}
		return prolist;
	}

}
