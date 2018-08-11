package com.izoro.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.izoro.service.impl.CommentserviceImpl;
import com.izoro.vo.Comment;

/**
 * Servlet implementation class CommentUpdate
 */
@WebServlet("/CommentUpdate")
public class CommentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentserviceImpl CommentserviceImpl=new CommentserviceImpl();
		request.setCharacterEncoding("utf-8");
		String commentContent=request.getParameter("commentContent");
		String commentLevels=request.getParameter("commentLevel");
		int commentLevel=Integer.parseInt(commentLevels);
		String commentMovieIds=request.getParameter("commentMovieId");
		int commentMovieId=Integer.parseInt(commentMovieIds);
		String peopleIds=request.getParameter("peopleId");
		int peopleId=Integer.parseInt(peopleIds);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String commentIds=request.getParameter("commentId");
		int commentId=Integer.parseInt(commentIds);
		Comment comment=new Comment();
		comment.setCommentContent(commentContent);
		comment.setCommentLevel(commentLevel);
		comment.setCommentMovieId(commentMovieId);
		comment.setCommentPeople(peopleId);
		comment.setCommentTime(df.format(new Date()));
		comment.setCommentId(commentId);
		int result=CommentserviceImpl.updateComment(comment);
		request.setAttribute("result",result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
