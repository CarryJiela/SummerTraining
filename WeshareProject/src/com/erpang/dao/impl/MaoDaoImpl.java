/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erpang.dao.impl;

import com.erpang.dao.IMapDao;
import com.erpang.library.Dijkstra;
import com.erpang.library.Position;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class MaoDaoImpl implements  IMapDao{
    private Connection connection = null;
    private PreparedStatement preparedStatement;
    public MaoDaoImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public List<Integer> getPath(int depature,int destination) throws Exception {
        List<Integer> path = null;
        List<Position> list = new ArrayList<Position>();
        ResultSet resultSet = null;
        int pointNum = 0;
        String sql = "select add1,add2,distance from route";
        try {
            this.preparedStatement = (PreparedStatement) this.connection.prepareStatement(sql);
            resultSet = this.preparedStatement.executeQuery();
            while (resultSet.next()) {
                Position position = new Position();
                position.setDeparture(resultSet.getInt(1));
                position.setDestination(resultSet.getInt(2));
                position.setDistance(resultSet.getDouble(3));
                list.add(position);
                pointNum++;
            }
            Dijkstra dijkstra = new Dijkstra(pointNum, list, depature, destination);
            path = dijkstra.getPath();
        } catch (Exception e) {
            throw e;
        }finally{
            if(resultSet != null)
                resultSet.close();
            if(this.preparedStatement != null)
                this.preparedStatement.close();
        }
        return path;
    }

   
    
}
