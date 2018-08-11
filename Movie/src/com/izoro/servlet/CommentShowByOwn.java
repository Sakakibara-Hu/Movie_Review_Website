package com.izoro.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.izoro.service.impl.CommentserviceImpl;
import com.izoro.vo.Comment;
import com.izoro.vo.CommentOne;
import com.izoro.vo.Message;

/**
 * Servlet implementation class CommentShowByOwn
 */
@WebServlet("/CommentShowByOwn")
public class CommentShowByOwn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentserviceImpl CommentserviceImpl=new CommentserviceImpl();
		request.setCharacterEncoding("utf-8");
		String userIdd=request.getParameter("userId");
		int userId=Integer.parseInt(userIdd);
		List<CommentOne> messages=CommentserviceImpl.showCommentByOwn(userId);
		request.setAttribute("result",messages);
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
