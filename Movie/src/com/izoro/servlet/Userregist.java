package com.izoro.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.izoro.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserregistServlet")
public class Userregist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServiceImpl userServiceImpl=new UserServiceImpl();
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		int result=userServiceImpl.regist(name, password, email);
		System.out.println(result+"注册");
		if(result==0){
			request.setAttribute("result", false);
			request.getRequestDispatcher("view/register.jsp").forward(request, response);
		}else{
			
			response.sendRedirect("view/login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
