package com.izoro.Dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.izoro.Dao.MessageDao;
import com.izoro.vo.CommentOne;
import com.izoro.vo.Message;
import com.izoro.vo.MessageOne;

import JDBC.JDBCTemplates;

public class MessageDaoImpl  extends JDBCTemplates<Message> implements MessageDao {

	@Override
	protected Message rowMapper(ResultSet rs) {
		Message message=new Message();
		try {
			message.setMessageTwoId(rs.getInt("messageTwoId"));
			message.setMessageContent(rs.getString("messageContent"));
			message.setMessageId(rs.getInt("messageId"));
			message.setMessageOneId(rs.getInt("messageOneId"));
			message.setMessageTime(rs.getString("messageTime"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public int insertMess(Message message) {
		String sql="INSERT INTO message(messageContent,messageOneId,messageTime,messageTwoId)VALUES(?,?,?,?)";
		Object[] param={message.getMessageContent(),message.getMessageOneId(),message.getMessageTime(),message.getMessageTwoId()};
		return update(sql,param);
	}

	@Override
	public int deleteMess(int messageId) {
		String sql="DELETE FROM message WHERE messageId=?";
		Object[] param={messageId};
		return update(sql,param);
	}

	@Override
	public List<MessageOne> showByOne(int messageTwoId) {
		String sql="SELECT*FROM message WHERE messageTwoId=?";
		Object[] param={messageTwoId};
		List<Message> Messagelist=selectAll(sql,param);
		List<MessageOne> messageonelist=new ArrayList<MessageOne>();
		
		if(Messagelist!=null){
		for(int i=0;i<Messagelist.size();i++){
			MessageOne messageOne=new MessageOne();
			String sql1="SELECT userName FROM users WHERE userId=?";
			Object[] param1={Messagelist.get(i).getMessageOneId()};
			String onename=oneString(sql1,param1);
			String sql4="SELECT userName FROM users WHERE userId=?";
			Object[] param4={Messagelist.get(i).getMessageTwoId()};
			String twoname=oneString(sql4,param4);
			messageOne.setMessageContent(Messagelist.get(i).getMessageContent());
			messageOne.setMessageId(Messagelist.get(i).getMessageId());
			messageOne.setMessageOneId(Messagelist.get(i).getMessageOneId());
			messageOne.setMessageoneName(onename);
			messageOne.setMessageTime(Messagelist.get(i).getMessageTime());
			messageOne.setMessageTwoId(Messagelist.get(i).getMessageTwoId());
			messageOne.setMessageTWoName(twoname);
			messageonelist.add(messageOne);
		
		}
		return messageonelist;
		}return null;
	}

}

