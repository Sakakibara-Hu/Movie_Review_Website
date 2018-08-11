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
 * Servlet implementation class MovieSearchByScore
 */
@WebServlet("/MovieSearchByScore")
public class MovieSearchByScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDaoImpl movieDaoImpl=new MovieDaoImpl();
		request.setCharacterEncoding("utf-8");
		String url = request.getParameter("url");
		List<Movie> moive=movieDaoImpl.SearchMovieByScore();
		request.setAttribute("topmovie", moive);
		request.getRequestDispatcher("view/"+url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
