package com.izoro.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.izoro.Dao.impl.MovieDaoImpl;
import com.izoro.vo.Movie;

/**
 * Servlet implementation class MovieSearchBySpace
 */
@WebServlet("/MovieSearchBySpace")
public class MovieSearchBySpace extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDaoImpl movieDaoImpl=new MovieDaoImpl();
		request.setCharacterEncoding("utf-8");
		String type=request.getParameter("type");
		String tid=request.getParameter("tid");
		if(tid.isEmpty())
		{
			tid="tall";
		}
		String space=request.getParameter("space");
		String sid=request.getParameter("sid");
		if(sid.isEmpty())
		{
			sid="sall";
		}
		
//		String movieType=request.getParameter("movieType");
//		String moveSpace=request.getParameter("moveSpace");
		String pages="0";//request.getParameter("page");
		int page=Integer.parseInt(pages);
		List<Movie> moive=movieDaoImpl.SearchMovieBySpace(type, space, page);
		request.setAttribute("movie", moive);
		
		request.setAttribute("type", type);
		request.setAttribute("tid", tid);
		request.setAttribute("space", space);
		request.setAttribute("sid", sid);
		
		request.getRequestDispatcher("/view/classifyPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
