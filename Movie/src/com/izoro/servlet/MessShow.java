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
import com.izoro.vo.MessageOne;

/**
 * Servlet implementation class ShowMess
 */
@WebServlet("/ShowMess")
public class MessShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MessageseviceImpl MessageseviceImpl=new MessageseviceImpl();
		request.setCharacterEncoding("utf-8");
		String userIdd=request.getParameter("userId");
		int userId=Integer.parseInt(userIdd);
		List<MessageOne> messages=MessageseviceImpl.showByOne(userId);
//		for(int i=0;i<messages.size();i++){
//			System.out.println(messages.get(i).toString());
//		}
		request.setAttribute("resultM",messages);
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
