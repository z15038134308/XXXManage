package com.lanou.dao;

import java.util.List;

import com.lanou.bean.Cart;

public interface ICartDao {

	public List<Cart> queryByPage(Integer pagenum, Integer pagecount) throws Exception;
	
	public Integer queryCount() throws Exception;
	
	public void deleteById(Integer id) throws Exception; 
	
	public List<Cart> queryAll() throws Exception;
	
	public void add(Integer userid, Integer productid) throws Exception;
		
}
