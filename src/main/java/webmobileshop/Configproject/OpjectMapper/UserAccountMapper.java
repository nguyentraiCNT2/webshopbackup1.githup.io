package webmobileshop.Configproject.OpjectMapper;


import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;
import webmobileshop.dto.UserAccountDTO;
import webmobileshop.entity.UserAccountEntity;

@Component
public class UserAccountMapper {

	  private final ModelMapper modelMapper;

    public UserAccountMapper(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
    }
    public UserAccountDTO toDTO(UserAccountEntity entity) {
        UserAccountDTO dto = new UserAccountDTO();
        dto.setUserId(entity.getUserId());
        dto.setUserName(entity.getUserName());
        dto.setPassword(entity.getPassword());
        dto.setFristName(entity.getFristName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setGenDer(entity.getGenDer());
        dto.setImages(entity.getImages().getImagesId()); // Assuming getImages() returns ImagesEntity
        dto.setStatus(entity.isStatus());
        dto.setRoleDTO(entity.getRoleDTO().getRoleId()); // Assuming getRoleId() returns RoleEntity
        dto.setBlockUser(entity.isBlockUser());
        return dto;
    }

    public UserAccountEntity toEntity(UserAccountDTO dto) {
        UserAccountEntity entity = new UserAccountEntity();
        entity.setUserId(dto.getUserId());
        entity.setUserName(dto.getUserName());
        entity.setPassword(dto.getPassword());
        entity.setFristName(dto.getFristName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setGenDer(dto.getGenDer());
        entity.setStatus(dto.isStatus());
        entity.setBlockUser(dto.isBlockUser());
        return entity;
    }
}
