package com.izoro.vo;

public class WanttoMovie {

    @Override
	public String toString() {
		return "WanttoMovie [movieId=" + movieId + ", movieDirect=" + movieDirect + ", movieMainpeople="
				+ movieMainpeople + ", movieType=" + movieType + ", movieTime=" + movieTime + ", moveSpace=" + moveSpace
				+ ", moviename=" + moviename + ", movieIntuduce=" + movieIntuduce + ", movieAmount=" + movieAmount
				+ ", movieScore=" + movieScore + ", wantMovieId=" + wantMovieId + "]";
	}
	public WanttoMovie(int movieId, String movieDirect, String movieMainpeople, String movieType, String movieTime,
			String moveSpace, String moviename, String movieIntuduce, int movieAmount, float movieScore,
			int wantMovieId) {
		super();
		this.movieId = movieId;
		this.movieDirect = movieDirect;
		this.movieMainpeople = movieMainpeople;
		this.movieType = movieType;
		this.movieTime = movieTime;
		this.moveSpace = moveSpace;
		this.moviename = moviename;
		this.movieIntuduce = movieIntuduce;
		this.movieAmount = movieAmount;
		this.movieScore = movieScore;
		this.wantMovieId = wantMovieId;
	}
	public WanttoMovie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieDirect() {
		return movieDirect;
	}
	public void setMovieDirect(String movieDirect) {
		this.movieDirect = movieDirect;
	}
	public String getMovieMainpeople() {
		return movieMainpeople;
	}
	public void setMovieMainpeople(String movieMainpeople) {
		this.movieMainpeople = movieMainpeople;
	}
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	public String getMovieTime() {
		return movieTime;
	}
	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}
	public String getMoveSpace() {
		return moveSpace;
	}
	public void setMoveSpace(String moveSpace) {
		this.moveSpace = moveSpace;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getMovieIntuduce() {
		return movieIntuduce;
	}
	public void setMovieIntuduce(String movieIntuduce) {
		this.movieIntuduce = movieIntuduce;
	}
	public int getMovieAmount() {
		return movieAmount;
	}
	public void setMovieAmount(int movieAmount) {
		this.movieAmount = movieAmount;
	}
	public float getMovieScore() {
		return movieScore;
	}
	public void setMovieScore(float movieScore) {
		this.movieScore = movieScore;
	}
	public int getWantMovieId() {
		return wantMovieId;
	}
	public void setWantMovieId(int wantMovieId) {
		this.wantMovieId = wantMovieId;
	}
	int movieId;
	String movieDirect;
    String movieMainpeople;
    String movieType;
    String movieTime;
    String moveSpace;
    String moviename;
    String movieIntuduce;
    int movieAmount;
    float movieScore;
    int wantMovieId;

}
