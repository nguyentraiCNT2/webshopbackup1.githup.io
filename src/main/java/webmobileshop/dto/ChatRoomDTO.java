package webmobileshop.dto;

public class ChatRoomDTO {
	private Long ChatRoomId;
	private String ChatRoomName;
	private Long ImagesId;
	private String UserId;
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
	public Long getImagesId() {
		return ImagesId;
	}
	public void setImagesId(Long imagesId) {
		ImagesId = imagesId;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public boolean isBlockChatRoom() {
		return blockChatRoom;
	}
	public void setBlockChatRoom(boolean blockChatRoom) {
		this.blockChatRoom = blockChatRoom;
	}
	

}
