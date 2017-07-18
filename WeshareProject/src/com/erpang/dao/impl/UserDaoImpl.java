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
		String sql = "";
		return false;
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
	public boolean changeImgUrl(String imgurl) throws Exception {
		return false;
	}

	@Override
	public List<User> match(User user) throws Exception {
		return null;
	}

}
