package webmobileshop.Configproject.OpjectMapper;
import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;
import webmobileshop.dto.UserAddressDTO;
import webmobileshop.entity.UserAddressEntity;

@Component
public class UserAddressMapper {

	  private final ModelMapper modelMapper;
		
	    public UserAddressMapper(ModelMapper modelMapper) {
			this.modelMapper = modelMapper;
		}
    public UserAddressDTO toDTO(UserAddressEntity entity) {
        UserAddressDTO dto = new UserAddressDTO();
        dto.setUserAddressId(entity.getUserAddressId());
        dto.setUserId(entity.getUserId().getUserId()); // Assuming getUserId() returns UserAccountEntity
        dto.setAddress(entity.getAddress());
        dto.setCountry(entity.getCountry());
        dto.setProvince(entity.getProvince());
        dto.setDistrict(entity.getDistrict());
        dto.setCommune(entity.getCommune());
        dto.setApartmentNumber(entity.getApartmentNumber());
        dto.setPhone(entity.getPhone());
        return dto;
    }

    public UserAddressEntity toEntity(UserAddressDTO dto) {
        UserAddressEntity entity = new UserAddressEntity();
        entity.setUserAddressId(dto.getUserAddressId());
        // Assuming you have a method in your service to find UserAccountEntity by userId
        // and set it to UserAddressEntity using setUserId() method.
        // entity.setUserId(userService.findUserById(dto.getUserId()));
        entity.setAddress(dto.getAddress());
        entity.setCountry(dto.getCountry());
        entity.setProvince(dto.getProvince());
        entity.setDistrict(dto.getDistrict());
        entity.setCommune(dto.getCommune());
        entity.setApartmentNumber(dto.getApartmentNumber());
        entity.setPhone(dto.getPhone());
        return entity;
    }
}
