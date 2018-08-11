package com.izoro.service.impl;

import com.izoro.Dao.impl.UserDaoImpl;
import com.izoro.service.UserService;
import com.izoro.vo.Users;

public class UserServiceImpl implements UserService {
    private UserDaoImpl userDaoImpl=new UserDaoImpl();

	public int regist(String userName,String userPassword,String eMail) {
		return userDaoImpl.regist(userName,userPassword,eMail);
	}
	public Users login(String userName,String userPassword) {
		return userDaoImpl.login(userName,userPassword);
	}
	public int update(Users user) {
		return userDaoImpl.update(user);
	}

}
