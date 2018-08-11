package com.izoro.service.impl;

import java.util.List;

import com.izoro.service.Commentservice;
import com.izoro.vo.Comment;
import com.izoro.vo.CommentOne;
import com.izoro.Dao.impl.CommentDaoImpl;
public class CommentserviceImpl implements Commentservice {
	private CommentDaoImpl CommentDaoImpl=new CommentDaoImpl();
	@Override
	public int insertComment(Comment comment) {
		// TODO Auto-generated method stub
		return CommentDaoImpl.insertComment(comment);
	}

	@Override
	public int deleteCommentByOwn(int commentId) {
		// TODO Auto-generated method stub
		return CommentDaoImpl.deleteCommentByOwn(commentId);
	}

	@Override
	public List<CommentOne> showCommentByOwn(int peopleId) {
		// TODO Auto-generated method stub
		return CommentDaoImpl.showCommentByOwn(peopleId);
	}

	@Override
	public int updateComment(Comment comment) {
		// TODO Auto-generated method stub
		return CommentDaoImpl.updateComment(comment);
	}

	@Override
	public List<Comment> showComment(int movieId) {
		// TODO Auto-generated method stub
		return CommentDaoImpl.showComment(movieId);
	}

	@Override
	public int addDianzan(int commentId) {
		// TODO Auto-generated method stub
		return CommentDaoImpl.addDianzan(commentId);
	}

	@Override
	public CommentOne showCommentByCommentId(int CommentId) {
		// TODO Auto-generated method stub
		return CommentDaoImpl.showCommentByCommentId(CommentId);
	}



}
