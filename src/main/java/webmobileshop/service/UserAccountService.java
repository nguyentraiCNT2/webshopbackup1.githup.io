package webmobileshop.service;

import org.springframework.data.domain.Pageable;
import webmobileshop.dto.ImagesDTO;
import webmobileshop.dto.RoleDTO;
import webmobileshop.dto.UserAccountDTO;

import java.util.List;

public interface UserAccountService {
    UserAccountDTO getByUserId(String userId);

    UserAccountDTO login(String userName, String password);

    List<UserAccountDTO> getAllUserAccount(Pageable pageable);
    int totalItem();
    List<UserAccountDTO> getByUserName(String userName);

    List<UserAccountDTO> getByPassword(String password);

    List<UserAccountDTO> getByFristName(String fristName);

    List<UserAccountDTO> getByLastName(String lastName);

    List<UserAccountDTO> getByEmail(String email);

    List<UserAccountDTO> getByPhone(String phone);

    List<UserAccountDTO> getByStatus(boolean status);

    List<UserAccountDTO> getByBlockUser(boolean blockUser);

    List<UserAccountDTO> getByGenDer(String genDer);

    List<UserAccountDTO> getByImages(ImagesDTO images);

    List<UserAccountDTO> getByRoleDTO(RoleDTO roleDTO);

    void createUserAccount(UserAccountDTO userAccountDTO);

    void updateUserAccount( UserAccountDTO userAccountDTO);

    void deleteUserAccount(String userId);
}
