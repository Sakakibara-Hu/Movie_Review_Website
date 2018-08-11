package com.izoro.vo;

import java.util.Date;

public class Comment {
     public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getCommentPeople() {
		return commentPeople;
	}
	public void setCommentPeople(int i) {
		this.commentPeople = i;
	}
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public float getCommentLevel() {
		return commentLevel;
	}
	public void setCommentLevel(float commentLevel) {
		this.commentLevel = commentLevel;
	}
	public int getCommentLikes() {
		return commentLikes;
	}
	public void setCommentLikes(int commentLikes) {
		this.commentLikes = commentLikes;
	}
	public int getCommentMovieId() {
		return commentMovieId;
	}
	public void setCommentMovieId(int commentMovieId) {
		this.commentMovieId = commentMovieId;
	}
	public Comment(int commentId, int commentPeople, String commentTime, String commentContent, float commentLevel,
			int commentLikes, int commentMovieId) {
		super();
		this.commentId = commentId;
		this.commentPeople = commentPeople;
		this.commentTime = commentTime;
		this.commentContent = commentContent;
		this.commentLevel = commentLevel;
		this.commentLikes = commentLikes;
		this.commentMovieId = commentMovieId;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentPeople=" + commentPeople + ", commentTime=" + commentTime
				+ ", commentContent=" + commentContent + ", commentLevel=" + commentLevel + ", commentLikes="
				+ commentLikes + ", commentMovieId=" + commentMovieId + "]";
	}
	
	 int commentId;
     int commentPeople;
     String commentTime;
     String commentContent;
     float commentLevel;
     int commentLikes;
     int commentMovieId;
}
