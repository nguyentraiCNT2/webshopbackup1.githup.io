package webmobileshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import webmobileshop.Configproject.OpjectMapper.BlackListMapper;
import webmobileshop.dto.BlackListDTO;
import webmobileshop.dto.UserTokenDTO;
import webmobileshop.entity.BlackListEntity;
import webmobileshop.entity.UserAccountEntity;
import webmobileshop.entity.UserTokenEntity;
import webmobileshop.repositorty.BlackListRepository;
import webmobileshop.repositorty.UserAccountRepository;
import webmobileshop.service.BlackListService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlackListServiceIMPL implements BlackListService {
    @Autowired
    private final BlackListRepository blackListRepository;
    private ModelMapper modelMapper;
    private BlackListMapper blackListMapper;
    private UserAccountRepository userAccountRepository;

    public BlackListServiceIMPL(BlackListRepository blackListRepository, ModelMapper modelMapper, BlackListMapper blackListMapper, UserAccountRepository userAccountRepository) {
        this.blackListRepository = blackListRepository;
        this.modelMapper = modelMapper;
        this.blackListMapper = blackListMapper;
        this.userAccountRepository = userAccountRepository;
    }


    @Override
    public BlackListDTO getByBlackListId(Long blackListId) {
        try {
            BlackListEntity blackListEntity = blackListRepository.findByBlackListId(blackListId)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + blackListId));
            return blackListMapper.toDTO(blackListEntity);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<BlackListDTO> getAllBlackList(Pageable pageable) {
        List<BlackListDTO> results = new ArrayList<>();
        List<BlackListEntity> blackListEntities = blackListRepository.findAll(pageable).getContent();
        for (BlackListEntity item: blackListEntities
        ) {
            BlackListDTO userTokenDTO = blackListMapper.toDTO(item);
            results.add(userTokenDTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) blackListRepository.count();
    }

    @Override
    public List<BlackListDTO> getByUserErorr(String userErorr) {
        try {
          List<BlackListEntity>   blackListEntities = blackListRepository.findByUserErorr(userErorr);
            return blackListEntities.stream()
                    .map(blackListMapper::toDTO)
                    .collect(Collectors.toList());
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<BlackListDTO> getByUserId(String userId) {
        try {
            List<BlackListEntity>   blackListEntities = blackListRepository.findByUserid(userId);
            return blackListEntities.stream()
                    .map(blackListMapper::toDTO)
                    .collect(Collectors.toList());
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public void createBlackList(BlackListDTO blackListDTO) {
        if (blackListDTO != null) {
            BlackListEntity blackListEntity = blackListMapper.toEntity(blackListDTO);
            UserAccountEntity userAccountEntity = userAccountRepository.findByuserId(blackListDTO.getUserid()).orElse(null);
            if (blackListEntity != null) {
                blackListEntity.setUserid(userAccountEntity);
                blackListRepository.save(blackListEntity);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateBlackList(BlackListDTO blackListDTO) {
        BlackListEntity existingBlackList  = blackListRepository.findByBlackListId(blackListDTO.getBlackListId())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(blackListDTO, existingBlackList);
        blackListRepository.save(existingBlackList);
    }

    @Override
    public void deleteBlackList(Long blackListId) {
        blackListRepository.deleteByBlackListId(blackListId);
    }
}
