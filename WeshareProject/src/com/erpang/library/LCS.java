/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erpang.library;

import java.util.List;

/**
 *
 * @author Administrator
 */
public class LCS {
     /**
      * 以路径作为主要参数处理获得相似度
      * @param path1
      * @param path2
      * @return 相似度
      */
     public static int getSimilarity(List<Integer> path1,List<Integer> path2){
         int similarity = 0;
         int[][] matrix = new int[path1.size()+1][path2.size()+1];
         for(int i = 0;i <= path1.size();i ++)
             matrix[i][0] = 0;
         for(int j = 0;j <= path2.size();j ++)
             matrix[0][j] = 0;
         for(int i = 1;i <= path1.size();i ++)
             for(int j = 1;j <= path2.size();j ++){
                 if(path1.get(i-1) == path2.get(j-1))
                     matrix[i][j] = matrix[i-1][j] + 1;
                 else if(matrix[i-1][j]>matrix[i][j-1])
                     matrix[i][j] = matrix[i-1][j] ;
                 else 
                     matrix[i][j] = matrix[i][j-1];
             }
         similarity = 100 * matrix[path1.size()][path2.size()] / (path1.size()+path2.size());
         return similarity;
     }
}
