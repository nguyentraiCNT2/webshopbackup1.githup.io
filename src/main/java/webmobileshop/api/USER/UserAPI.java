package webmobileshop.api.USER;

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
import webmobileshop.service.UserAccountService;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tai-khoan-nguoi-dung/api")
public class UserAPI {
    @Autowired
    private final UserAccountService userAccountService;

    public UserAPI(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String userName, @RequestParam String password) {
        try {
            UserAccountDTO user = userAccountService.login(userName, password);
            long expirationMillis = 3600000;
            String token = TokenUtil.generateToken(userName,password, expirationMillis);
            Map<String, Object> response = new HashMap<>();
            response.put("user", user);
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (EntityNotFoundException ex) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "User not found with username: " + userName);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        } catch (RuntimeException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Login failed: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);

        }
    }
    //hiển thị toàn bộ dữ liệu trong bảng
    @GetMapping("/user-list")
    public UserAccountOutPut getAllUserAccount(@RequestParam("page") int page,
                                               @RequestParam("limit") int limit, Model model) {

        UserAccountOutPut result = new UserAccountOutPut();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(userAccountService.getAllUserAccount(pageable));
        result.setTotalPage((int) Math.ceil((double) (userAccountService.totalItem()) / limit));
        model.addAttribute("userAccountOutput", result);
        return result;

    }
    //hiển thị dữ liệu trong bảng theo id
    @GetMapping("/{userId}")
    public ResponseEntity<?> getByUserId(@PathVariable String userId) {
        try {
            UserAccountDTO userAccountDTO = userAccountService.getByUserId(userId);
            return new ResponseEntity<>(userAccountDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserAccountDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/search/mat-khau-nguoi-dung/{password}")
    public ResponseEntity<?> getByPassword(@PathVariable String password) {
        try {
            List<UserAccountDTO> userAccountDTO = userAccountService.getByPassword(password);
            return new ResponseEntity<>(userAccountDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/search/ten-nguoi-dung/{userName}")
    public ResponseEntity<?> getByUserName(@PathVariable String userName) {
        try {
            List<UserAccountDTO> userAccountDTO = userAccountService.getByUserName(userName);
            return new ResponseEntity<>(userAccountDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/search/ho-da-dang-ky-nguoi-dung/{fristName}")
    public ResponseEntity<?> getByFristName(@PathVariable String fristName) {
        try {
            List<UserAccountDTO> userAccountDTO = userAccountService.getByFristName(fristName);
            return new ResponseEntity<>(userAccountDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/search/ten-da-dang-ky-nguoi-dung/{fristName}")
    public ResponseEntity<?> getByLastName(@PathVariable String lastName) {
        try {
            List<UserAccountDTO> userAccountDTO = userAccountService.getByLastName(lastName);
            return new ResponseEntity<>(userAccountDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/search/email-nguoi-dung/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable String email) {
        try {
            List<UserAccountDTO> userAccountDTO = userAccountService.getByEmail(email);
            return new ResponseEntity<>(userAccountDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/search/phone-nguoi-dung/{phone}")
    public ResponseEntity<?> getByPhone(@PathVariable String phone) {
        try {
            List<UserAccountDTO> userAccountDTO = userAccountService.getByPhone(phone);
            return new ResponseEntity<>(userAccountDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/trang-thai-nguoi-dung/{status}")
    public ResponseEntity<?> getByStatus(@PathVariable boolean status) {
        try {
            List<UserAccountDTO> userAccountDTO = userAccountService.getByStatus(status);
            return new ResponseEntity<>(userAccountDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/chan-nguoi-dung/{blockUser}")
    public ResponseEntity<?> getByBlockUser(@PathVariable boolean blockUser) {
        try {
            List<UserAccountDTO> userAccountDTO = userAccountService.getByBlockUser(blockUser);
            return new ResponseEntity<>(userAccountDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/search/gioi-tinh-nguoi-dung/{genDer}")
    public ResponseEntity<?> getByGenDer(@PathVariable String genDer) {
        try {
            List<UserAccountDTO> userAccountDTO = userAccountService.getByGenDer(genDer);
            return new ResponseEntity<>(userAccountDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/by-images")
    public ResponseEntity<List<UserAccountDTO>> getByImages(@RequestBody ImagesDTO imagesDTO) {
        try {
            List<UserAccountDTO> userAccountDTOList = userAccountService.getByImages(imagesDTO);
            return new ResponseEntity<>(userAccountDTOList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserAccountDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/by-role")
    public ResponseEntity<List<UserAccountDTO>> getByRoleDTO(@RequestBody RoleDTO roleDTO) {
        try {
            List<UserAccountDTO> userAccountDTOList = userAccountService.getByRoleDTO(roleDTO);
            return new ResponseEntity<>(userAccountDTOList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserAccountDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // thêm dư liệu vào vào bảng
    @PostMapping
    public ResponseEntity<String> createUserAccount(@RequestBody UserAccountDTO userAccountDTO) {
        try {

            String randomId = RandomID.generateRandomId(25);
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
    @PutMapping("/{userId}")
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
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteProduct(@PathVariable String userId) {
        try {
            userAccountService.deleteUserAccount(userId);
            ;
            return new ResponseEntity<>("Xóa Ảnh thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
