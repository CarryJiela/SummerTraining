package com.erpang.dao;

import java.util.List;

import com.erpang.vo.Record;

public interface IFinishedRecDao {
	/**
	 * @param Record rec1,Record rec2 两个record对象，这两个对象都已经在record数据库中被删除了，将两个的信息统一到新的数据库finishedrec中
	 * 且这个数据库中的信息需要全部填写完成。
	 * @return 返回是否成功添加的信息
	 * @throws Exception 有异常交给调用方
	 * */
	public boolean Increase(Record rec1,Record rec2) throws Exception;
	/**
	 * @param uno 用户的学号，通过学号找到该用户以往所有的借用记录。
	 * @return 返回借用记录的列表
	 * @throws Exception 有异常交给调用方
	 * */
	public List<Record> getAllRecord(String uno) throws Exception;
}
