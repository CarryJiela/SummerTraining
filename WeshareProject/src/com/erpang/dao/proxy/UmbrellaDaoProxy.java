package com.erpang.dao.proxy;

import com.erpang.dao.IUmbrellaDao;
import com.erpang.dao.impl.UmbrellaDaoImpl;
import com.erpang.dbc.DataBaseConnectionMap;
import com.erpang.vo.Record;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hugo on 17-7-18.
 */
public class UmbrellaDaoProxy implements IUmbrellaDao {

    private DataBaseConnectionMap dbc = null;
    private IUmbrellaDao dao = null;

    public UmbrellaDaoProxy() throws Exception {
        this.dbc = new DataBaseConnectionMap();
        this.dao = new UmbrellaDaoImpl(this.dbc.getConnection());
    }

    @Override
    public boolean Increase(Record rec) throws Exception {
        boolean flag = false;
        try {
            if (rec != null) {
                this.dao.Increase(rec);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.closeConnection();
        }
        return flag;
    }


    @Override
    public List<Record> getAllRecords(Record rec) throws Exception {
        List<Record> all = new ArrayList<>();


        return null;
    }

    @Override
    public boolean deleteRecord(String uno) throws Exception {
        boolean flag = false;
        try {
            if (uno != null) {
                flag = this.dao.deleteRecord(uno);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.closeConnection();
        }
        return flag;
    }

    @Override
    public Record getRecord(String uno) throws Exception {
        Record rec = null;
        try {
            if (uno != null) {
                rec = this.dao.getRecord(uno);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.closeConnection();
        }
        return rec;
    }

    @Override
    public boolean changeStartPoint(String uno, int start_point) throws Exception {
        boolean flag = false;
        try {
            if (uno != null) {
                flag = this.dao.changeEndPoint(uno, start_point);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.closeConnection();
        }
        return flag;
    }

    @Override
    public boolean changeEndPoint(String uno, int end_point) throws Exception {
        boolean flag = false;
        try {
            if (uno != null) {
                flag = this.dao.changeEndPoint(uno, end_point);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.closeConnection();
        }
        return flag;
    }

    @Override
    public boolean changeStartTime(String uno, Date start_time) throws Exception {
        boolean flag = false;
        try {
            if (uno != null && start_time != null) {
                flag = this.dao.changeDate(uno, start_time);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.closeConnection();
        }
        return flag;
    }

    @Override
    public boolean changeEndtime(String uno, Date end_time) throws Exception {
        boolean flag = false;
        try {
            if (uno != null && end_time != null) {
                flag = this.dao.changeDate(uno, end_time);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.closeConnection();
        }
        return flag;
    }

    @Override
    public boolean changeDate(String uno, Date date_r) throws Exception {
        boolean flag = false;
        try {
            if (uno != null && date_r != null) {
                flag = this.dao.changeDate(uno, date_r);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.closeConnection();
        }
        return flag;
    }

    @Override
    public boolean changeHave(String uno, boolean have) throws Exception {
        boolean flag = false;
        try {
            if (uno != null) {
                flag = dao.changeHave(uno, have);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.closeConnection();
        }

        return flag;
    }

    @Override
    public boolean changeRemark(String uno, String remark) throws Exception {
        boolean flag = false;
        try {
            if (uno != null && remark != null) {
                flag = dao.changeRemark(uno, remark);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.closeConnection();
        }

        return flag;
    }
}
