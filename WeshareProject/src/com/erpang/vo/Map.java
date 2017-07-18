package com.erpang.vo;

public class Map {

    public String getMsname() {
        return msname;
    }

    public int getMsno() {
        return msno;
    }

    public String getMename() {
        return mename;
    }

    public int getMeno() {
        return meno;
    }

    public float getDistance() {
        return distance;
    }

    public void setMsname(String msname) {
        this.msname = msname;
    }

    public void setMsno(int msno) {
        this.msno = msno;
    }

    public void setMename(String mename) {
        this.mename = mename;
    }

    public void setMeno(int meno) {
        this.meno = meno;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }
    private String msname;				//起始地点名称
    private int msno;					//起始地点序号
    private String mename;				//结束地点名称
    private int meno;					//结束地点序号
    private float distance;				//两点之间距离

	
}
