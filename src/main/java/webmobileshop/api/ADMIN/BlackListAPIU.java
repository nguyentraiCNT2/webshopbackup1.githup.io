package webmobileshop.api.ADMIN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webmobileshop.api.OUTPUT.BlacklistOUTPUT;
import webmobileshop.api.OUTPUT.UserTokenOUTPUT;
import webmobileshop.dto.BlackListDTO;
import webmobileshop.dto.ProductDTO;
import webmobileshop.dto.UserAccountDTO;
import webmobileshop.dto.UserTokenDTO;
import webmobileshop.service.BlackListService;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/black-list-of-user/api")
public class BlackListAPIU {
    @Autowired
    private final BlackListService blackListService;

    public BlackListAPIU(BlackListService blackListService) {
        this.blackListService = blackListService;
    }

    @GetMapping("/black-list/user-black-list")
    public BlacklistOUTPUT getAllBlacklist(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model){
        BlacklistOUTPUT result = new BlacklistOUTPUT();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(blackListService.getAllBlackList(pageable));
        result.setTotalPage((int) Math.ceil((double) (blackListService.totalItem()) / limit));
        model.addAttribute("userTokenOUTPUT", result);
        return result;
    }

    @GetMapping("/black-list/get-by-user/{userId}")
    public ResponseEntity<String> findByUserId(@PathVariable String userId) {
        List<BlackListDTO> blackListDTOS = blackListService.getByUserId(userId);
        if (blackListDTOS == null) {
            return ResponseEntity.notFound().build();
        }
            Map<String, Object> response = new HashMap<>();
            response.put("blackListDTOS",blackListDTOS);
            return new ResponseEntity<>(response+"", HttpStatus.OK);
        }

    @GetMapping("/black-list/get-by-blackListid/{blackListId}")
    public ResponseEntity<?> getByBlackListId(@PathVariable Long blackListId) {
        try {
            BlackListDTO blackListDTO = blackListService.getByBlackListId(blackListId);

            return new ResponseEntity<>(blackListDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserAccountDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/admin/black-list/get-by-usererorr/{userErorr}")
    public ResponseEntity<?> getByUserErorr(@PathVariable String userErorr) {
        try {
            List<BlackListDTO> productDTOS = blackListService.getByUserErorr(userErorr);
            return new ResponseEntity<>(productDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/admin/create-black-list")
    public ResponseEntity<String> createBlackList(@RequestBody BlackListDTO blackListDTO) {
        try {
            blackListService.createBlackList(blackListDTO);

            return new ResponseEntity<>(" added successfully " , HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/admin/update-black-list/{blackListId}")
    public ResponseEntity<String> updateUserToken(@PathVariable Long blackListId, @RequestBody BlackListDTO blackListDTO) {
        try {
            blackListDTO.setBlackListId(blackListId);
            blackListService.updateBlackList(blackListDTO);
            return new ResponseEntity<>(blackListDTO+" Update successfully ", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    @DeleteMapping("/admin/delete-black-list-item/{blackListId}")
    public ResponseEntity<String> deleteUserToken(@PathVariable Long blackListId) {
        try {
            blackListService.deleteBlackList(blackListId);
            return new ResponseEntity<>("delete successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
