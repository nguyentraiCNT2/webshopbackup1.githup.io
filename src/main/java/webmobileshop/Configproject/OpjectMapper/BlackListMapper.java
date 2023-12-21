package webmobileshop.Configproject.OpjectMapper;

import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;
import webmobileshop.dto.BlackListDTO;
import webmobileshop.entity.BlackListEntity;

@Component
public class BlackListMapper {
    private final UserAccountMapper userAccountMapper;
    private final ModelMapper modelMapper;
    public BlackListMapper(UserAccountMapper userAccountMapper , ModelMapper modelMapper) {
        this.userAccountMapper = userAccountMapper;
        this.modelMapper = modelMapper;
    }

    public BlackListDTO toDTO(BlackListEntity entity) {
        BlackListDTO dto = new BlackListDTO();
        dto.setBlackListId(entity.getBlackListId());
        dto.setUserid(entity.getUserid().getUserId());
        dto.setUserErorr(entity.getUserErorr());
        return dto;
    }

    public BlackListEntity toEntity(BlackListDTO dto) {
        BlackListEntity entity = new BlackListEntity();
        entity.setBlackListId(dto.getBlackListId());
        entity.setUserErorr(dto.getUserErorr());
        return entity;
    }
}
