package com.izoro.Dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.izoro.Dao.UserDao;
import com.izoro.vo.Users;
import JDBC.JDBCTemplates;

public class UserDaoImpl extends JDBCTemplates<Users> implements UserDao{

	public int regist(String userName,String userPassword,String eMail) {
		String sql="INSERT INTO users(userName,userPassword,eMail)VALUES(?,?,?)";
		Object[] param={userName,userPassword,eMail};
		return update(sql,param);
	}
	public Users login(String userName,String userPassword) {
		String sql="SELECT*FROM users WHERE userName=? and userPassword=?";
		Object[] param={userName,userPassword};
		return selectOne(sql,param);
	}
	public int update(Users user) {
		String sql="UPDATE users SET userName=?,userPassword=?,userDire=?,userIntriduce=?,userFace=?,eMail=?,usePhone=? WHERE userId=?";
		Object[] param={user.getUserName(),user.getUserPassword(),user.getUserDire(),user.getUserIntriduce(),user.getUserFace(),user.geteMail(),user.getUsePhone(),user.getUserId()};
		return update(sql,param);
	}
	@Override
	protected Users rowMapper(ResultSet rs) {
		Users user=new Users();
		try {
			user.seteMail(rs.getString("eMail"));
			user.setUsePhone(rs.getString("usePhone"));
			user.setUserDire(rs.getString("userDire"));
			user.setUserFace(rs.getString("userFace"));
			user.setUserId(rs.getInt("userId"));
			user.setUserIntriduce(rs.getString("userIntriduce"));
			user.setUserName(rs.getString("userName"));
			user.setUserPassword(rs.getString("userPassword"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
