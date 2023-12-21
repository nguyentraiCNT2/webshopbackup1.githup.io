package webmobileshop.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "Message")
@Data
public class MessageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MessageId")
	private Long MessageId;
	@ManyToOne
	@JoinColumn(name = "UserId")
	private UserAccountEntity UserId;
	@ManyToOne
	@JoinColumn(name = "ChatRoomId")
	private ChatRoom ChatRoomId;
	@Column(name = "ChatRoomContent",columnDefinition = "NVARCHAR(MAX)")
	private String ChatRoomContent;
	@Column(name = "Timestamp")
	private Date Timestamp;
	@Column(name = "Status")
	private boolean Status;
	public Long getMessageId() {
		return MessageId;
	}
	public void setMessageId(Long messageId) {
		MessageId = messageId;
	}
	public UserAccountEntity getUserId() {
		return UserId;
	}
	public void setUserId(UserAccountEntity userId) {
		UserId = userId;
	}
	public ChatRoom getChatRoomId() {
		return ChatRoomId;
	}
	public void setChatRoomId(ChatRoom chatRoomId) {
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
