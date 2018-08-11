package com.izoro.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.izoro.service.impl.MessageseviceImpl;
import com.izoro.vo.Message;

/**
 * Servlet implementation class DeleteMess
 */
@WebServlet("/DeleteMess")
public class MessDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MessageseviceImpl MessageseviceImpl=new MessageseviceImpl();
		request.setCharacterEncoding("utf-8");
		String MessageId=request.getParameter("MessageId");
		int MessageIdd=Integer.parseInt(MessageId);
		int reslut=MessageseviceImpl.deleteMess(MessageIdd);
		if(reslut>0)
		{
			request.setAttribute("resultDM","1");
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
