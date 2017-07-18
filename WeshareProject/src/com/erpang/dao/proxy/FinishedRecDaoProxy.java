package com.erpang.dao.proxy;

import java.util.List;

import com.erpang.dao.IFinishedRecDao;
import com.erpang.dao.impl.FinishedRecDaoImpl;
import com.erpang.vo.Finished;
import com.erpang.vo.Record;

import edu.nuaa.vo.Emp;

import com.erpang.dbc.DataBaseConnection;

public class FinishedRecDaoProxy implements IFinishedRecDao{

	private DataBaseConnection dbc = null;
	private IFinishedRecDao dao = null;
	
	public FinishedRecDaoProxy() throws Exception{
		this.dbc = new DataBaseConnection();
		this.dao = new FinishedRecDaoImpl(this.dbc.getConnection());
	}
	
	@Override
	public boolean Increase(Record rec1, Record rec2) throws Exception {
		boolean flag = false;
		
		try{
				flag = dao.Increase(rec1, rec2);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.closeConnection();
		}
		return flag;
	}

	@Override
	public List<Finished> getAllRecord(String uno) throws Exception {
		List<Finished> all = null;
		try {
			all = this.dao.getAllRecord(uno);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.closeConnection();
		}
		return all;
	}

}
