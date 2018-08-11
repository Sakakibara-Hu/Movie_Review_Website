package com.izoro.vo;

public class CommentOne {
	 public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentPeople() {
		return commentPeople;
	}
	public void setCommentPeople(String commentPeople) {
		this.commentPeople = commentPeople;
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
	public String getCommentMovieName() {
		return commentMovieName;
	}
	public void setCommentMovieName(String commentMovieName) {
		this.commentMovieName = commentMovieName;
	}
	public CommentOne(int commentId, String commentPeople, String commentTime, String commentContent,
			float commentLevel, int commentLikes, String commentMovieName) {
		super();
		this.commentId = commentId;
		this.commentPeople = commentPeople;
		this.commentTime = commentTime;
		this.commentContent = commentContent;
		this.commentLevel = commentLevel;
		this.commentLikes = commentLikes;
		this.commentMovieName = commentMovieName;
	}
	public CommentOne() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CommentOne [commentId=" + commentId + ", commentPeople=" + commentPeople + ", commentTime="
				+ commentTime + ", commentContent=" + commentContent + ", commentLevel=" + commentLevel
				+ ", commentLikes=" + commentLikes + ", commentMovieName=" + commentMovieName + "]";
	}
	int commentId;
     String commentPeople;
     String commentTime;
     String commentContent;
     float commentLevel;
     int commentLikes;
     String commentMovieName;
}
