package com.izoro.Dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.izoro.Dao.MovieDao;
import com.izoro.vo.HadMovie;
import com.izoro.vo.Movie;
import com.izoro.vo.WanttoMovie;

import JDBC.JDBCTemplates;

public class MovieDaoImpl  extends JDBCTemplates<Movie> implements MovieDao {

	@Override
	public int insertHadMovie(int movieId, int peopleId) {
		String sql="INSERT INTO hadsee(MovieId,peopleId)VALUES(?,?)";
		Object[] param={movieId,peopleId};
		return update(sql,param);
	}

	@Override
	public int delteHadMovie(int hadMovieId) {
		String sql="DELETE*FROM hadsee WHERE hadseeid=?";
		Object[] param={hadMovieId};
		return update(sql,param);
	}

	@Override
	public List<HadMovie> showHadMovie(int peopleId) {
		String sql="SELECT hadseeid FROM hadsee WHERE peopleId=?";
		Object[] param={peopleId};
		List<Integer> hadseeids=intList(sql,param);
		List<HadMovie> movies=new ArrayList<HadMovie>();
		HadMovie hadMovie=new HadMovie();
		for(int i=0;i<hadseeids.size();i++){
			String sql1="SELECT MovieId FROM hadsee WHERE hadseeid=?";
			Object[] param1={hadseeids.get(i)};
			String MovieId=oneString(sql1,param1);
			String sql3="SELECT*FROM movie WHERE movieId=? ORDER BY movieTime DESC";
			Object[] param3={MovieId};
		    Movie Movies= selectOne(sql3,param3);
		    hadMovie.setMoveSpace(Movies.getMoveSpace());
		    hadMovie.sethadMovieId(hadseeids.get(i));
		    hadMovie.setMovieAmount(Movies.getMovieAmount());
		    hadMovie.setMovieDirect(Movies.getMovieDirect());
		    hadMovie.setMovieId(Movies.getMovieId());
		    hadMovie.setMovieIntuduce(Movies.getMovieIntuduce());
		    hadMovie.setMovieMainpeople(Movies.getMovieMainpeople());
		    hadMovie.setMoviename(Movies.getMoviename());
		    hadMovie.setMovieScore(Movies.getMovieScore());
		    hadMovie.setMovieTime(Movies.getMovieTime());
		    hadMovie.setMovieType(Movies.getMovieType());
		    movies.add(hadMovie);
		}
	
		return movies;
	}

	@Override
	public int insertWanttoMovie(int movieId, int peopleId) {
		String sql="INSERT INTO wanttosee(movieId,peopleId)VALUES(?,?)";
		Object[] param={movieId,peopleId};
		return update(sql,param);
	}

	@Override
	public int delteWantMovie(int wantMovieId) {
		String sql="DELETE FROM wanttosee WHERE movieId=?";
		Object[] param={wantMovieId};
		return update(sql,param);
	}

	@Override
	public List<WanttoMovie> showWantMovie(int peopleId) {
		String sql="SELECT wanttoseeid FROM wanttosee WHERE peopleId=?";
		Object[] param={peopleId};
		List<Integer> wanttoseeid=intList(sql,param);
		List<WanttoMovie> movies=new ArrayList<WanttoMovie>();
		if(wanttoseeid!=null){
		for(int i=0;i<wanttoseeid.size();i++){
			WanttoMovie wanttoMovie=new WanttoMovie();
			String sql1="SELECT DISTINCT MovieId FROM wanttosee WHERE wanttoseeid=?";
			Object[] param1={wanttoseeid.get(i)};
			int MovieId=oneInt(sql1,param1);
			System.out.println(MovieId);
			String sql3="SELECT*FROM movie WHERE movieId=? ORDER BY movieTime DESC";
			Object[] param3={MovieId};
		    Movie Movies= selectOne(sql3,param3);
		    wanttoMovie.setMoveSpace(Movies.getMoveSpace());
		    wanttoMovie.setWantMovieId(wanttoseeid.get(i));
		    wanttoMovie.setMovieAmount(Movies.getMovieAmount());
		    wanttoMovie.setMovieDirect(Movies.getMovieDirect());
		    wanttoMovie.setMovieId(Movies.getMovieId());
		    wanttoMovie.setMovieIntuduce(Movies.getMovieIntuduce());
		    wanttoMovie.setMovieMainpeople(Movies.getMovieMainpeople());
		    wanttoMovie.setMoviename(Movies.getMoviename());
		    wanttoMovie.setMovieScore(Movies.getMovieScore());
		    wanttoMovie.setMovieTime(Movies.getMovieTime());
		    wanttoMovie.setMovieType(Movies.getMovieType());
		    movies.add(wanttoMovie);
		}
		return movies;
		}
		return null;
	}

	@Override
	public List<Movie> showMovieByleixing(String[] types, int page, int selfId) {
		String sql1 = "SELECT*FROM movie WHERE (movieType like ?) and movieId<>? ORDER BY movieTime DESC limit ?,?";
		String sql2 = "SELECT*FROM movie WHERE (movieType like ? or?) and movieId<>? ORDER BY movieTime DESC limit ?,?";
		String sql3 = "SELECT*FROM movie WHERE (movieType like ? or? or ?) and movieId<>? ORDER BY movieTime DESC limit ?,?";
		
		
		if(types.length == 1){
			Object[] param1={"%"+types[0]+"%", selfId, page*20, 20};
			return selectAll(sql1,param1);
		}
		if(types.length == 2){
			Object[] param2={"%"+types[0]+"%", "%"+types[1]+"%", selfId, page*20, 20};
			return selectAll(sql2,param2);
		}
		if(types.length == 3){
			Object[] param3={"%"+types[0]+"%", "%"+types[1]+"%", "%"+types[2]+"%", selfId, page*20, 20};
			return selectAll(sql3,param3);
		}
		else{
			return null;
		}
		//String sql="SELECT*FROM movie WHERE movieType like ? ORDER BY movieTime DESC limit ?,?";
		//Object[] param={"%"+neirong+"%",page*20,20};
		//return selectAll(sql,param);
	}

	@Override
	public List<Movie> SearchMovie(String search, int page) {
		String sql="SELECT*FROM movie WHERE movieType LIKE ? OR movieMainpeople LIKE ? OR movieDirect LIKE ? OR moviename LIKE ? ORDER BY movieTime DESC limit ?,?";
		Object[] param={"%"+search+"%","%"+search+"%","%"+search+"%","%"+search+"%",page*20,20};
		return selectAll(sql,param);
	}

	@Override
	public List<Movie> SearchMovieBySpace(String movieType,String moveSpace, int page) {
		String sql="SELECT*FROM movie WHERE movieType LIKE ? AND moveSpace LIKE ? ORDER BY movieTime DESC limit ?,?";
		Object[] param={"%"+movieType+"%","%"+moveSpace+"%",page*20,20};
		return selectAll(sql,param);
	}
   //时间分类暂时不要，没图我没想好怎么分类
	@Override
	public List<Movie> SearchMovieByTime(int pageNum) {
		int come=pageNum*20;
		String sql="SELECT*FROM movie ORDER BY movieTime DESC limit ?,?";
		Object[] param={come,20};
		return selectAll(sql,param);
	}

	@Override
	public List<Movie> SearchMovieByScore() {
		String sql="SELECT*FROM movie ORDER BY movieScore DESC";
		return selectByAll(sql);
	}
    //
	@Override
	public List<Movie> SearchMovieNewTime(int page) {
		int come=page*20;
		String sql="SELECT*FROM movie ORDER BY movieTime DESC limit ?,?";
		Object[] param={come,20};
		return selectAll(sql,param);
	}

	@Override
	protected Movie rowMapper(ResultSet rs) {
		Movie movie=new Movie();
		try {
			movie.setMoveSpace(rs.getString("moveSpace"));
			movie.setMovieAmount(rs.getInt("movieAmount"));
			movie.setMovieDirect(rs.getString("movieDirect"));
			movie.setMovieId(rs.getInt("movieId"));
			movie.setMovieIntuduce(rs.getString("movieIntuduce"));
			movie.setMovieMainpeople(rs.getString("movieMainpeople"));
			movie.setMoviename(rs.getString("moviename"));
			movie.setMovieScore(rs.getInt("movieScore"));
			movie.setMovieTime(rs.getString("movieTime"));
			movie.setMovieType(rs.getString("movieType"));
			movie.setMovieImage(rs.getString("movieImage"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return movie;
	}

	@Override
	public Movie SearchByMovieId(int movieId) {
		String sql="SELECT*FROM movie WHERE movieId=?";
		Object[] param={movieId};
		return selectOne(sql,param);
	}


}
