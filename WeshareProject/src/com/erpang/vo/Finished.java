package com.erpang.vo;

import java.util.Date;

public class Finished {
	private String uno_A;				//有伞人的学号
	private String uno_B;				//借伞人的学号
	private int start_point_A;			//有伞人的起点
	private int start_point_B;			//借伞人的起点
	private int end_point_A;			//有伞人的终点
	private int end_point_B;			//借伞人的终点
	private Date start_time_A;			//有伞人的起始时间
	private Date start_time_B;			//借伞人的起始时间
	private Date end_time_A;			//有伞人的结束时间
	private Date end_time_B;			//借伞人的结束时间
	private Date date_r;				//当天日期
	private String remark_A;			//有伞人的备注
	private String remark_B;			//借伞人的备注
	public int getEnd_point_A() {
		return end_point_A;
	}
	public void setEnd_point_A(int end_point_A) {
		this.end_point_A = end_point_A;
	}
	public int getEnd_point_B() {
		return end_point_B;
	}
	public void setEnd_point_B(int end_point_B) {
		this.end_point_B = end_point_B;
	}
	public Date getEnd_time_A() {
		return end_time_A;
	}
	public void setEnd_time_A(Date end_time_A) {
		this.end_time_A = end_time_A;
	}
	public Date getEnd_time_B() {
		return end_time_B;
	}
	public void setEnd_time_B(Date end_time_B) {
		this.end_time_B = end_time_B;
	}
	public String getUno_A() {
		return uno_A;
	}
	public void setUno_A(String uno_A) {
		this.uno_A = uno_A;
	}
	public String getUno_B() {
		return uno_B;
	}
	public void setUno_B(String uno_B) {
		this.uno_B = uno_B;
	}
	public int getStart_point_A() {
		return start_point_A;
	}
	public void setStart_point_A(int start_point_A) {
		this.start_point_A = start_point_A;
	}
	public int getStart_point_B() {
		return start_point_B;
	}
	public void setStart_point_B(int start_point_B) {
		this.start_point_B = start_point_B;
	}
	public Date getStart_time_A() {
		return start_time_A;
	}
	public void setStart_time_A(Date start_time_A) {
		this.start_time_A = start_time_A;
	}
	public Date getStart_time_B() {
		return start_time_B;
	}
	public void setStart_time_B(Date start_time_B) {
		this.start_time_B = start_time_B;
	}
	public Date getDate_r() {
		return date_r;
	}
	public void setDate_r(Date date_r) {
		this.date_r = date_r;
	}
	public String getRemark_A() {
		return remark_A;
	}
	public void setRemark_A(String remark_A) {
		this.remark_A = remark_A;
	}
	public String getRemark_B() {
		return remark_B;
	}
	public void setRemark_B(String remark_B) {
		this.remark_B = remark_B;
	}
}
