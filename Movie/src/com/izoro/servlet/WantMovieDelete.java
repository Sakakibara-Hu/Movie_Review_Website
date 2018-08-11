package com.izoro.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.izoro.Dao.impl.MovieDaoImpl;

/**
 * Servlet implementation class WantMovieDelete
 */
@WebServlet("/WantMovieDelete")
public class WantMovieDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDaoImpl movieDaoImpl=new MovieDaoImpl();
		request.setCharacterEncoding("utf-8");
		String wantMovieIds=request.getParameter("movieId");
		int wantMovieId=Integer.parseInt(wantMovieIds);
		int result=movieDaoImpl.delteWantMovie(wantMovieId);
		//request.setAttribute("result", result);//1是ok，0是false
		if(result>0)
		{
			request.setAttribute("resultWM","1");
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
