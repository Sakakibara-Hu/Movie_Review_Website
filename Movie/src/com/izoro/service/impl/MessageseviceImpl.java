package com.izoro.service.impl;

import java.util.List;

import com.izoro.Dao.impl.MessageDaoImpl;
import com.izoro.service.Messagesevice;
import com.izoro.vo.Message;
import com.izoro.vo.MessageOne;

public class MessageseviceImpl implements Messagesevice {
    private MessageDaoImpl messageDaoImpl=new MessageDaoImpl();
	@Override
	public int insertMess(Message message) {
		// TODO Auto-generated method stub
		return messageDaoImpl.insertMess(message);
	}

	@Override
	public int deleteMess(int messageId) {
		return messageDaoImpl.deleteMess(messageId);
	}

	@Override
	public List<MessageOne> showByOne(int userId) {
		return messageDaoImpl.showByOne(userId);
	}

}
