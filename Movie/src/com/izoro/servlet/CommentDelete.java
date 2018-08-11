package com.izoro.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.izoro.service.impl.CommentserviceImpl;

/**
 * Servlet implementation class DeleteComment
 */
@WebServlet("/DeleteComment")
public class CommentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentserviceImpl CommentserviceImpl=new CommentserviceImpl();
		request.setCharacterEncoding("utf-8");
		String commentIds=request.getParameter("commentId");
		int commentId=Integer.parseInt(commentIds);
		int reslut=CommentserviceImpl.deleteCommentByOwn(commentId);
		if(reslut>0)
		{
			request.setAttribute("resultD","1");
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
