package com.izoro.vo;

public class MessageOne {
	

	public MessageOne() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getMessageoneName() {
		return messageoneName;
	}
	public void setMessageoneName(String messageoneName) {
		this.messageoneName = messageoneName;
	}
	public String getMessageTWoName() {
		return messageTWoName;
	}
	public void setMessageTWoName(String messageTWoName) {
		this.messageTWoName = messageTWoName;
	}
	public MessageOne(int messageId, int messageOneId, int messageTwoId, String messageContent, String messageTime,
			String messageoneName, String messageTWoName) {
		super();
		this.messageId = messageId;
		this.messageOneId = messageOneId;
		this.messageTwoId = messageTwoId;
		this.messageContent = messageContent;
		this.messageTime = messageTime;
		this.messageoneName = messageoneName;
		this.messageTWoName = messageTWoName;
	}
	@Override
	public String toString() {
		return "MessageOne [messageId=" + messageId + ", messageOneId=" + messageOneId + ", messageTwoId="
				+ messageTwoId + ", messageContent=" + messageContent + ", messageTime=" + messageTime
				+ ", messageoneName=" + messageoneName + ", messageTWoName=" + messageTWoName + "]";
	}
	int messageId;
	int messageOneId;
    int messageTwoId;
    String messageContent;
    String messageTime;
	String messageoneName;
	String messageTWoName;
}
