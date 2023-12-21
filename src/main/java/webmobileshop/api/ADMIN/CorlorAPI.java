package webmobileshop.api.ADMIN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webmobileshop.api.OUTPUT.CorlorOUTPUT;
import webmobileshop.api.OUTPUT.VideosOUTPUT;
import webmobileshop.dto.CorlorDTO;
import webmobileshop.dto.UserAddressDTO;
import webmobileshop.dto.VideoDTO;
import webmobileshop.service.CorlorService;

import java.util.List;

@RestController
@RequestMapping("/admin/corlor-products/api")
public class CorlorAPI {
    @Autowired
    private final CorlorService corlorService;

    public CorlorAPI(CorlorService corlorService) {
        this.corlorService = corlorService;
    }

    @GetMapping("/admin/corlor-list")
    public CorlorOUTPUT getAllCorlor(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model){
        CorlorOUTPUT result = new CorlorOUTPUT();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(corlorService.getAllCorlor(pageable));
        result.setTotalPage((int) Math.ceil((double) (corlorService.totalItem()) / limit));
        model.addAttribute("VideosOUTPUT", result);
        return result;

    }

    @GetMapping("/admin/corlor/corlor-by-id/{corlorId}")
    public ResponseEntity<?> getByCorlorId(@PathVariable Long corlorId) {
        try {
            CorlorDTO corlorDTO = corlorService.getByCorlorId(corlorId);

            return new ResponseEntity<>(corlorDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserAddressDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/admin/corlor/color-by-corlorName/{corlorName}")
    public ResponseEntity<?> getByVideoName(@PathVariable String corlorName) {
        try {
            List<CorlorDTO>  corlorDTOS = corlorService.getByCorlorName(corlorName);

            return new ResponseEntity<>(corlorDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserAddressDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/admin/corlor/color-by-corlorcore/{corlorCore}")
    public ResponseEntity<?> getByCorlorCore(@PathVariable String corlorCore) {
        try {
            String core = "#"+corlorCore;
            List<CorlorDTO>  corlorDTOS = corlorService.getByCorlorCore(core);
            return new ResponseEntity<>(corlorDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserAddressDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/admin/corlor/create-corlors")
    public ResponseEntity<String> createVideo(@RequestBody CorlorDTO corlorDTO) {
        try {
            corlorService.createByCorlor(corlorDTO);
            return new ResponseEntity<>(" added successfully " , HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/admin/update-corlors/{corlorId}")
    public ResponseEntity<String> updateVideo(@PathVariable Long corlorId, @RequestBody CorlorDTO corlorDTO) {
        try {
            corlorDTO.setCorlorId(corlorId);
            corlorService.updateByCorlor(corlorDTO);
            return new ResponseEntity<>(corlorDTO+" Update successfully ", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/admin/delete-corlors/{corlorId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long corlorId) {
        try {
            corlorService.deleteByCorlorId(corlorId);
            return new ResponseEntity<>("delete successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
