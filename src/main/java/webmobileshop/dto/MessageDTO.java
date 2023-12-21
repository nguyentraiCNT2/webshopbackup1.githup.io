package webmobileshop.dto;

import java.sql.Date;

import webmobileshop.entity.ChatRoom;
import webmobileshop.entity.UserAccountEntity;

public class MessageDTO {
	private Long MessageId;
	private String UserId;
	private Long ChatRoomId;
	private String ChatRoomContent;
	private Date Timestamp;
	private boolean Status;
	public Long getMessageId() {
		return MessageId;
	}
	public void setMessageId(Long messageId) {
		MessageId = messageId;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public Long getChatRoomId() {
		return ChatRoomId;
	}
	public void setChatRoomId(Long chatRoomId) {
		ChatRoomId = chatRoomId;
	}
	public String getChatRoomContent() {
		return ChatRoomContent;
	}
	public void setChatRoomContent(String chatRoomContent) {
		ChatRoomContent = chatRoomContent;
	}
	public Date getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(Date timestamp) {
		Timestamp = timestamp;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	
}
