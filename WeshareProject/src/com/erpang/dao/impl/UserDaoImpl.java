
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
		boolean flag = false;
		String sql = "insert into userinfo (uno,uname,phone,sex,password,email,register_date) values (?,?,?,?,?,?,?)";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, user.getUno());
		this.ps.setString(2, user.getUname());
		this.ps.setInt(3, user.getPhone());
		this.ps.setString(4, user.getSex());
		this.ps.setString(5, user.getPassword());
		this.ps.setString(6, user.getEmail());
		this.ps.setDate(7, new Date(0));
		if(this.ps.executeUpdate()>0){
			flag = true;
		}
		this.ps.close();
		return false;
		return false;
	}

	@Override
	public boolean findPasswordByUno(String uno, String email) throws Exception {
		boolean flag = false;
		String sql = "select * from userinfo where uno = ? and email = ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, uno);
		this.ps.setString(2, email);
		ResultSet rs = this.ps.executeQuery();
		if(rs.next()){
			flag =true;
		}
		rs.close();
		this.ps.close();
		return false;
		return false;
	}

	@Override
	public boolean increaseExp() throws Exception {
		boolean flag = false;
		String sql_select = "select exp from userinfo where uno = ?";
		this.ps = this.conn.prepareStatement(sql_select);
		this.ps.setString(1,uno);
		ResultSet rs = this.ps.executeQuery();
		if(rs.next()){
			int e = rs.getInt(1);
			ps.close();
			String sql_update = "update userinfo set exp = ? where uno = ?";
			this.ps = this.conn.prepareStatement(sql_update);
			this.ps.setInt(1, e+5);
			this.ps.setString(2, uno);
			if(this.ps.executeUpdate()>0){
				flag = true;
			}
		}
		rs.close();
		ps.close();
		return flag;
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
