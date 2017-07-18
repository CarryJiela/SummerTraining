package com.erpang.dao.impl;

import com.erpang.dao.IUmbrellaDao;
package com.erpang.dao.impl;

import com.erpang.dao.IUmbrellaDao;
import com.erpang.vo.Record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hugo on 17-7-18.
 */
public class UmbrellaDaoImpl implements IUmbrellaDao {

    private Connection conn = null;
    private PreparedStatement ps = null;

    public UmbrellaDaoImpl(Connection conn) { // 通过构造方法来取得数据库连接
		this.conn = conn;
	}

	public boolean Increase(Record rec) throws Exception {
    /**
     * @param 填入的是发起人的信息
     *            ，存入数据库的信息有：发起人的学号，发起人的起点，终点，日期，信息发起的时间，最晚结束的时间，发起人是否有伞以及备注
     *            ，最后要存入数据库
     * @return 返回是否成功添加的信息
     * @throws Exception
     *             有异常交給调用方
     * */
    boolean flag = false;
    String sql = "insert into unfinished (uno,start_time,end_time,start_point,end_point,have,remark,date_r) values (?,?,?,?,?,?,?,?)";
    this.ps = this.conn.prepareStatement(sql); // 实例化 ps对象
    this.ps.setString(1, rec.getUno_r());
    this.ps.setTime(2, (Time) rec.getStart_time());
    this.ps.setTime(3, (Time) rec.getEnd_time());
    this.ps.setInt(4, rec.getStart_point());
    this.ps.setInt(5, rec.getEnd_point());
    this.ps.setBoolean(6, rec.isHave());
    this.ps.setString(7, rec.getRemark());
    this.ps.setDate(8, (java.sql.Date) rec.getDate_r());
    if (this.ps.executeUpdate() > 0) {
        flag = true;
    }
    this.ps.close();
    return flag;
}

@Override
public List<Record> getAllRecords(Record rec) throws Exception {
    /**
     * @param 获取整个数据库中的记录
     *            ，用于随后的Lcs算法计算
     * @return 一个record列表。注意在sql语句中判断，如果发起人有伞则返回没伞人的列表，否则反之
     * @throws Exception
     *             有异常交给调用方
     * */
    List<Record> all = new ArrayList<>();
    if (rec.isHave() == true) {
        String sql = "select (uno,start_time,end_time,start_point,end_point,have,remark,date_r) from unfinished where have=false";
        this.ps = this.conn.prepareStatement(sql);
        ResultSet rs = this.ps.executeQuery();
        Record rec1;
        while (rs.next()) {
            rec1 = new Record();
            rec1.setUno_r(rs.getString(1));
            rec1.setStart_time(rs.getTime(2));
            rec1.setEnd_time(rs.getTime(3));
            rec1.setStart_point(rs.getInt(4));
            rec1.setEnd_point(rs.getInt(5));
            rec1.setHave(rs.getBoolean(6));
            rec1.setRemark(rs.getString(7));
            rec1.setDate_r(rs.getDate(8));
            all.add(rec1);
        }
        rs.close();
        this.ps.close();
    } else {
        String sql = "select * from unfinished where have=true";
        this.ps = this.conn.prepareStatement(sql);
        ResultSet rs = this.ps.executeQuery();
        Record rec1;
        while (rs.next()) {
            rec1 = new Record();
            rec1.setUno_r(rs.getString(1));
            rec1.setStart_time(rs.getTime(2));
            rec1.setEnd_time(rs.getTime(3));
            rec1.setStart_point(rs.getInt(4));
            rec1.setEnd_point(rs.getInt(5));
            rec1.setHave(rs.getBoolean(6));
            rec1.setRemark(rs.getString(7));
            rec1.setDate_r(rs.getDate(8));
            all.add(rec1);
        }
        rs.close();
        this.ps.close();
    }
    return all;
}

    @Override
    public boolean deleteRecord(String uno) throws Exception {
        boolean flag = true;
    	String sql = "Delete from unfinished where uno = ?";
    	this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, uno);
		ResultSet rs = this.ps.executeQuery();
    	if (this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
        return flag;
    }

    @Override
    public Record getRecord(String uno) throws Exception {
        Record rec = null;
		String sql = "Select uno,start_time,end_time,start_point,end_point,have,remark,date_r from unfinished where uno = ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, uno);
		ResultSet rs = this.ps.executeQuery();
		if(rs.next()){
			rec = new Record();
			rec.setUno_r(rs.getString(1));
			rec.setStart_time(rs.getDate(2));
			rec.setEnd_time(rs.getDate(3));
			rec.setStart_point(rs.getInt(4));
			rec.setEnd_point(rs.getInt(5));
			rec.setHave(rs.getBoolean(6));
			rec.setRemark(rs.getString(7));
			rec.setDate_r(rs.getDate(8));
		}
		rs.close();
		this.ps.close();
		return rec;
    }

    @Override
    public boolean changeStartPoint(String uno, int start_point) throws Exception {
        boolean flag = false;
    	String sql = "update end_point from where uno like ?";
    	this.ps = this.conn.prepareStatement(sql);
    	this.ps.setInt(1,start_point);
    	ResultSet rs = this.ps.executeQuery();
    	if (this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
    	return flag;
    }

    @Override
    public boolean changeEndPoint(String uno, int end_point) throws Exception {
        boolean flag = false;
    	String sql = "update end_point from where uno like ?";
    	this.ps = this.conn.prepareStatement(sql);
    	this.ps.setInt(1,end_point);
    	ResultSet rs = this.ps.executeQuery();
    	if (this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		return flag;
    }

    @Override
    public boolean changeStartTime(String uno, Date start_time) throws Exception {
        boolean flag = false;
        String sql = "UPDATE unfinished SET start_time = ? WHERE uno = ? ";
        this.ps = this.conn.prepareStatement(sql);
        this.ps.setTime(1, new java.sql.Time(start_time.getTime()));
        this.ps.setString(2, uno);
        if (this.ps.executeUpdate() > 0) {
            flag = true;
        }
        this.ps.close();
        return flag;
    }

    @Override
    public boolean changeEndtime(String uno, Date end_time) throws Exception {
        boolean flag = false;
        String sql = "UPDATE unfinished SET end_time = ? WHERE uno = ? ";
        this.ps = this.conn.prepareStatement(sql);
        this.ps.setTime(1,  new java.sql.Time(end_time.getTime()));
        this.ps.setString(2, uno);
        if (this.ps.executeUpdate() > 0) {
            flag = true;
        }
        this.ps.close();
        return flag;
    }

    @Override
    public boolean changeDate(String uno, Date date_r) throws Exception {
        boolean flag = false;
        String sql = "UPDATE unfinished SET date_r = ? WHERE uno = ?";
        this.ps = this.conn.prepareStatement(sql);
        this.ps.setDate(1, new java.sql.Date(date_r.getTime()));
        this.ps.setString(2,uno);
        if (this.ps.executeUpdate() > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean changeHave(String uno, boolean have) throws Exception {
        boolean flag = false;
        String sql = "UPDATE unfinished SET have = ? WHERE uno = ?";
        this.ps = this.conn.prepareStatement(sql);
        this.ps.setBoolean(1, have);
        this.ps.setString(2,uno);
        if (this.ps.executeUpdate() > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean changeRemark(String uno, String remark) throws Exception {
        boolean flag = false;
        String sql = "UPDATE unfinished SET remark = ? WHERE uno = ?";
        this.ps = this.conn.prepareStatement(sql);
        this.ps.setString(1, remark);
        this.ps.setString(2,uno);
        if (this.ps.executeUpdate() > 0) {
            flag = true;
        }
        return flag;
    }
}
