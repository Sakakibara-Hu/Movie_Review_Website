package com.izoro.service.impl;

import java.util.List;
import com.izoro.Dao.impl.MovieDaoImpl;

import com.izoro.service.Movieservice;
import com.izoro.vo.HadMovie;
import com.izoro.vo.Movie;
import com.izoro.vo.WanttoMovie;

public class MovieserviceImpl implements Movieservice {
    private MovieDaoImpl movieDaoImpl=new MovieDaoImpl();
    
	@Override
	public int insertHadMovie(int movieId, int peopleId) {
		return movieDaoImpl.insertHadMovie(movieId, peopleId);
	}

	@Override
	public int delteHadMovie(int hadMovieId) {
		return movieDaoImpl.delteHadMovie(hadMovieId);
	}

	@Override
	public List<HadMovie> showHadMovie(int peopleId) {
		return movieDaoImpl.showHadMovie(peopleId);
	}

	@Override
	public int insertWanttoMovie(int movieId, int peopleId) {
		return movieDaoImpl.insertWanttoMovie(movieId, peopleId);
	}

	@Override
	public int delteWantMovie(int hadMovieId) {
		return movieDaoImpl.delteWantMovie(hadMovieId);
	}

	@Override
	public List<WanttoMovie> showWantMovie(int peopleId) {
		return movieDaoImpl.showWantMovie(peopleId);
	}

	@Override
	public List<Movie> showMovieByleixing(String[] types, int page, int selfId) {
		return movieDaoImpl.showMovieByleixing(types, page, selfId);
	}

	@Override
	public List<Movie> SearchMovie(String search, int page) {
		return movieDaoImpl.SearchMovie(search, page);
	}

	@Override
	public List<Movie> SearchMovieBySpace(String movieType,String moveSpace, int page) {
		return movieDaoImpl.SearchMovieBySpace(movieType, moveSpace, page);
	}

	@Override
	public List<Movie> SearchMovieByTime(int page) {
		return movieDaoImpl.SearchMovieByTime(page);
	}

	@Override
	public List<Movie> SearchMovieByScore() {
		// TODO Auto-generated method stub
		return movieDaoImpl.SearchMovieByScore();
	}

	@Override
	public List<Movie> SearchMovieNewTime(int page) {
		return movieDaoImpl.SearchMovieNewTime(page);
	}

}
