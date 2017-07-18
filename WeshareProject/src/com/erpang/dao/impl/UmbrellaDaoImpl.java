package com.erpang.dao.impl;

import com.erpang.dao.IUmbrellaDao;
import com.erpang.vo.Record;

import java.util.Date;
import java.util.List;

/**
 * Created by hugo on 17-7-18.
 */
public class UmbrellaDaoImpl extends IUmbrellaDao{
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
    public boolean changeStartTime(String uno, int start_time) throws Exception {
        return false;
    }

    @Override
    public boolean changeEndtime(String uno, int end_time) throws Exception {
        return false;
    }

    @Override
    public boolean changeDate(String uno, Date date_r) throws Exception {
        return false;
    }

    @Override
    public boolean changeEndPoint(String uno, boolean have) throws Exception {
        return false;
    }

    @Override
    public boolean changeRemark(String uno, String remark) throws Exception {
        return false;
    }
}
