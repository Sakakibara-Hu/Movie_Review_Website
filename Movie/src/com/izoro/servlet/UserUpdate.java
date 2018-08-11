package com.izoro.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.izoro.service.impl.UserServiceImpl;
import com.izoro.vo.Users;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServiceImpl UserServiceImpl=new UserServiceImpl();
		request.setCharacterEncoding("utf-8");
		String eMail=request.getParameter("eMail");
		String psw="1";
		String userDire=request.getParameter("userDire");
		String userFace=request.getParameter("userFace");
		String userId=request.getParameter("userId");
		int userIds=Integer.parseInt(userId);
		String userIntriduce=request.getParameter("userIntriduce");
		String userName=request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
	    Users user=new Users();
	    user.seteMail(eMail);
	    user.setUsePhone(psw);
	    user.setUserDire(userDire);
	    user.setUserFace(userFace); 
	    user.setUserId(userIds);
		user.setUserIntriduce(userIntriduce);
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		int reslut=UserServiceImpl.update(user);
		if(reslut==1){
			request.setAttribute("reslutC", 1);
			request.getSession().setAttribute("username", user.getUserName());
			request.getSession().setAttribute("userFace", user.getUserFace());
			request.getSession().setAttribute("UserDire", user.getUserDire());
			request.getSession().setAttribute("userMail", user.geteMail());
			request.getSession().setAttribute("userId", user.getUserId());
			request.getSession().setAttribute("userIntriduce", user.getUserIntriduce());
		}else{
			request.setAttribute("reslutC", 0);
		}
		request.getRequestDispatcher("/view/information.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
