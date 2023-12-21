package webmobileshop.Configproject.OpjectMapper;


import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;
import webmobileshop.dto.GuestDTO;
import webmobileshop.entity.GuestEntity;

@Component
public class GuestMapper {
	
	  private final ModelMapper modelMapper;
		
	    public GuestMapper(ModelMapper modelMapper) {
			this.modelMapper = modelMapper;
		}
    public GuestDTO toDTO(GuestEntity entity) {
        GuestDTO dto = new GuestDTO();
        dto.setQuestId(entity.getQuestId());
        dto.setQuestName(entity.getQuestName());
        dto.setQuestAddress(entity.getQuestAddress());
        dto.setQuestPhone(entity.getQuestPhone());
        dto.setQuestEmail(entity.getQuestEmail());
        dto.setFristName(entity.getFristName());
        dto.setLastName(entity.getLastName());
        return dto;
    }

    public GuestEntity toEntity(GuestDTO dto) {
        GuestEntity entity = new GuestEntity();
        entity.setQuestId(dto.getQuestId());
        entity.setQuestName(dto.getQuestName());
        entity.setQuestAddress(dto.getQuestAddress());
        entity.setQuestPhone(dto.getQuestPhone());
        entity.setQuestEmail(dto.getQuestEmail());
        entity.setFristName(dto.getFristName());
        entity.setLastName(dto.getLastName());
        return entity;
    }
}
