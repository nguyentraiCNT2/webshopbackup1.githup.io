package webmobileshop.api.ADMIN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webmobileshop.api.OUTPUT.UserAddressOUTPUT;
import webmobileshop.dto.UserAddressDTO;
import webmobileshop.service.UserAddressService;

import javax.transaction.Transactional;
import java.util.List;


@RestController
@RequestMapping("/admin/dia-chi-nguoi-dung/api")
public class UserAddressAPI {
    @Autowired
    private final UserAddressService userAddressService;


    public UserAddressAPI(UserAddressService userAddressService) {
        this.userAddressService = userAddressService;
    }


    @GetMapping("/user-address/user-address-list")
    public UserAddressOUTPUT getAllUserAddress(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model){
        UserAddressOUTPUT result = new UserAddressOUTPUT();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(userAddressService.getAllUserAddress(pageable));
        result.setTotalPage((int) Math.ceil((double) (userAddressService.totalItem()) / limit));
        model.addAttribute("userTokenOUTPUT", result);
        return result;

    }
    @GetMapping("/user-address/user-address-by-id/{userAddressId}")
    public ResponseEntity<?> getByUserAddressId(@PathVariable Long userAddressId) {
        try {
            UserAddressDTO userAddressDTO = userAddressService.getByUserAddressId(userAddressId);

            return new ResponseEntity<>(userAddressDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserAddressDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/user-address/create-user-address")
    public ResponseEntity<String> createUserAddress(@RequestBody UserAddressDTO userAddressDTO) {
        try {
            userAddressService.createByUserAddress(userAddressDTO);

            return new ResponseEntity<>(" added successfully " , HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-user-address/{userAddressId}")
    public ResponseEntity<String> updateUserAddress(@PathVariable Long userAddressId, @RequestBody UserAddressDTO userAddressDTO) {
        try {
            userAddressDTO.setUserAddressId(userAddressId);
            userAddressService.updateByUserAddress(userAddressDTO);
            return new ResponseEntity<>(userAddressDTO+" Update successfully ", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Transactional
    @DeleteMapping("/user-address/delete/{userAddressId}")
    public ResponseEntity<String> deleteUserAddress(@PathVariable Long userAddressId) {
        try {
            userAddressService.deleteBYuserAddressID(userAddressId);
            return new ResponseEntity<>("delete successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
