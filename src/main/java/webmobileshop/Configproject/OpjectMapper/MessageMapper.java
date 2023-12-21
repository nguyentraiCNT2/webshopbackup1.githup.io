package webmobileshop.Configproject.OpjectMapper;

import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;
import webmobileshop.dto.MessageDTO;
import webmobileshop.entity.MessageEntity;

@Component
public class MessageMapper {
    private final UserAccountMapper userAccountMapper;
    private final ChatRoomMapper chatRoomMapper;

	  private final ModelMapper modelMapper;
    public MessageMapper(UserAccountMapper userAccountMapper, ChatRoomMapper chatRoomMapper,ModelMapper modelMapper) {
        this.userAccountMapper = userAccountMapper;
        this.chatRoomMapper = chatRoomMapper;
        this.modelMapper = modelMapper;
    }

    public MessageDTO toDTO(MessageEntity entity) {
        MessageDTO dto = new MessageDTO();
        dto.setMessageId(entity.getMessageId());
        dto.setUserId(entity.getUserId().getUserId());
        dto.setChatRoomId(entity.getChatRoomId().getChatRoomId());
        dto.setChatRoomContent(entity.getChatRoomContent());
        // Convert Date to String as needed
        dto.setTimestamp(entity.getTimestamp());
        dto.setStatus(entity.isStatus());
        return dto;
    }

    public MessageEntity toEntity(MessageDTO dto) {
        MessageEntity entity = new MessageEntity();
        entity.setMessageId(dto.getMessageId());
        // Assuming you have a method in your service to find UserAccountEntity by userId
        // and set it to MessageEntity using setUserId() method.
        // entity.setUserId(userAccountService.findUserById(dto.getUserId()));
        // Assuming you have a method in your service to find ChatRoomEntity by chatRoomId
        // and set it to MessageEntity using setChatRoomId() method.
        // entity.setChatRoomId(chatRoomService.findChatRoomById(dto.getChatRoomId()));
        entity.setChatRoomContent(dto.getChatRoomContent());
        // Convert String to Date as needed
        // entity.setTimestamp(Date.valueOf(dto.getTimestamp()));
        entity.setStatus(dto.isStatus());
        return entity;
    }
}
