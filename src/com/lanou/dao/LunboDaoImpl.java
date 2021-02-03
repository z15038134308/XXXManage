package com.lanou.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.Admin;
import com.lanou.bean.Lunbo;
import com.lanou.util.JDBCUtil;

public class LunboDaoImpl implements ILunboDao{

	@Override
	public List<Lunbo> getAll() throws Exception {
		List<Lunbo> list = new ArrayList<Lunbo>();
		String sql = "select * from t_carousel";
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		while(rs.next()) {
			int id = rs.getInt("id");
			String timg = rs.getString("timg");
			Lunbo lunbo = new Lunbo(id, timg);
			list.add(lunbo);
		}
		return list;
	}


	@Override
	public void AddLunbo(String timg) throws Exception {
		String sql = "insert into t_carousel(timg) values ('"+timg+"')";
		JDBCUtil.ZengShanGai(sql);
	}

	@Override
	public void EditLunbo(String id, String timg) throws Exception {
		String sql = "update t_carousel set timg='"+timg+"' where id="+id;
		JDBCUtil.ZengShanGai(sql);
	}

	@Override
	public void DelLunbo(String id) throws Exception {
		String sql = "delete from t_carousel where id="+id;
		JDBCUtil.ZengShanGai(sql);
	}

	
	

}
