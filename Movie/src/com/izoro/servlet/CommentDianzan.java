package com.izoro.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.izoro.service.impl.CommentserviceImpl;

/**
 * Servlet implementation class Dianzan
 */
@WebServlet("/Dianzan")
public class CommentDianzan extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentserviceImpl commentserviceImpl=new CommentserviceImpl();
		String commentIds=request.getParameter("commentId");
		int commentId=Integer.parseInt(commentIds);
		int reslut=commentserviceImpl.addDianzan(commentId);
		request.setAttribute("result",reslut);
		request.setAttribute("Id",commentIds);
		request.getRequestDispatcher("view/dianzanJump.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
