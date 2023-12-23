package webmobileshop.service;

import org.springframework.data.domain.Pageable;
import webmobileshop.dto.BlackListDTO;
import webmobileshop.dto.UserTokenDTO;

import java.util.List;

public interface BlackListService {
    BlackListDTO getByBlackListId(Long blackListId);

    List<BlackListDTO> getAllBlackList(Pageable pageable);
    int totalItem();

    List<BlackListDTO> getByUserErorr(String userErorr);

    List<BlackListDTO> getByUserId(String userId);

    void createBlackList(BlackListDTO blackListDTO);

    void updateBlackList( BlackListDTO blackListDTO);

    void deleteBlackList(Long blackListId);

}
