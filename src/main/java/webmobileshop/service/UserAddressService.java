package webmobileshop.service;

import org.springframework.data.domain.Pageable;
import webmobileshop.dto.UserAddressDTO;

import java.util.List;

public interface UserAddressService {
    UserAddressDTO getByUserAddressId(Long userAddressId);

    List<UserAddressDTO> getAllUserAddress(Pageable pageable);
    int totalItem();
    List<UserAddressDTO> getByUserId(String userId);

    void createByUserAddress(UserAddressDTO userAddressDTO);

    void updateByUserAddress( UserAddressDTO userAddressDTO);

    void deleteBYuserAddressID(Long userAddressId);
}
