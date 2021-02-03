package com.lanou.service;

import java.util.List;

import com.lanou.bean.Cart;
import com.lanou.dao.CartDaoImpl;
import com.lanou.dao.ICartDao;

public class CartServiceImpl implements ICartService{

	ICartDao icDao = new CartDaoImpl();
	@Override
	public List<Cart> queryByPage(Integer pagenum, Integer pagecount) throws Exception {
		
		return icDao.queryByPage(pagenum, pagecount);
	}

	@Override
	public Integer queryCount() throws Exception {
		
		return icDao.queryCount();
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		
		icDao.deleteById(id);
	}

	@Override
	public List<Cart> queryAll() throws Exception {
		
		return icDao.queryAll();
	}

	@Override
	public void add(Integer userid, Integer productid) throws Exception {
		
		icDao.add(userid, productid);
	}

}
