package com.izoro.Dao;

import com.izoro.vo.Users;

public interface UserDao {
    //注册
	int regist(String userName,String userPassword,String eMail);
	//登录
	Users login(String userName,String userPassword);
	//编辑
	int update(Users user);
	
}
