package com.izoro.Dao;

import java.util.List;

import com.izoro.vo.HadMovie;
import com.izoro.vo.Movie;
import com.izoro.vo.WanttoMovie;

public interface MovieDao {

	//标记已看电影1
	int insertHadMovie(int movieId,int peopleId);
	//删除已看电影标记1
	int delteHadMovie(int hadMovieId);
	//查看已看电影1
	List<HadMovie> showHadMovie(int peopleId);
	//标记想看电影1
	int insertWanttoMovie(int movieId,int peopleId);
	//删除想看电影1
	int delteWantMovie(int wantMovieId);
	//查看想看电影1
	List<WanttoMovie> showWantMovie(int peopleId);
	
	
	//根据类型和内容推荐影片，可能有多种类型用逗号隔开，故使用数组，还要排除掉自己，故加一个id参数
	List<Movie> showMovieByleixing(String[] types,int page, int selfId);
	//按影片名字搜索（查）按演员或导演名搜索（查）电影类型
	List<Movie> SearchMovie(String search,int page);
	//根据电影制片地区/类型分类
	List<Movie> SearchMovieBySpace(String movieType,String moveSpace, int page);
	//根据电影上映时间分类(暂定)
	List<Movie> SearchMovieByTime(int pageNum);
   //展示全站评价排行前250名电影
	List<Movie> SearchMovieByScore();
	//展示最近一段时间内新片排行
	List<Movie> SearchMovieNewTime(int page);
	//具体电影
	Movie SearchByMovieId(int movieId);
}
