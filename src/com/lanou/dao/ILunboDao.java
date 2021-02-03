package com.lanou.dao;

import java.util.List;

import com.lanou.bean.Admin;
import com.lanou.bean.Lunbo;

public interface ILunboDao {

	public List<Lunbo> getAll() throws Exception;
	
	public void AddLunbo(String timg) throws Exception;
	
	public void EditLunbo(String id,String timg) throws Exception;
	
	public void DelLunbo(String id) throws Exception;
	
}
