package com.izoro.vo;

import java.util.Date;

public class Message {
    public Message(int messageId, int messageOneId, int messageTwoId, String messageContent, String messageTime) {
		super();
		this.messageId = messageId;
		this.messageOneId = messageOneId;
		this.messageTwoId = messageTwoId;
		this.messageContent = messageContent;
		this.messageTime = messageTime;
	}
	
    public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public int getMessageOneId() {
		return messageOneId;
	}
	public void setMessageOneId(int messageOneId) {
		this.messageOneId = messageOneId;
	}
	public int getMessageTwoId() {
		return messageTwoId;
	}
	public void setMessageTwoId(int messageTwoId) {
		this.messageTwoId = messageTwoId;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public String getMessageTime() {
		return messageTime;
	}
	public void setMessageTime(String messageTime) {
		this.messageTime = messageTime;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	int messageId;
	int messageOneId;
    int messageTwoId;
    String messageContent;
    String messageTime;
}
