package webmobileshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import webmobileshop.Configproject.OpjectMapper.UserAddressMapper;
import webmobileshop.dto.UserAddressDTO;
import webmobileshop.entity.UserAccountEntity;
import webmobileshop.entity.UserAddressEntity;
import webmobileshop.repositorty.UserAccountRepository;
import webmobileshop.repositorty.UserAddressRepository;
import webmobileshop.service.UserAddressService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAddressServiceIMPL implements UserAddressService {
    @Autowired
    private final UserAddressRepository userAddressRepository;
    private ModelMapper modelMapper;
    private UserAddressMapper userAddressMapper;
    private UserAccountRepository userAccountRepository;

    public UserAddressServiceIMPL(UserAddressRepository userAddressRepository, ModelMapper modelMapper, UserAddressMapper userAddressMapper, UserAccountRepository userAccountRepository ) {
        this.userAddressRepository = userAddressRepository;
        this.modelMapper = modelMapper;
        this.userAddressMapper = userAddressMapper;
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserAddressDTO getByUserAddressId(Long userAddressId) {
        try {
            UserAddressEntity userAddressEntity = userAddressRepository.findByUserAddressId(userAddressId)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + userAddressId));
            return userAddressMapper.toDTO(userAddressEntity);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<UserAddressDTO> getAllUserAddress(Pageable pageable) {
        List<UserAddressDTO> results = new ArrayList<>();
        List<UserAddressEntity> userAddressEntities = userAddressRepository.findAll(pageable).getContent();
        for (UserAddressEntity item: userAddressEntities
        ) {
            UserAddressDTO userAddressDTO = userAddressMapper.toDTO(item);
            results.add(userAddressDTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) userAddressRepository.count();
    }

    @Override
    public List<UserAddressDTO> getByUserId(String userId) {
        List<UserAddressEntity> userAddressEntities = userAddressRepository.findByUserId(userId);
        return userAddressEntities.stream()
                .map(useraddress -> userAddressMapper.toDTO(useraddress))
                .collect(Collectors.toList());
    }

    @Override
    public void createByUserAddress(UserAddressDTO userAddressDTO) {
        if (userAddressDTO != null) {
            UserAddressEntity userAddressEntity = userAddressMapper.toEntity(userAddressDTO);
            UserAccountEntity userAccountEntity = userAccountRepository.findByuserId(userAddressDTO.getUserId()).orElse(null);
            if (userAddressEntity != null) {
                userAddressEntity.setUserId(userAccountEntity);
                userAddressRepository.save(userAddressEntity);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateByUserAddress(UserAddressDTO userAddressDTO) {
        UserAddressEntity existingUserAddress  = userAddressRepository.findByUserAddressId(userAddressDTO.getUserAddressId())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(userAddressDTO, existingUserAddress);
        userAddressRepository.save(existingUserAddress);
    }

    @Override
    public void deleteBYuserAddressID(Long userAddressId) {
        userAddressRepository.deleteByUserAddressId(userAddressId);
    }
}
