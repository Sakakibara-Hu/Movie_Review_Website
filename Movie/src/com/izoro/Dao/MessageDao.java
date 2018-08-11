package com.izoro.Dao;

import java.util.List;

import com.izoro.vo.Message;
import com.izoro.vo.MessageOne;

public interface MessageDao {

	//增加留言
	int insertMess(Message message);
	//删除留言
    int deleteMess(int messageId);
    //显示所有留言
    List<MessageOne> showByOne(int userId);
}
