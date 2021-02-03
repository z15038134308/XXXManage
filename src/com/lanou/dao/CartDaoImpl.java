package com.lanou.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.Cart;
import com.lanou.util.JDBCUtil;

public class CartDaoImpl implements ICartDao{

	@Override
	public List<Cart> queryByPage(Integer pagenum, Integer pagecount) throws Exception {
		List<Cart> cartlist = new ArrayList<Cart>();
		
		String sql = "select "
				  +" tc.id id,tu.id userid,tp.id productid,tu.name uname,tu.phone phone,tp.pname pname,tp.price price "
				  +" from t_cart tc left join t_user tu on tc.userid=tu.id "
				        +" left join t_product tp on tc.productid=tp.id limit "+(pagenum-1)*pagecount+","+pagecount;
		
		
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		while(rs.next()) {
			int id = rs.getInt("id");
			int userid = rs.getInt("userid");
			int productid = rs.getInt("productid");
			String uname = rs.getString("uname");
			String pname = rs.getString("pname");
			String phone = rs.getString("phone");
			double price = rs.getDouble("price");
			Cart cart = new Cart(id, userid, productid, uname, pname, phone, price);
			cartlist.add(cart);
		}
		return cartlist;
	}

	@Override
	public Integer queryCount() throws Exception {
		String sql = "select count(id) from t_cart";
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		if(rs.next()) {
			int cartcount = rs.getInt("count(id)");
			return cartcount;
		}
		return 0;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		String sql = "delete from t_cart where id ="+id;
		JDBCUtil.ZengShanGai(sql);
		
	}

	@Override
	public List<Cart> queryAll() throws Exception {
		List<Cart> cartlist = new ArrayList<Cart>();
		
		String sql = "select "
				  +" tc.id id,tu.id userid,tp.id productid,tu.name uname,tu.phone phone,tp.pname pname,tp.price price "
				  +" from t_cart tc left join t_user tu on tc.userid=tu.id "
				        +" left join t_product tp on tc.productid=tp.id ";
		
		
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		while(rs.next()) {
			int id = rs.getInt("id");
			int userid = rs.getInt("userid");
			int productid = rs.getInt("productid");
			String uname = rs.getString("uname");
			String pname = rs.getString("pname");
			String phone = rs.getString("phone");
			double price = rs.getDouble("price");
			Cart cart = new Cart(id, userid, productid, uname, pname, phone, price);
			cartlist.add(cart);
		}
		return cartlist;
	}

	@Override
	public void add(Integer userid, Integer productid) throws Exception {
		String sql = "insert into t_cart(userid, productid) values("+userid+", "+productid+")";
		JDBCUtil.ZengShanGai(sql);
		
	}

}
