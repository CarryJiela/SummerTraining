/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erpang.factory;

import com.erpang.dao.proxy.MapDaoProxy;

/**
 *
 * @author Administrator
 */
public class MapDaoFactory {
    public static MapDaoProxy getInstance()throws  Exception{
        return new MapDaoProxy();
    }
}
