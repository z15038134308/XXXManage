package com.lanou.service;

import java.util.List;

import com.lanou.bean.Product;

public interface IProductService {

	public List<Product> getAll() throws Exception;
	
	public List<Product> getByPage(int pagenum,int pagecount) throws Exception;
	
	public List<Product> queryByProname(String proname) throws Exception;
	
	public int getCount() throws Exception;
	
	public void addProduct(String pname,String pimg,String price,String ptitle,String pv,String typeidname) throws Exception;
	
	public void editProduct(String id,String pname,String pimg,String price,String ptitle,String pv,String typeid) throws Exception;
	
	public void delProduct(String id) throws Exception;
	
	public List<Product> getAllByTypeid(String id) throws Exception;
	
	public List<Product> getAllById(String id) throws Exception;
}
