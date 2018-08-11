package com.izoro.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.izoro.Dao.impl.MovieDaoImpl;
import com.izoro.vo.HadMovie;
import com.izoro.vo.WanttoMovie;

/**
 * Servlet implementation class WantMovieShow
 */
@WebServlet("/WantMovieShow")
public class WantMovieShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDaoImpl movieDaoImpl=new MovieDaoImpl();
		request.setCharacterEncoding("utf-8");
		String peopleIds=request.getParameter("peopleId");
		int peopleId=Integer.parseInt(peopleIds);
		List<WanttoMovie> movies=movieDaoImpl.showWantMovie(peopleId);
		request.setAttribute("movies", movies);
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
