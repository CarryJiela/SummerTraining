package com.erpang.dao;

import java.util.List;

import com.erpang.vo.User;

public interface UserDao {
	/**
	 * 登录操作
	 * @param uno,password
	 * 		验证信息，学号和密码
	 * @return 是否登录成功的标记
	 * @throws Exception
	 * 		有异常交给调用方处理
	 * */
	public boolean logIn (String uno,String password) throws Exception;
	/**
	 * @param user
	 * 		注册的数据对象：user 必填项目：学号，学生姓名，性别
	 * @return 
	 * 		是否注册成功
	 * @throws Exception 
	 * 		有异常交给调用方处理
	 * */
	public boolean register (User user) throws Exception;
	/**
	 * 尚未完成，还需副经理酌定
	 * @param unp,phone
	 * 		找回密码需要的信息，学号以及注册时用的手机号，用这个手机号与数据库中的手机号对比。
	 * @return 是否验证成功，传进的参数与数据库中存放的不同则返回false，
	 * @
	 * */
	public boolean findPasswordBack (String uno,int phone) throws Exception;
	/**
	 * @param 无
	 * @return 
	 * 		是否升级成功，每次增加的经验值固定为5点（可以再修改）更改数据库中的经验值
	 * @throws Exception 
	 * 		有异常交给调用方处理
	 * */
	public boolean increaseExp () throws Exception;
	/**
	 *  @param password 
	 *  	新密码，将数据库中存放的密码更换为这个。
	 *  @return 更改密码是否成功
	 *  @throws Exception 
	 *  	有异常交给调用方处理
	 * */
	public boolean changePassword(String password) throws Exception;
	/**
	 *  @param nickname
	 *  	新昵称，将数据库中存放的昵称更换为这个。
	 *  @return 更改昵称是否成功
	 *  @throws Exception 
	 *  	有异常交给调用方处理
	 * */
	public boolean changeNickname(String nickname) throws Exception;
	/**
	 *  @param phone 
	 *  	新电话，将数据库中存放的电话更换为这个。
	 *  @return 更改电话是否成功
	 *  @throws Exception 
	 *  	有异常交给调用方处理
	 * */
	public boolean changePhone(int phone) throws Exception;
	/**
	 *  @param imgurl 
	 *  	新头像地址，将数据库中存放的头像地址更换为这个。
	 *  @return 更改头像弟子是否成功
	 *  @throws Exception 
	 *  	有异常交给调用方处理
	 * */
	public boolean changeImgUrl(String imgurl) throws Exception;
	/**尚未确定，请副经理酌定
	 * @param user
	 * 		传入的用户信息，通过这个用户所提供的
	 * */
	public List<User> match(User user) throws Exception;
	
}
