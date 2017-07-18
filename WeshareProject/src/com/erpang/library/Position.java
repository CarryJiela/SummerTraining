package com.erpang.library;

/**
 *
 * @author Administrator
 */
public class Position {
    private int departure;//起点编号
    private int destination;//终点编号
    private double distance;//距离

    /**
     * @return the departure
     */
    public int getDeparture() {
        return departure;
    }

    /**
     * @param departure the departure to set
     */
    public void setDeparture(int departure) {
        this.departure = departure;
    }

    /**
     * @return the destination
     */
    public int getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(int destination) {
        this.destination = destination;
    }

    /**
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }
    
}
