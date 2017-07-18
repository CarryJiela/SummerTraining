package com.erpang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.erpang.dao.IFinishedRecDao;
import com.erpang.vo.Finished;
import com.erpang.vo.Record;

public class FinishedRecDaoImpl implements IFinishedRecDao {

	private Connection conn = null;
	private PreparedStatement ps = null;

	public FinishedRecDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean Increase(Record rec1, Record rec2) throws Exception {
		boolean flag = false;
		String sql = "insert  into finished (uno_A,uno_B,start_point_A,start_point_B,end_point_A,end_point_B,start_time_A,start_time_B,end_time_A,end_time_B,date_r,remark_A,remark_B) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, rec1.getUno_r());
		this.ps.setString(2, rec2.getUno_r());
		this.ps.setInt(3, rec1.getStart_point());
		this.ps.setInt(4, rec2.getStart_point());
		this.ps.setInt(5, rec1.getEnd_point());
		this.ps.setInt(6, rec2.getEnd_point());
		this.ps.setDate(7, new java.sql.Date(rec1.getStart_time().getTime()));
		this.ps.setDate(8, new java.sql.Date(rec2.getStart_time().getTime()));
		this.ps.setDate(9, new java.sql.Date(rec1.getEnd_time().getTime()));
		this.ps.setDate(10, new java.sql.Date(rec2.getEnd_time().getTime()));
		this.ps.setDate(11, new java.sql.Date(rec1.getDate_r().getTime()));
		this.ps.setString(12, rec1.getRemark());
		this.ps.setString(13, rec2.getRemark());
		
		if(this.ps.executeUpdate() > 0){
			flag = true;
		}
		this.ps.close();
		
		return flag;
	}

	@Override
	public List<Finished> getAllRecord(String uno) throws Exception {
		List<Finished> all = new ArrayList<Finished>();
		String sql = "select uno_A,uno_B,start_point_A,start_point_B,end_point_A,end_point_B,start_time_A,start_time_B,end_time_A,end_time_B,date_r,remark_A,remark_B from finished where uno_A = ? or uno_B = ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, uno);
		this.ps.setString(2, uno);
		ResultSet rs = ps.executeQuery();
		Finished fin = null;
		while(rs.next()){
			fin = new Finished();
			fin.setUno_A(rs.getString(1));
			fin.setUno_B(rs.getString(2));
			fin.setStart_point_A(rs.getInt(3));
			fin.setStart_point_B(rs.getInt(4));
			fin.setEnd_point_A(rs.getInt(5));
			fin.setEnd_point_B(rs.getInt(6));
			fin.setStart_time_A(rs.getDate(7));
			fin.setStart_time_B(rs.getDate(8));
			fin.setStart_time_A(rs.getDate(9));
			fin.setStart_time_B(rs.getDate(10));
			fin.setDate_r(rs.getDate(11));
			fin.setRemark_A(rs.getString(12));
			fin.setRemark_B(rs.getString(13));
			all.add(fin);
		}
		
		rs.close();
		this.ps.close();
		
		return all;
	}

}
