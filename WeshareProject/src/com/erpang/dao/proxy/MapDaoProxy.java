/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erpang.dao.proxy;

import com.erpang.dao.IMapDao;
import com.erpang.dao.impl.MaoDaoImpl;
import com.erpang.dbc.DataBaseConnectionMap;
import com.mysql.jdbc.Connection;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class MapDaoProxy implements IMapDao{
    private DataBaseConnectionMap dataBaseConnectionMap = null;
    private IMapDao iMapDao = null;
    public MapDaoProxy()throws  Exception{
        this.dataBaseConnectionMap = new DataBaseConnectionMap();
        this.iMapDao = new MaoDaoImpl((Connection) this.dataBaseConnectionMap.getConnection());
    }

    @Override
    public List<Integer> getPath(int depature, int destination) throws Exception {
        List<Integer> path = null;
        try {
            path = this.iMapDao.getPath(depature, destination);
        } catch (Exception e) {
            throw e;
        }finally{
            this.dataBaseConnectionMap.closeConnection();
        }
        return path;
    }
    
}
