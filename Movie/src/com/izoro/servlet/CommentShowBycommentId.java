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

/**
 * Servlet implementation class CommentShowBycommentId
 */
@WebServlet("/CommentShowBycommentId")
public class CommentShowBycommentId extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentserviceImpl CommentserviceImpl=new CommentserviceImpl();
		request.setCharacterEncoding("utf-8");
		String CommentIds=request.getParameter("CommentId");
		int CommentId=Integer.parseInt(CommentIds);
		CommentOne ByCommentId=CommentserviceImpl.showCommentByCommentId(CommentId);
		request.setAttribute("commentByCommentId",ByCommentId);
		request.getRequestDispatcher("/view/filmReview.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
