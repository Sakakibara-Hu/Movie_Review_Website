package com.izoro.Dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.izoro.Dao.CommentDao;
import com.izoro.vo.Comment;
import com.izoro.vo.CommentOne;
import com.izoro.vo.WanttoMovie;

import JDBC.JDBCTemplates;

public class CommentDaoImpl extends JDBCTemplates<Comment> implements CommentDao {

	@Override
	protected Comment rowMapper(ResultSet rs) {
		Comment comment=new Comment();
		try {
			comment.setCommentContent(rs.getString("commentContent"));
			comment.setCommentId(rs.getInt("commentId"));
			comment.setCommentLevel(rs.getFloat("commentLevel"));
			comment.setCommentLikes(rs.getInt("commentLikes"));
			comment.setCommentMovieId(rs.getInt("commentMovieId"));
			comment.setCommentPeople(rs.getInt("commentPeople"));
			comment.setCommentTime(rs.getString("commentTime"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return comment;
	}

	@Override
	public int insertComment(Comment comment) {
		String sql="INSERT INTO comment(commentPeople,commentTime,commentContent,commentLevel,commentLikes,commentMovieId)VALUES(?,?,?,?,?,?)";
		Object[] param={comment.getCommentPeople(),comment.getCommentTime(),comment.getCommentContent(),comment.getCommentLevel(),comment.getCommentLikes(),comment.getCommentMovieId()};
		return update(sql,param);
	}

	@Override
	public int deleteCommentByOwn(int commentId) {
		String sql="DELETE FROM comment WHERE commentId=?";
		Object[] param={commentId};
		return update(sql,param);
	}

	@Override
	public List<CommentOne> showCommentByOwn(int peopleId) {
		String sql="SELECT*FROM comment WHERE commentPeople=?";
		Object[] param={peopleId};
		List<Comment> commentlist=selectAll(sql,param);
		String sql1="SELECT userName FROM users WHERE userId=?";
		Object[] param1={peopleId};
		String name=oneString(sql1,param1);
		List<CommentOne> comments=new ArrayList<CommentOne>();
		if(commentlist!=null){
		for(int i=0;i<commentlist.size();i++){
			CommentOne commentone=new CommentOne();
			String sql4="SELECT moviename FROM movie WHERE movieId=?";
			Object[] param4={commentlist.get(i).getCommentMovieId()};
			String movieName=oneString(sql4,param4);
			commentone.setCommentContent(commentlist.get(i).getCommentContent());
			commentone.setCommentId(commentlist.get(i).getCommentId());
			commentone.setCommentLevel(commentlist.get(i).getCommentLevel());
			commentone.setCommentLikes(commentlist.get(i).getCommentLikes());
			commentone.setCommentMovieName(movieName);
			commentone.setCommentPeople(name);
			commentone.setCommentTime(commentlist.get(i).getCommentTime());
			comments.add(commentone);
		}
		return comments;
		}return null;
	}

	@Override
	public int updateComment(Comment comment) {
		String sql="UPDATE comment SET commentPeople=?,commentTime=?,commentContent=?,commentLevel=?,commentLikes=?,commentMovieId=? WHERE commentId=?";
		Object[] param={comment.getCommentPeople(),comment.getCommentTime(),comment.getCommentContent(),comment.getCommentLevel(),0,comment.getCommentMovieId(),comment.getCommentId()};
		return update(sql,param);
	}

	@Override
	public List<Comment> showComment(int movieId) {
		String sql="SELECT*FROM comment WHERE commentMovieId=?";
		Object[] param={movieId};
		return selectAll(sql,param);
	}

	@Override
	public int addDianzan(int commentId) {
		String sql="UPDATE comment SET commentLikes=commentLikes+1 WHERE commentId=?";
		Object[] param={commentId};
		return update(sql,param);
	}

	@Override
	public CommentOne showCommentByCommentId(int CommentId) {
		String sql="SELECT*FROM comment WHERE commentId=?";
		Object[] param={CommentId};
		Comment comment=selectOne(sql,param);
		if(comment!=null){
			CommentOne commentone=new CommentOne();
			String sql1="SELECT userName FROM users WHERE userId=?";
			Object[] param1={comment.getCommentPeople()};
			String name=oneString(sql1,param1);
			String sql4="SELECT moviename FROM movie WHERE movieId=?";
			Object[] param4={comment.getCommentMovieId()};
			String movieName=oneString(sql4,param4);
			commentone.setCommentContent(comment.getCommentContent());
			commentone.setCommentId(comment.getCommentId());
			commentone.setCommentLevel(comment.getCommentLevel());
			commentone.setCommentLikes(comment.getCommentLikes());
			commentone.setCommentMovieName(movieName);
			commentone.setCommentPeople(name);
			commentone.setCommentTime(comment.getCommentTime());
			return commentone;
		}
		return null;
	}

}
