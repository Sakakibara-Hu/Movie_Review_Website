package com.izoro.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.izoro.Dao.impl.MovieDaoImpl;

/**
 * Servlet implementation class WantMovieAdd
 */
@WebServlet("/WantMovieAdd")
public class WantMovieAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDaoImpl movieDaoImpl=new MovieDaoImpl();
		String movieIds=request.getParameter("movieId");
		int movieId=Integer.parseInt(movieIds);
		String peopleIds=request.getParameter("eopleId");
		int peopleId=Integer.parseInt(peopleIds);
		int result=movieDaoImpl.insertWanttoMovie(movieId, peopleId);
		request.setAttribute("result", result);//1是ok，0是false
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
