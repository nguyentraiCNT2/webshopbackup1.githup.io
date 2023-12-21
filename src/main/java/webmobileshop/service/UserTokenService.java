package webmobileshop.service;

import org.springframework.data.domain.Pageable;
import webmobileshop.dto.UserAccountDTO;
import webmobileshop.dto.UserTokenDTO;
import webmobileshop.entity.UserAccountEntity;

import java.util.List;

public interface UserTokenService {
    UserTokenDTO getByUserTokenId(Long userTokenId);

    List<UserTokenDTO> getAllUserToken(Pageable pageable);
    int totalItem();
    UserTokenDTO getByMainToken(String mainToken);

    UserTokenDTO getByReplaceToken(String replaceToken);

    List<UserTokenDTO> getByUser(String user);

    void createUserToken(UserTokenDTO userTokenDTO);

    void updateUserToken( UserTokenDTO userTokenDTO);

    void deleteuserToken(Long userTokenId);
}
