package com.erpang.vo;

import java.util.Date;


public class Record {
	private String uno_r;							//信息发起人的学号
	private String uno_partener;					//配对人的学号（第一步不会填写）
	private int start_point;						//信息发起人的起点
	private int end_point;							//信息发起人的終点
	private Date date_r;							//信息发起的日期
	private Date start_time;						//信息发起的时间
	private Date end_time;							//信息最晚結束的时间（也就是发起人可以忍耐的deadline）
	private boolean have;							//信息发起人是否有伞
	private String remark;							//信息发起人的备注
	//getter and setter
	public String getUno_r() {
		return uno_r;
	}
	public void setUno_r(String uno_r) {
		this.uno_r = uno_r;
	}
	public String getUno_partener() {
		return uno_partener;
	}
	public void setUno_partener(String uno_partener) {
		this.uno_partener = uno_partener;
	}
	public int getStart_point() {
		return start_point;
	}
	public void setStart_point(int start_point) {
		this.start_point = start_point;
	}
	public int getEnd_point() {
		return end_point;
	}
	public void setEnd_point(int end_point) {
		this.end_point = end_point;
	}
	public Date getDate_r() {
		return date_r;
	}
	public void setDate_r(Date date_r) {
		this.date_r = date_r;
	}
	public boolean isHave() {
		return have;
	}
	public void setHave(boolean have) {
		this.have = have;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
}
