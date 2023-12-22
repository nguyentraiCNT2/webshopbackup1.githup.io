package webmobileshop.api.ADMIN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webmobileshop.api.OUTPUT.CorlorOUTPUT;
import webmobileshop.api.OUTPUT.SizeOUTPUT;
import webmobileshop.dto.CorlorDTO;
import webmobileshop.dto.SizeDTO;
import webmobileshop.dto.UserAddressDTO;
import webmobileshop.service.SizeService;

import java.util.List;

@RestController
@RequestMapping("/admin/kich-thuoc-san-pham/api")
public class SizeAPI {
    @Autowired
    private final SizeService service;

    public SizeAPI(SizeService service) {
        this.service = service;
    }


    @GetMapping("/admin/size-list")
    public SizeOUTPUT getAllSize(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        SizeOUTPUT result = new SizeOUTPUT();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(service.getAllSize(pageable));
        result.setTotalPage((int) Math.ceil((double) (service.totalItem()) / limit));
        model.addAttribute("VideosOUTPUT", result);
        return result;
    }
    @GetMapping("/admin/size/size-by-id/{sizeId}")
    public ResponseEntity<?> getBySizeId(@PathVariable Long sizeId) {
        try {
            SizeDTO sizeDTO = service.getBySizeId(sizeId);

            return new ResponseEntity<>(sizeDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserAddressDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/admin/size/size-by-sizeName/{sizeName}")
    public ResponseEntity<?> getBySizeName(@PathVariable String sizeName) {
        try {
            List<SizeDTO>  sizeDTOS = service.getBySizeName(sizeName);

            return new ResponseEntity<>(sizeDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserAddressDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/admin/size/create-sizes")
    public ResponseEntity<String> createVideo(@RequestBody SizeDTO sizeDTO) {
        try {
            service.createBySize(sizeDTO);
            return new ResponseEntity<>(" added successfully " , HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/admin/update-size/{sizeId}")
    public ResponseEntity<String> updateVideo(@PathVariable Long sizeId, @RequestBody SizeDTO sizeDTO) {
        try {
            sizeDTO.setSizeId(sizeId);
            service.updateBySize(sizeDTO);
            return new ResponseEntity<>(sizeDTO+" Update successfully ", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/admin/delete-size/{sizeId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long sizeId) {
        try {
            service.deleteBySizeId(sizeId);
            return new ResponseEntity<>("delete successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    }
