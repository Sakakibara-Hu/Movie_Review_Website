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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		UserServiceImpl UserServiceImpl=new UserServiceImpl();
		String name=request.getParameter("username");
		String psw=request.getParameter("password");
		Users user=UserServiceImpl.login(name, psw);
		
		
		if(user==null){
			request.setAttribute("login", "1");
			request.getRequestDispatcher("/view/login.jsp").forward(request,response);
		}else{
			request.getSession().setAttribute("username", user.getUserName());
			request.getSession().setAttribute("userFace", user.getUserFace());
			request.getSession().setAttribute("UserDire", user.getUserDire());
			request.getSession().setAttribute("userMail", user.geteMail());
			request.getSession().setAttribute("userId", user.getUserId());
			request.getSession().setAttribute("userIntriduce", user.getUserIntriduce());
			request.getRequestDispatcher("/view/main.jsp").forward(request, response);
		}
	}

}
