package com.lanou.service;

import java.util.List;

import com.lanou.bean.Type;
import com.lanou.dao.ITypeDao;
import com.lanou.dao.TypeDaoImpl;

public class TypeServiceImpl implements ITypeService{

	private ITypeDao itDao = new TypeDaoImpl();
	@Override
	public List<Type> getAll() throws Exception{
		List<Type> list1 = itDao.getByParentIdAndLevel(0);
		for(Type type : list1) {
			List<Type> list2 = itDao.getByParentIdAndLevel(type.getId());
			type.setChildren(list2);
			for(Type t : list2) {
				List<Type> list3 = itDao.getByParentIdAndLevel(t.getId());
				t.setChildren(list3);
			}
		}
		return list1;
	}

	@Override
	public void AddType(String title, int parentid) throws Exception {
		
		itDao.AddType(title, parentid);
	}

	@Override
	public void editType(int id, String title) throws Exception {
		
		itDao.editType(id, title);
	}

	@Override
	public void delType(int id) throws Exception {
		
		itDao.delType(id);
	}

	@Override
	public Type getType(int typeid) throws Exception {
		
		return itDao.getType(typeid);
	}

	@Override
	public List<Type> getFirstList() throws Exception {
		
		return itDao.getFirstList();
	}

	@Override
	public List<Type> getSecondList(String parentid) throws Exception {
		
		return itDao.getSecondList(parentid);
	}

	@Override
	public List<Type> getThirdList(String parentid) throws Exception {
		
		return itDao.getThirdList(parentid);
	}

	@Override
	public int getTypeid(String title) throws Exception {
		
		return itDao.getTypeid(title);
	}

	
}
