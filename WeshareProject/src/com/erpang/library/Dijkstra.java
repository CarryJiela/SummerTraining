/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erpang.library;
import java.util.ArrayList;
import java.util.List;

/**
 *Dijkstra算法
 * @author Administrator
 */
public class Dijkstra {
    private int pointNum;//点数
    private int flag;//標記
    private boolean state[];
    private int destination;//目的地
    private List<Integer> path = null;//最终路径
    private List<Position> list = null;//路径集合
    public Dijkstra(int pointNum,List<Position> list,int departure,int destination){
        this.pointNum = pointNum;
        this.list = list;
        this.path = new ArrayList<Integer>();
        this.path.add(departure);
        this.flag = 0;
        this.destination = destination;
    }
    public List<Integer> getPath(){
        Position[] matrix = new Position[pointNum];
        state = new boolean[pointNum];
        //初始化矩阵
        for(int i = 0;i < pointNum;i ++){
            state[i] = true;
            matrix[i].setDeparture(this.path.get(0));
            matrix[i].setDestination(i+1);
            matrix[i].setDistance(this.getDistance(0, this.path.get(0),i+1));
            if(matrix[i].getDistance() == 0)
                state[i] = false;
        }
        this.process(matrix);
        return this.path;
    }
    //处理矩阵获得最优路径
    public void process(Position[] matrix){
        int loop = pointNum - 1;
        while (loop > 0) {
            int stop = 1;//路径中间点
            while (!state[stop - 1]) {
                stop++;
            }
            double distance = matrix[stop - 1].getDistance();
            for (int i = 1; state[i] && i < pointNum; i++) {
                if (matrix[i].getDistance() == 0) {
                    continue;
                }
                if (distance > matrix[i].getDistance()) {
                    distance = matrix[i].getDistance();
                    stop = i + 1;
                }
            }
            this.path.add(stop);
            state[stop] = false;
            for (int i = 0; state[i] && i < pointNum; i++) {
                double totalDistance = matrix[this.path.get(this.path.size() - 1)].getDistance()
                        + this.getDistance(0, i + 1, this.path.get(this.path.size() - 1));
                if (matrix[i].getDistance() > totalDistance) {
                    matrix[i].setDistance(totalDistance);
                }
            }
            loop--;
        }
        while(this.path.get(this.path.size()-1) != destination)
            this.path.remove(this.path.size()-1);
    }
    //遍历集合获取指定点之间的距离
    public double  getDistance(int no,int departure,int destination){
        for (flag = no; flag < this.list.size(); flag++) {
            Position position = this.list.get(flag);
            if ((position.getDeparture() == departure && position.getDestination() == destination)
             || (position.getDeparture() == destination && position.getDestination() == departure)){
                return position.getDistance();
            }
        }
        return 0;
    }
}
