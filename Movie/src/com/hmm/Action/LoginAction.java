package com.hmm.Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.izoro.service.impl.UserServiceImpl;
import com.izoro.vo.Users;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users u;
	public Users getU() {
		return u;
	}

	public void setU(Users u) {
		this.u = u;
	}
	
	public String login(){
		HttpServletRequest request = ServletActionContext.getRequest();
		UserServiceImpl UserServiceImpl = new UserServiceImpl();
		Users user = UserServiceImpl.login(u.getUserName(), u.getUserPassword());
		
		
		if(user==null){
			request.setAttribute("login", "1");
			return "fail";
		}else{
			request.getSession().setAttribute("username", user.getUserName());
			request.getSession().setAttribute("userFace", user.getUserFace());
			request.getSession().setAttribute("UserDire", user.getUserDire());
			request.getSession().setAttribute("userMail", user.geteMail());
			request.getSession().setAttribute("userId", user.getUserId());
			request.getSession().setAttribute("userIntriduce", user.getUserIntriduce());
		}
		return SUCCESS;
	}
}
