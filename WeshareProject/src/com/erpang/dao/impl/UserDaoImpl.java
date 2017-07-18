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
	public boolean resetPassword(String password) throws Exception {
		return false;
	}

	@Override
	public boolean changeNickname(String nickname) throws Exception {
		return false;
	}

	@Override
	public boolean changePhone(int phone) throws Exception {
		return false;
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
