package webmobileshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import webmobileshop.Configproject.OpjectMapper.UserAccountMapper;
import webmobileshop.RanDom.CustomValidationException;
import webmobileshop.RanDom.TokenUtil;
import webmobileshop.dto.ImagesDTO;
import webmobileshop.dto.RoleDTO;
import webmobileshop.dto.UserAccountDTO;
import webmobileshop.dto.UserTokenDTO;
import webmobileshop.entity.ImagesEntity;
import webmobileshop.entity.RoleEntity;
import webmobileshop.entity.UserAccountEntity;
import webmobileshop.repositorty.ImagesRepository;
import webmobileshop.repositorty.RoleRepository;
import webmobileshop.repositorty.UserAccountRepository;
import webmobileshop.service.UserAccountService;
import  webmobileshop.RanDom.passwordcheckd;
import webmobileshop.service.UserTokenService;

import javax.persistence.EntityNotFoundException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class UserAccountServiceIMPL implements UserAccountService {

    private final UserAccountRepository userAccountRepository;
    private UserAccountMapper userAccountMapper;
    private RoleRepository roleRepository;
    private ImagesRepository imagesRepository;
    private ModelMapper modelMapper;
    private UserTokenService userTokenService;

    @Autowired
    public UserAccountServiceIMPL(UserAccountRepository userAccountRepository, UserAccountMapper userAccountMapper, ModelMapper modelMapper, RoleRepository roleRepository, ImagesRepository imagesRepository) {
        this.userAccountRepository = userAccountRepository;
        this.userAccountMapper = userAccountMapper;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
        this.imagesRepository = imagesRepository;
    }

    @Override
    public UserAccountDTO getByUserId(String userId) {
        try {
            UserAccountEntity userAccountEntity = userAccountRepository.findByuserId(userId)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + userId));
            return userAccountMapper.toDTO(userAccountEntity);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public UserAccountDTO login(String userName, String password) {
            boolean checkpass = false;
            List<UserAccountEntity> userAccountEntities = userAccountRepository.findByuserName(userName);

            if (userAccountEntities.isEmpty()) {
                throw new EntityNotFoundException("Không tìm thấy người dùng với tên đăng nhập: " + userName);
            }

            UserAccountEntity userAccountEntity = new UserAccountEntity();
            for (int i = 0; i < userAccountEntities.size(); i++) {
                userAccountEntity = (userAccountEntities.get(i));
                if (userAccountEntity.getPassword().equals(password)) {
                    checkpass = false;

                } else {
                    checkpass = true;
                }
            }
            if (checkpass == false) {

                return userAccountMapper.toDTO(userAccountEntity);
            }
            else  {
                throw new RuntimeException("Mật khẩu không đúng");
            }

    }


    @Override
    public List<UserAccountDTO> getAllUserAccount(Pageable pageable) {
        List<UserAccountDTO> results = new ArrayList<>();
        List<UserAccountEntity> userAccountEntityList = userAccountRepository.findAll(pageable).getContent();
        for (UserAccountEntity item: userAccountEntityList
             ) {
            UserAccountDTO userAccountDTO = userAccountMapper.toDTO(item);
            results.add(userAccountDTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) userAccountRepository.count();
    }

    @Override
    public List<UserAccountDTO> getByUserName(String userName) {
        List<UserAccountEntity> userAccountEntityList = userAccountRepository.findByuserName(userName);
        return userAccountEntityList.stream()
                .map(userAccount -> userAccountMapper.toDTO(userAccount))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserAccountDTO> getByPassword(String password) {
        List<UserAccountEntity> userAccountEntityList = userAccountRepository.findByPassword(password);
        return userAccountEntityList.stream()
                .map(userAccount -> userAccountMapper.toDTO(userAccount))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserAccountDTO> getByFristName(String fristName) {
        List<UserAccountEntity> userAccountEntityList = userAccountRepository.findByfristName(fristName);
        return userAccountEntityList.stream()
                .map(userAccount -> userAccountMapper.toDTO(userAccount))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserAccountDTO> getByLastName(String lastName) {
        List<UserAccountEntity> userAccountEntityList = userAccountRepository.findUserByLastName(lastName);
        return userAccountEntityList.stream()
                .map(userAccount -> userAccountMapper.toDTO(userAccount))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserAccountDTO> getByEmail(String email) {
            String Gmail = email+".com";
        List<UserAccountEntity> userAccountEntityList = userAccountRepository.findByemail(Gmail);
        return userAccountEntityList.stream()
                .map(userAccount -> userAccountMapper.toDTO(userAccount))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserAccountDTO> getByPhone(String phone) {
        List<UserAccountEntity> userAccountEntityList = userAccountRepository.findByphone(phone);
        return userAccountEntityList.stream()
                .map(userAccount -> userAccountMapper.toDTO(userAccount))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserAccountDTO> getByStatus(boolean status) {
        List<UserAccountEntity> userAccountEntityList = userAccountRepository.findBystatus(status);
        return userAccountEntityList.stream()
                .map(userAccount -> userAccountMapper.toDTO(userAccount))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserAccountDTO> getByBlockUser(boolean blockUser) {
        List<UserAccountEntity> userAccountEntityList = userAccountRepository.findByblockUser(blockUser);
        return userAccountEntityList.stream()
                .map(userAccount -> userAccountMapper.toDTO(userAccount))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserAccountDTO> getByGenDer(String genDer) {
        List<UserAccountEntity> userAccountEntityList = userAccountRepository.findBygenDer(genDer);
        return userAccountEntityList.stream()
                .map(userAccount ->userAccountMapper.toDTO(userAccount))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserAccountDTO> getByImages(ImagesDTO images) {
        List<UserAccountEntity> userAccountEntityList = userAccountRepository.findByImages(images);
        return userAccountEntityList.stream()
                .map(userAccount -> userAccountMapper.toDTO(userAccount))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserAccountDTO> getByRoleDTO(RoleDTO roleDTO) {
        List<UserAccountEntity> userAccountEntityList = userAccountRepository.findByRoleDTO(roleDTO);
        return userAccountEntityList.stream()
                .map(userAccount -> userAccountMapper.toDTO(userAccount))
                .collect(Collectors.toList());
    }

    @Override
    public void createUserAccount(UserAccountDTO userAccountDTO) throws CustomValidationException {
        List<UserAccountEntity> userAccountname = userAccountRepository.findByuserName(userAccountDTO.getUserName());
        List<UserAccountEntity> userAccountemail = userAccountRepository.findByemail(userAccountDTO.getEmail());
        boolean hasDuplicates = passwordcheckd.checkDuplicates(userAccountDTO.getUserName());
        boolean veck = false;
        int dem = 0;

        if (userAccountDTO != null) {
            for (int i = 0; i < userAccountname.size(); i++) {
                if (userAccountDTO.getUserName().equals(userAccountname.get(i).getUserName())) {
                    veck = true;
                }
            }

            for (int i = 0; i < userAccountemail.size(); i++) {
                if (userAccountDTO.getUserName().equals(userAccountemail.get(i).getEmail())) {
                    dem++;
                }
            }

            if (veck) {
                throw new CustomValidationException(Arrays.asList("Tài khoản này đã tồn tại"));
            } else if (dem >= 4) {
                throw new CustomValidationException(Arrays.asList("Một email chỉ có thể dùng được 4 tài khoản"));
            } else if (passwordcheckd.containsleght(userAccountDTO.getPassword()) < 6 || passwordcheckd.containsleght(userAccountDTO.getPassword()) > 20) {
                throw new CustomValidationException(Arrays.asList("Mật khẩu ít nhất 6 ký tự và nhiều nhất 20 ký tự"));
            } else if (passwordcheckd.containsWhitespace(userAccountDTO.getPassword())) {
                throw new CustomValidationException(Arrays.asList("Mật khẩu không thể chứa khoảng trắng"));
            } else {
                UserAccountEntity userAccountEntity = userAccountMapper.toEntity(userAccountDTO);
                RoleEntity roleEntity = roleRepository.findByRoleId(userAccountDTO.getRoleDTO()).orElse(null);
                ImagesEntity imagesEntity = imagesRepository.findByImagesId(userAccountDTO.getImages()).orElse(null);

                if (userAccountEntity != null) {
                    userAccountEntity.setRoleDTO(roleEntity);
                    userAccountEntity.setImages(imagesEntity);
                    userAccountRepository.save(userAccountEntity);
                } else {
                    throw new RuntimeException("Không lấy được dữ liệu của Entity");
                }
            }
        } else {
            throw new RuntimeException("Không lấy được dữ liệu của DTO");
        }
    }



    @Override
    public void updateUserAccount(UserAccountDTO userAccountDTO) {
        UserAccountEntity existingUser  = userAccountRepository.findByuserId(userAccountDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(userAccountDTO, existingUser);
        userAccountRepository.save(existingUser);
    }

    @Override
    public void deleteUserAccount(String userId) {
        userAccountRepository.deleteByuserId(userId);
    }
}
