package com.lanou.service;

import java.util.List;

import com.lanou.bean.Product;
import com.lanou.dao.IProductDao;
import com.lanou.dao.ITypeDao;
import com.lanou.dao.ProductDaoImpl;
import com.lanou.dao.TypeDaoImpl;

public class ProductServiceImpl implements IProductService{

	private IProductDao ipDao = new ProductDaoImpl();
	private ITypeDao itDao=new TypeDaoImpl();
	@Override
	public List<Product> getAll() throws Exception {
		
		return ipDao.getAll();
	}

	@Override
	public List<Product> getByPage(int pagenum, int pagecount) throws Exception {
		
		return ipDao.getByPage(pagenum, pagecount);
	}

	@Override
	public int getCount() throws Exception {
		
		return ipDao.getCount();
	}

	@Override
	public void addProduct(String pname, String pimg, String price, String ptitle, String pv, String typeidname)
			throws Exception {
		
		ipDao.addProduct(pname, pimg, price, ptitle, pv, typeidname);
	}

	@Override
	public void editProduct(String id, String pname, String pimg, String price, String ptitle, String pv, String typeid)
			throws Exception {
		
		ipDao.editProduct(id, pname, pimg, price, ptitle, pv, typeid);
	}

	@Override
	public void delProduct(String id) throws Exception {
		
		ipDao.delProduct(id);
	}

	@Override
	public List<Product> getAllByTypeid(String id) throws Exception {
		
		return ipDao.getAllByTypeid(id);
	}

	@Override
	public List<Product> queryByProname(String proname) throws Exception {
		
		return ipDao.queryByProname(proname);
	}

	@Override
	public List<Product> getAllById(String id) throws Exception {
		
		return ipDao.getAllById(id);
	}

}
