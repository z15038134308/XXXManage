package com.lanou.service;

import java.util.List;

import com.lanou.bean.Type;

public interface ITypeService {

	public List<Type> getAll() throws Exception;
	
	public void AddType(String title,int parentid) throws Exception;
	
	public void editType(int id,String title) throws Exception;
	
	public void delType(int id) throws Exception;
	
	public Type getType(int typeid)throws Exception;
	
	public List<Type> getFirstList( )throws Exception;
	
	public List<Type> getSecondList(String parentid )throws Exception;
	
	public List<Type> getThirdList(String parentid )throws Exception;
	
	public int getTypeid(String title)throws Exception;
	
}
