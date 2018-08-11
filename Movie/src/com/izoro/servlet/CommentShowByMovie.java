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

/**
 * Servlet implementation class CommentShowByMovie
 */
@WebServlet("/CommentShowByMovie")
public class CommentShowByMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentserviceImpl CommentserviceImpl=new CommentserviceImpl();
		request.setCharacterEncoding("utf-8");
		String MovieIds=request.getParameter("MovieId");
		int MovieId=Integer.parseInt(MovieIds);
		List<Comment> comment=CommentserviceImpl.showComment(MovieId);
		request.setAttribute("result",comment);
		request.getRequestDispatcher("view/movieMsg.jsp?mid="+MovieIds).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
