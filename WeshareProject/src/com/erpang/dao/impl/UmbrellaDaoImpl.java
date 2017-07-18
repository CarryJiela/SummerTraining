package com.erpang.dao.impl;

import com.erpang.dao.IUmbrellaDao;
import com.erpang.vo.Record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;

/**
 * Created by hugo on 17-7-18.
 */
public class UmbrellaDaoImpl implements IUmbrellaDao {

    private Connection conn = null;
    private PreparedStatement ps = null;

    @Override
    public boolean Increase(Record rec) throws Exception {


        return false;
    }

    @Override
    public List<Record> getAllRecords(Record rec) throws Exception {
        return null;
    }

    @Override
    public boolean deleteRecord(Record rec) throws Exception {
        return false;
    }

    @Override
    public Record getRecord(String uno) throws Exception {
        return null;
    }

    @Override
    public boolean changeStartPoint(String uno, int start_point) throws Exception {
        return false;
    }

    @Override
    public boolean changeEndPoint(String uno, int end_point) throws Exception {
        return false;
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
