package webmobileshop.Configproject.OpjectMapper;

import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;
import webmobileshop.dto.ChatRoomDTO;
import webmobileshop.entity.ChatRoom;

@Component
public class ChatRoomMapper {
    private final ImagesMapper imagesMapper;  // Assuming you have an ImagesMapper
    private final UserAccountMapper userAccountMapper;  // Assuming you have a UserAccountMapper
	  private final ModelMapper modelMapper;
		
    public ChatRoomMapper(ImagesMapper imagesMapper, UserAccountMapper userAccountMapper,ModelMapper modelMapper) {
        this.imagesMapper = imagesMapper;
        this.userAccountMapper = userAccountMapper;
    	this.modelMapper = modelMapper;
    }

    public ChatRoomDTO toDTO(ChatRoom entity) {
        ChatRoomDTO dto = new ChatRoomDTO();
        dto.setChatRoomId(entity.getChatRoomId());
        dto.setChatRoomName(entity.getChatRoomName());
        dto.setImagesId(entity.getImagesId().getImagesId());
        dto.setUserId(entity.getUserId().getUserId());
        dto.setBlockChatRoom(entity.isBlockChatRoom());
        return dto;
    }

    public ChatRoom toEntity(ChatRoomDTO dto) {
    	ChatRoom entity = new ChatRoom();
        entity.setChatRoomId(dto.getChatRoomId());
        entity.setChatRoomName(dto.getChatRoomName());
        // Assuming you have a method in your service to find ImagesEntity by imagesId
        // and set it to ChatRoomEntity using setImagesId() method.
        // entity.setImagesId(imagesService.findImagesById(dto.getImagesId()));
        // Assuming you have a method in your service to find UserAccountEntity by userId
        // and set it to ChatRoomEntity using setUserId() method.
        // entity.setUserId(userAccountService.findUserById(dto.getUserId()));
        entity.setBlockChatRoom(dto.isBlockChatRoom());
        return entity;
    }
}
