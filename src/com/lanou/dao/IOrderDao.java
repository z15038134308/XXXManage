package com.lanou.dao;

import java.util.List;

import com.lanou.bean.Order;

public interface IOrderDao {

	public List<Order> getAll() throws Exception;
	
	public void delById() throws Exception;
}
