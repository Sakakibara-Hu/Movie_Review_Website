package com.izoro.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.izoro.service.impl.MessageseviceImpl;
import com.izoro.vo.Message;

/**
 * Servlet implementation class InsertMess
 */
@WebServlet("/InsertMess")
public class MessInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MessageseviceImpl MessageseviceImpl=new MessageseviceImpl();
		String messageContent=request.getParameter("messageContent");
		String messageOneIdd=request.getParameter("messageOneId");
		int messageOneId=Integer.parseInt(messageOneIdd);
		String messageTwoIdd=request.getParameter("messageTwoId");
		int messageTwoId=Integer.parseInt(messageTwoIdd);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		Message message=new Message();
		message.setMessageContent(messageContent);
		message.setMessageTime(df.format(new Date()));
		message.setMessageOneId(messageOneId);
		message.setMessageTwoId(messageTwoId);
		int reslut=MessageseviceImpl.insertMess(message);
		request.setAttribute("result",reslut);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
