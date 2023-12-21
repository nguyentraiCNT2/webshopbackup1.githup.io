package webmobileshop.api.ADMIN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webmobileshop.Configproject.OpjectMapper.UserAccountMapper;
import webmobileshop.RanDom.TokenUtil;
import webmobileshop.api.OUTPUT.UserTokenOUTPUT;
import webmobileshop.dto.UserAccountDTO;
import webmobileshop.dto.UserTokenDTO;
import webmobileshop.entity.UserAccountEntity;
import webmobileshop.entity.UserTokenEntity;
import webmobileshop.service.UserAccountService;
import webmobileshop.service.UserTokenService;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/token-user/api")
public class UserTokenAPI {
    @Autowired
    private  final UserTokenService userTokenService;
    private UserAccountAPI userAccountAPI;
    private UserAccountService userAccountService;
    private UserAccountMapper userAccountMapper;
    public UserTokenAPI(UserTokenService userTokenService) {
        this.userTokenService = userTokenService;
    }

    @GetMapping("/token/user-token-list")
    public UserTokenOUTPUT getAllUserToken(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model){
        UserTokenOUTPUT result = new UserTokenOUTPUT();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(userTokenService.getAllUserToken(pageable));
        result.setTotalPage((int) Math.ceil((double) (userTokenService.totalItem()) / limit));
        model.addAttribute("userTokenOUTPUT", result);

        return result;

    }
        @GetMapping("/token/get-by-user/{userId}")
    public ResponseEntity<String> findByUserId(@PathVariable String userId) {
       List<UserTokenDTO>  userToken = userTokenService.getByUser(userId);

            if (userToken == null) {
            // Trả về 404 Not Found nếu không tìm thấy kết quả
            return ResponseEntity.notFound().build();

        }

        Map<String, Object> response = new HashMap<>();
        response.put("UserToken",userToken);
        // Trả về kết quả nếu tìm thấy
        return new ResponseEntity<>(response+"",HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<String> createUserToken(@RequestBody UserTokenDTO userTokenDTO) {
        try {
         userTokenService.createUserToken(userTokenDTO);

            return new ResponseEntity<>(" added successfully " , HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/token/{userTokenId}")
    public ResponseEntity<String> updateUserToken(@PathVariable Long userTokenId, @RequestBody UserTokenDTO userTokenDTO) {
        try {
            userTokenDTO.setUserTokenId(userTokenId);
            userTokenService.updateUserToken(userTokenDTO);
            return new ResponseEntity<>(userTokenDTO+" Update successfully ", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Transactional
    @DeleteMapping("/token/delete/{userTokenId}")
    public ResponseEntity<String> deleteUserToken(@PathVariable Long userTokenId) {
        try {
            userTokenService.deleteuserToken(userTokenId);
            return new ResponseEntity<>("delete successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
