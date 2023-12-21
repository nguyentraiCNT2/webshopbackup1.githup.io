package webmobileshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ChatRoom")
public class ChatRoom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ChatRoomId")
	private Long ChatRoomId;
	@Column(name = "ChatRoomName",columnDefinition = "NVARCHAR(MAX)")
	private String ChatRoomName;
	@ManyToOne
	@JoinColumn(name = "ImagesId")
	private ImagesEntity ImagesId;
	@ManyToOne
	@JoinColumn(name = "UserId")
	private UserAccountEntity UserId;
	@Column(name = "blockChatRoom")
	private boolean blockChatRoom;

	public Long getChatRoomId() {
		return ChatRoomId;
	}

	public void setChatRoomId(Long chatRoomId) {
		ChatRoomId = chatRoomId;
	}

	public String getChatRoomName() {
		return ChatRoomName;
	}

	public void setChatRoomName(String chatRoomName) {
		ChatRoomName = chatRoomName;
	}

	public ImagesEntity getImagesId() {
		return ImagesId;
	}

	public void setImagesId(ImagesEntity imagesId) {
		ImagesId = imagesId;
	}

	public UserAccountEntity getUserId() {
		return UserId;
	}

	public void setUserId(UserAccountEntity userId) {
		UserId = userId;
	}

	public boolean isBlockChatRoom() {
		return blockChatRoom;
	}

	public void setBlockChatRoom(boolean blockChatRoom) {
		this.blockChatRoom = blockChatRoom;
	}

}
