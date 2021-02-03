package com.lanou.service;

import java.util.List;

import com.lanou.bean.Lunbo;

public interface ILunboService {
	
	public List<Lunbo> getAll() throws Exception;
	
	public void AddLunbo(String timg) throws Exception;
	
	public void EditLunbo(String id,String timg) throws Exception;
	
	public void DelLunbo(String id) throws Exception;
		
}
