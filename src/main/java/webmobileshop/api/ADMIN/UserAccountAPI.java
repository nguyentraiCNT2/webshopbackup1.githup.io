package webmobileshop.api.ADMIN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webmobileshop.RanDom.RandomID;
import webmobileshop.RanDom.TokenUtil;
import webmobileshop.api.OUTPUT.UserAccountOutPut;
import webmobileshop.dto.ImagesDTO;
import webmobileshop.dto.RoleDTO;
import webmobileshop.dto.UserAccountDTO;
import webmobileshop.dto.UserTokenDTO;
import webmobileshop.repositorty.UserAccountRepository;
import webmobileshop.repositorty.UserTokenRepository;
import webmobileshop.service.UserAccountService;
import webmobileshop.service.UserTokenService;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user-list-of-admin/api")
public class UserAccountAPI {
    @Autowired
    private final UserAccountService userAccountService;
    private UserTokenAPI userTokenAPI;
    private UserTokenRepository userTokenRepository;
    private UserAccountRepository userAccountRepository;
    private   UserTokenService userTokenService;

    public UserAccountAPI(UserAccountService userAccountService, UserTokenAPI userTokenAPI, UserTokenRepository userTokenRepository, UserAccountRepository userAccountRepository, UserTokenService userTokenService) {
        this.userAccountService = userAccountService;
        this.userTokenAPI = userTokenAPI;
        this.userTokenRepository = userTokenRepository;
        this.userAccountRepository = userAccountRepository;
        this.userTokenService = userTokenService;
    }


    @PostMapping("/admin/login-admin")
    public ResponseEntity<?> login(@RequestParam String userName, @RequestParam String password, HttpSession session) {
try {
    UserAccountDTO user = userAccountService.login(userName, password);
    LocalDateTime currentDateTime = LocalDateTime.now();
    LocalDateTime futureDateTime = currentDateTime.plus(Duration.ofHours(1));
    long expirationMillis = 3600000;
    String mainToken = TokenUtil.generateToken(userName, password, expirationMillis);
    String replaceToken = TokenUtil.generateToken(userName, password, expirationMillis);
    UserTokenDTO userTokenDTO = new UserTokenDTO();
    Date date = new Date();
    userTokenDTO.setUser(user.getUserId());
    userTokenDTO.setExpiredtime(date);
    userTokenDTO.setMainToken(mainToken);
    userTokenDTO.setReplaceToken(replaceToken);
    userTokenDTO.setTime((long) futureDateTime.getHour());

    userTokenAPI.createUserToken(userTokenDTO);
    session.setAttribute("Token", mainToken);
    Map<String, Object> response = new HashMap<>();
    response.put("token", mainToken);
    response.put("user", user);
    return new ResponseEntity<>(response, HttpStatus.OK);
}catch (Exception e) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", "loi k sac dinh ");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    //hiển thị toàn bộ dữ liệu trong bảng
    @GetMapping("/admin/user-list")
    public UserAccountOutPut getAllUserAccount(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
            UserAccountOutPut result = new UserAccountOutPut();
            result.setPage(page);
            Pageable pageable = new PageRequest(page - 1, limit);
            result.setListResult(userAccountService.getAllUserAccount(pageable));
            result.setTotalPage((int) Math.ceil((double) (userAccountService.totalItem()) / limit));
        model.addAttribute("userAccountOutput", result);
            return result;

    }
    //hiển thị dữ liệu trong bảng theo id
    @GetMapping("/admin/user-by-id/{userId}")
    public ResponseEntity<?> getByUserId(@PathVariable String userId) {
        try {
            UserAccountDTO userAccountDTO = userAccountService.getByUserId(userId);

            return new ResponseEntity<>(userAccountDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserAccountDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/admin/search/user-password/{password}")
    public ResponseEntity<?> getByPassword(@PathVariable String password) {
        try {
            List<UserAccountDTO> userAccountDTO = userAccountService.getByPassword(password);
            return new ResponseEntity<>(userAccountDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
        @GetMapping("/admin/search/user-name/{userName}")
    public ResponseEntity<?> getByUserName(@PathVariable String userName) {
        try {
            List<UserAccountDTO> userAccountDTO = userAccountService.getByUserName(userName);
            return new ResponseEntity<>(userAccountDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/admin/search/frist-name/{fristName}")
    public ResponseEntity<?> getByFristName(@PathVariable String fristName) {
        try {
            List<UserAccountDTO> userAccountDTO = userAccountService.getByFristName(fristName);
            return new ResponseEntity<>(userAccountDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/admin/search/last-name/{fristName}")
    public ResponseEntity<?> getByLastName(@PathVariable String lastName) {
        try {
            List<UserAccountDTO> userAccountDTO = userAccountService.getByLastName(lastName);
            return new ResponseEntity<>(userAccountDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/admin/search/user-email/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable String email) {
        try {
            List<UserAccountDTO> userAccountDTO = userAccountService.getByEmail(email);
            return new ResponseEntity<>(userAccountDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/admin/search/user-phone/{phone}")
    public ResponseEntity<?> getByPhone(@PathVariable String phone) {
        try {
            List<UserAccountDTO> userAccountDTO = userAccountService.getByPhone(phone);
            return new ResponseEntity<>(userAccountDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/admin/search/user-status/{status}")
    public ResponseEntity<?> getByStatus(@PathVariable boolean status) {
        try {
            List<UserAccountDTO> userAccountDTO = userAccountService.getByStatus(status);
            return new ResponseEntity<>(userAccountDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/admin/search/user-block/{blockUser}")
    public ResponseEntity<?> getByBlockUser(@PathVariable boolean blockUser) {
        try {
            List<UserAccountDTO> userAccountDTO = userAccountService.getByBlockUser(blockUser);
            return new ResponseEntity<>(userAccountDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/admin/search/user-gender/{genDer}")
    public ResponseEntity<?> getByGenDer(@PathVariable String genDer) {
        try {
            List<UserAccountDTO> userAccountDTO = userAccountService.getByGenDer(genDer);
            return new ResponseEntity<>(userAccountDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/admin/by-images")
    public ResponseEntity<List<UserAccountDTO>> getByImages(@RequestBody ImagesDTO imagesDTO) {
        try {
            List<UserAccountDTO> userAccountDTOList = userAccountService.getByImages(imagesDTO);
            return new ResponseEntity<>(userAccountDTOList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserAccountDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/admin/by-role")
    public ResponseEntity<List<UserAccountDTO>> getByRoleDTO(@RequestBody RoleDTO roleDTO) {
        try {
            List<UserAccountDTO> userAccountDTOList = userAccountService.getByRoleDTO(roleDTO);
            return new ResponseEntity<>(userAccountDTOList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserAccountDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // thêm dư liệu vào vào bảng
    @PostMapping("/admin/create-user")
    public ResponseEntity<String> createUserAccount(@RequestBody UserAccountDTO userAccountDTO) {
        try {

            String randomId =RandomID.generateRandomId(25);
            userAccountDTO.setUserId(randomId);
            userAccountDTO.setStatus(true);
            userAccountDTO.setBlockUser(false);
            userAccountDTO.setRoleDTO((long) 1);
            userAccountService.createUserAccount(userAccountDTO);
            String taikhoan = userAccountDTO.getUserName();
            String matkhau = userAccountDTO.getPassword();// Thời gian hết hạn token, 1 giờ trong ví dụ này
            long expirationMillis = 3600000;
            String token = TokenUtil.generateToken(taikhoan,matkhau, expirationMillis);
            return new ResponseEntity<>("more success " + token, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // sửa dữ liệu theo
    @PutMapping("/admin/update-user/{userId}")
    public ResponseEntity<String> updateUserAccount(@PathVariable String userId, @RequestBody UserAccountDTO userAccountDTO) {
        try {
            userAccountDTO.setUserId(userId);
            userAccountService.updateUserAccount(userAccountDTO);
            return new ResponseEntity<>(userAccountDTO+"Cập nhật quyền người dùng thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // xóa dữ liệu
    @Transactional
    @DeleteMapping("/admin/delete-user/{userId}")
    public ResponseEntity<String> deleteUserAccount(@PathVariable String userId) {
        try {
            userAccountService.deleteUserAccount(userId);
            return new ResponseEntity<>("Xóa Ảnh thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
