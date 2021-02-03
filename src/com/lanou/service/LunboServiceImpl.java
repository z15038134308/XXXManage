package com.lanou.service;

import java.util.List;

import com.lanou.bean.Lunbo;
import com.lanou.dao.ILunboDao;
import com.lanou.dao.LunboDaoImpl;

public class LunboServiceImpl implements ILunboService{

	private ILunboDao ilDao = new LunboDaoImpl();

	@Override
	public List<Lunbo> getAll() throws Exception {
		
		return ilDao.getAll();
	}

	@Override
	public void AddLunbo(String timg) throws Exception {
		
		ilDao.AddLunbo(timg);
	}

	@Override
	public void EditLunbo(String id, String timg) throws Exception {
		
		ilDao.EditLunbo(id, timg);
	}

	@Override
	public void DelLunbo(String id) throws Exception {
		
		ilDao.DelLunbo(id);
	}

}
