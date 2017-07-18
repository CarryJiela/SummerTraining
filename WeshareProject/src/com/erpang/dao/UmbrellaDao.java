package com.erpang.dao;

import java.util.List;

import com.erpang.vo.Record;

public interface UmbrellaDao {
	/**
	 * @param 填入的是發起人的信息，存入數據庫會存入的信息有：發起人的學號，發起人的起點，終點，日期，信息發起的时间，最晚结束的时间以及备注，最后要存入数据库
	 * @return 返回是否成功添加的信息
	 * @throws Exception 有異常交給調用方
	 * */
	public boolean Increase(Record rec)throws Exception;
	/**
	 * @param 唯一的學號，通過學號找到有傘人值錢在表單中填入數據庫的信息
	 * @return 返回有傘人值錢在表單中填入數據庫的信息
	 * @throws Exception 有異常交給調用方
	 * */
	public Record getRecordWithUmbrellaByUno(String uno) throws Exception;
	/**
	 * @param 获取整个数据库中的记录，用于随后的Lcs算法计算
	 * @return 一个record列表。
	 * @throws Exception 有异常交给调用方
	 * */
	public List<Record> getAllRecords() throws Exception;
	/**
	 * @param 信息发起人对象，并修改其中的finished属性为true
	 * @return 返回是否修改成功的信息
	 * @throws Exception 有异常交给调用方
	 * */
	public boolean changeStatus(Record rec) throws Exception;
	/**
	 * @param 信息发起人对象，并将之对应的数据库中存放的信息删除
	 * @return 返回是否删除成功的信息
	 * @throws Exception 有异常交给调用方
	 * */
	public boolean deleteRecordWithUmbrella(String uno) throws Exception;
	
}
