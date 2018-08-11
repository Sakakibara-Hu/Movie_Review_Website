package com.izoro.vo;

public class HadMovie {

	 @Override
	public String toString() {
		return "HadMovie [movieId=" + movieId + ", movieDirect=" + movieDirect + ", movieMainpeople=" + movieMainpeople
				+ ", movieType=" + movieType + ", movieTime=" + movieTime + ", moveSpace=" + moveSpace + ", moviename="
				+ moviename + ", movieIntuduce=" + movieIntuduce + ", movieAmount=" + movieAmount + ", movieScore="
				+ movieScore + ", hadMovieId=" + hadMovieId + "]";
	}
	public HadMovie(int movieId, String movieDirect, String movieMainpeople, String movieType, String movieTime,
			String moveSpace, String moviename, String movieIntuduce, int movieAmount, float movieScore,
			int hadMovieId) {
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
		this.hadMovieId = hadMovieId;
	}
	public HadMovie() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((moveSpace == null) ? 0 : moveSpace.hashCode());
		result = prime * result + movieAmount;
		result = prime * result + ((movieDirect == null) ? 0 : movieDirect.hashCode());
		result = prime * result + movieId;
		result = prime * result + ((movieIntuduce == null) ? 0 : movieIntuduce.hashCode());
		result = prime * result + ((movieMainpeople == null) ? 0 : movieMainpeople.hashCode());
		result = prime * result + Float.floatToIntBits(movieScore);
		result = prime * result + ((movieTime == null) ? 0 : movieTime.hashCode());
		result = prime * result + ((movieType == null) ? 0 : movieType.hashCode());
		result = prime * result + ((moviename == null) ? 0 : moviename.hashCode());
		result = prime * result + hadMovieId;
		return result;
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
	public int gethadMovieId() {
		return hadMovieId;
	}
	public void sethadMovieId(int hadMovieId) {
		this.hadMovieId = hadMovieId;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HadMovie other = (HadMovie) obj;
		if (moveSpace == null) {
			if (other.moveSpace != null)
				return false;
		} else if (!moveSpace.equals(other.moveSpace))
			return false;
		if (movieAmount != other.movieAmount)
			return false;
		if (movieDirect == null) {
			if (other.movieDirect != null)
				return false;
		} else if (!movieDirect.equals(other.movieDirect))
			return false;
		if (movieId != other.movieId)
			return false;
		if (movieIntuduce == null) {
			if (other.movieIntuduce != null)
				return false;
		} else if (!movieIntuduce.equals(other.movieIntuduce))
			return false;
		if (movieMainpeople == null) {
			if (other.movieMainpeople != null)
				return false;
		} else if (!movieMainpeople.equals(other.movieMainpeople))
			return false;
		if (Float.floatToIntBits(movieScore) != Float.floatToIntBits(other.movieScore))
			return false;
		if (movieTime == null) {
			if (other.movieTime != null)
				return false;
		} else if (!movieTime.equals(other.movieTime))
			return false;
		if (movieType == null) {
			if (other.movieType != null)
				return false;
		} else if (!movieType.equals(other.movieType))
			return false;
		if (moviename == null) {
			if (other.moviename != null)
				return false;
		} else if (!moviename.equals(other.moviename))
			return false;
		if (hadMovieId != other.hadMovieId)
			return false;
		return true;
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
     int hadMovieId;
}
