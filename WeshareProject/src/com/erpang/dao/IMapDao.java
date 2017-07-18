/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erpang.dao;

import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IMapDao {
    /**
     * 返回最佳路径
     * @return 
     */
    public List<Integer> getPath(int depature,int destination)throws Exception;
}
