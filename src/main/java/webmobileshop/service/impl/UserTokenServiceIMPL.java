package webmobileshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import webmobileshop.Configproject.OpjectMapper.UserAccountMapper;
import webmobileshop.Configproject.OpjectMapper.UserTokenMapper;
import webmobileshop.dto.UserAccountDTO;
import webmobileshop.dto.UserTokenDTO;
import webmobileshop.entity.UserAccountEntity;
import webmobileshop.entity.UserTokenEntity;
import webmobileshop.repositorty.UserAccountRepository;
import webmobileshop.repositorty.UserTokenRepository;
import webmobileshop.service.UserAccountService;
import webmobileshop.service.UserTokenService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserTokenServiceIMPL implements UserTokenService {
    @Autowired
    private final UserTokenRepository userTokenRepository;
    private ModelMapper modelMapper;
    private UserTokenMapper userTokenMapper;
    private UserAccountRepository userAccountRepository;
    private UserAccountMapper userAccountMapper;
    private UserAccountService userAccountService;

    public UserTokenServiceIMPL(UserTokenRepository userTokenRepository, ModelMapper modelMapper, UserTokenMapper userTokenMapper, UserAccountRepository userAccountRepository) {
        this.userTokenRepository = userTokenRepository;
        this.modelMapper = modelMapper;
        this.userTokenMapper = userTokenMapper;
        this.userAccountRepository = userAccountRepository;
    }


    @Override
    public UserTokenDTO getByUserTokenId(Long userTokenId) {
        try {
            UserTokenEntity userTokenEntity = userTokenRepository.findByUserTokenId(userTokenId)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + userTokenId));
            return userTokenMapper.toDTO(userTokenEntity);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<UserTokenDTO> getAllUserToken(Pageable pageable) {
        List<UserTokenDTO> results = new ArrayList<>();
        List<UserTokenEntity> userTokenEntityList = userTokenRepository.findAll(pageable).getContent();
        for (UserTokenEntity item: userTokenEntityList
        ) {
            UserTokenDTO userTokenDTO = userTokenMapper.toDTO(item);
            results.add(userTokenDTO);
        }
        return results;
    }

    @Override
    public List<UserTokenDTO> getByUser(String user) {
        List<UserTokenEntity> userTokenEntityList = userTokenRepository.findByUserUserId(user);
        return userTokenEntityList.stream()
                .map(userToken -> userTokenMapper.toDTO(userToken))
                .collect(Collectors.toList());
    }
    @Override
    public int totalItem() {
        return (int) userTokenRepository.count();
    }

    @Override
    public UserTokenDTO getByMainToken(String mainToken) {
        try {
        UserTokenEntity userTokenEntityList = userTokenRepository.findByMainToken(mainToken)
                .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + mainToken));
        return userTokenMapper.toDTO(userTokenEntityList);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public UserTokenDTO getByReplaceToken(String replaceToken) {
        try {
            UserTokenEntity userTokenEntityList = userTokenRepository.findByReplaceToken(replaceToken)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + replaceToken));
            return userTokenMapper.toDTO(userTokenEntityList);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }



    @Override
    public void createUserToken(UserTokenDTO userTokenDTO) {
        if (userTokenDTO != null) {
            UserTokenEntity userTokenEntity = userTokenMapper.toEntity(userTokenDTO);
            UserAccountEntity userAccountEntity = userAccountRepository.findByuserId(userTokenDTO.getUser()).orElse(null);
            if (userTokenEntity != null) {
                userTokenEntity.setUser(userAccountEntity);
                userTokenRepository.save(userTokenEntity);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateUserToken(UserTokenDTO userTokenDTO) {
        UserTokenEntity existingUser  = userTokenRepository.findByUserTokenId(userTokenDTO.getUserTokenId())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(userTokenDTO, existingUser);
        userTokenRepository.save(existingUser);
    }

    @Override
    public void deleteuserToken(Long userTokenId) {
        userTokenRepository.deleteByUserTokenId(userTokenId);
    }
}
