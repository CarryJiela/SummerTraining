package com.erpang.dao;

import java.util.Date;
import java.util.List;

import com.erpang.vo.Record;

public interface IUmbrellaDao {
	/**
	 * @param 填入的是发起人的信息，存入数据库的信息有：发起人的学号，发起人的起点，终点，日期，信息发起的时间，最晚结束的时间，发起人是否有伞以及备注，最后要存入数据库
	 * @return 返回是否成功添加的信息
	 * @throws Exception 有异常交給调用方
	 * */
	public boolean Increase(Record rec)throws Exception;
	/**
	 * @param 获取整个数据库中的记录，用于随后的Lcs算法计算
	 * @return 一个record列表。注意在sql语句中判断，如果发起人有伞则返回没伞人的列表，否则反之
	 * @throws Exception 有异常交给调用方
	 * */
	public List<Record> getAllRecords(Record rec) throws Exception;
	/**
	 * @param 信息发起人对象，并将之对应的数据库中存放的信息删除
	 * @return 返回是否删除成功的信息
	 * @throws Exception 有异常交给调用方
	 * */
	public boolean deleteRecord(Record rec) throws Exception;
	/**
	 * *
	 * @param uno 通过学号找到数据库中对应的数据 
	 * @return 返回这个学号对应的对象。
	 * @throws Exception 有异常交给调用方
	 */
	public Record getRecord(String uno) throws Exception;
	/**
	 * @param uno ,start_point通过学号找到数据库中对应的数据并且更改其出发点再重新存入数据库
	 * @return 返回是否更改成功的信息
	 * @throws Exception 有异常交给调用方
	 * */
	public boolean changeStartPoint(String uno,int start_point) throws Exception;
	/**
	 * @param uno ,end_point通过学号找到数据库中对应的数据并且更改其终点再重新存入数据库
	 * @return 返回是否更改成功的信息
	 * @throws Exception 有异常交给调用方
	 * */
	public boolean changeEndPoint(String uno,int end_point) throws Exception;
	/**
	 * @param uno ,start_timo通过学号找到数据库中对应的数据并且更改其起始时间再重新存入数据库(时间类尚未确定类型，会有更改）
	 * @return 返回是否更改成功的信息
	 * @throws Exception 有异常交给调用方
	 * */
	public boolean changeStartTime(String uno,int start_time) throws Exception;
	/**
	 * @param uno ,end-time通过学号找到数据库中对应的数据并且更改其结束时间再重新存入数据库(时间类尚未确定类型，会有更改）
	 * @return 返回是否更改成功的信息
	 * @throws Exception 有异常交给调用方
	 * */
	public boolean changeEndtime(String uno,int end_time) throws Exception;
	/**
	 * @param uno ,date_r通过学号找到数据库中对应的数据并且更改其预定日期再重新存入数据库
	 * @return 返回是否更改成功的信息
	 * @throws Exception 有异常交给调用方
	 * */
	public boolean changeDate(String uno,Date date_r) throws Exception;
	/**
	 * @param uno ,have通过学号找到数据库中对应的数据并且更改其是否有伞状态再重新存入数据库
	 * @return 返回是否更改成功的信息
	 * @throws Exception 有异常交给调用方
	 * */
	public boolean changeEndPoint(String uno,boolean have) throws Exception;
	/**
	 * @param uno ,remark通过学号找到数据库中对应的数据并且更改其备注再重新存入数据库
	 * @return 返回是否更改成功的信息
	 * @throws Exception 有异常交给调用方
	 * */
	public boolean changeRemark(String uno,String remark) throws Exception;
}
