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
 * Servlet implementation class MovieByTuijianShow
 */
@WebServlet("/MovieByTuijianShow")
public class MovieByTuijianShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDaoImpl movieDaoImpl=new MovieDaoImpl();
		request.setCharacterEncoding("utf-8");
		String neirong=request.getParameter("neirong");
		String pages=request.getParameter("page");
		String movieIds=request.getParameter("movieId");
		int id = Integer.parseInt(movieIds);
		int page=Integer.parseInt(pages);
		String[] tp = neirong.split(",");
		List<Movie> moive = movieDaoImpl.showMovieByleixing(tp, page, id);
		request.setAttribute("tjmovie", moive);
		request.getRequestDispatcher("view/movieMsg.jsp?mid="+movieIds).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
