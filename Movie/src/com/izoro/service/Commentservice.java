package com.izoro.service;

import java.util.List;

import com.izoro.vo.Comment;
import com.izoro.vo.CommentOne;

public interface Commentservice {
	//增加评论
		int insertComment(Comment comment);
		//删除评论
		int deleteCommentByOwn(int commentId);
		//查看自己的评论
		List<CommentOne> showCommentByOwn(int peopleId);
		//修改自己的评论
		int updateComment(Comment comment);
		//显示评论By电影
		List<Comment> showComment(int movieId);
		//增加评论点赞数
		int addDianzan(int commentId);
		
		CommentOne showCommentByCommentId(int CommentId);
}
