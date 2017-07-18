/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erpang.library;

/**
 *
 * @author Administrator
 */
public class Rate {
    /**
     * 将经验值转换为等级
     * @param exp
     * @return Rating
     */
    public static int getRating(int exp){
        int top = 5;
        int rating = 0;
        do{
            exp -= top;
            rating ++;
            top += 5;
        }while(exp > 0);
        return rating;
    }
}
