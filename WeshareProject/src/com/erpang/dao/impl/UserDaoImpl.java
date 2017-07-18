package com.erpang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.erpang.dao.IUserDao;
import com.erpang.vo.User;

public class UserDaoImpl implements IUserDao{

	private Connection conn = null;
	private PreparedStatement ps = null;
	
	public UserDaoImpl(Connection conn){
		this.conn = conn;
	}
	
	@Override
	public boolean logIn(String uno, String password) throws Exception {
		boolean flag = false;
		try {
			String sql = "select uno,password from userinfo where uno = ? and password = ?";
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, uno);
			this.ps.setString(2, password);
			ResultSet rs = this.ps.executeQuery();
			if (rs.next()) {
				rs.getString(1);
				flag = true;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.ps != null) {
				try {
					this.ps.close();
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}	

	@Override
	public boolean register(User user) throws Exception {
		
		return false;
	}

	@Override
	public boolean findPasswordByUno(String uno, String email) throws Exception {
		return false;
	}

	@Override
	public boolean increaseExp() throws Exception {
		return false;
	}

	@Override
	public boolean resetPassword(String uno, String password) throws Exception {
		boolean flag=false;
		String sql="update userinfo set password=? where uno=?";
		this.ps=this.conn.prepareStatement(sql);
		this.ps.setString(1, password);
		this.ps.setString(2, uno);
		if(this.ps.executeUpdate()>0){
			flag=true;
		}
		ps.close();
		return flag;
	}

	@Override
	public boolean changeNickname(String uno, String nickname) throws Exception {
		boolean flag=false;
		String sql="update userinfo set nickname=? where uno=?";
		this.ps=this.conn.prepareStatement(sql);
		this.ps.setString(1, nickname);
		this.ps.setString(2, uno);
		if(this.ps.executeUpdate()>0){
			flag=true;
		}
		ps.close();
		return flag;
	}

	@Override
	public boolean changePhone(String uno, int phone) throws Exception {
		boolean flag=false;
		String sql="update userinfo set phone=? where uno=?";
		this.ps=this.conn.prepareStatement(sql);
		this.ps.setInt(1, phone);
		this.ps.setString(2, uno);
		if(this.ps.executeUpdate()>0){
			flag=true;
		}
		ps.close();
		return flag;
	}

	@Override
	public boolean changeImgUrl(String imgurl,String uno) throws Exception {
		boolean flag;
		flag = false;
		try {
			String sql = "update userinfo set img_addr = ? where uno = ?";
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, imgurl);
			this.ps.setString(2, uno);
			if (this.ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.ps != null) {
				try {
					this.ps.close();
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}
	@Override
	public List<User> match(User user) throws Exception {
		return null;
	}

}
