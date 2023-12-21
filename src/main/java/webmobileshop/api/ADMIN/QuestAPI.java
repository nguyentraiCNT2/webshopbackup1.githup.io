package webmobileshop.api.ADMIN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webmobileshop.dto.GuestDTO;
import webmobileshop.service.GuestService;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/khach-hang/api")
public class QuestAPI {
	@Autowired
	private GuestService guestService;
	public QuestAPI(GuestService guestService) {
		super();
		this.guestService = guestService;
	}
	//hiển thị toàn bộ dữ liệu trong bảng
	@GetMapping
	public ResponseEntity<List<GuestDTO>> getAllGuest() {
		try {
			List<GuestDTO> guestDTO = guestService.getAllGuest();
			return new ResponseEntity<>(guestDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>((List<GuestDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//hiển thị dữ liệu trong bảng theo id
	@GetMapping("/{questId}")
	public ResponseEntity<?> getByQuestId(@PathVariable  String questId) {
		try {
			GuestDTO guestDTO = guestService.getByQuestId(questId);
			return new ResponseEntity<>(guestDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>((List<GuestDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//hiển thị dữ liệu trong bảng theo địa chỉ
	@GetMapping("/search/ten-khach-hang/{questName}")
	public ResponseEntity<?> getByquestName(@PathVariable  String questName) {
		try {
			List<GuestDTO> guestDTO = guestService.getByquestName(questName);
			return new ResponseEntity<>(guestDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>((List<GuestDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//hiển thị dữ liệu trong bảng theo địa chỉ
	@GetMapping("/search/dia-chi/{questAddress}")
	public ResponseEntity<?> getByquestAddress(@PathVariable  String questAddress) {
		try {
			List<GuestDTO> guestDTO = guestService.getByquestAddress(questAddress);
			return new ResponseEntity<>(guestDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>((List<GuestDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//hiển thị dữ liệu trong bảng theo email
	@GetMapping("/search/email/{questEmail}")
	public ResponseEntity<?>  getByquestEmail(@PathVariable  String questEmail) {
		try {
			List<GuestDTO> guestDTO = guestService.getByquestEmail(questEmail);
			return new ResponseEntity<>(guestDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>((List<GuestDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//hiển thị dữ liệu trong bảng theo id
	@GetMapping("/search/so-dien-thoai/{questPhone}")
	public ResponseEntity<?> getByquestPhone(@PathVariable  String questPhone) {
		try {
			List<GuestDTO> guestDTO = guestService.getByquestPhone(questPhone);
			return new ResponseEntity<>(guestDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>((List<GuestDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//hiển thị dữ liệu trong bảng theo họ khách hàng
	@GetMapping("/search/ho/{fristName}")
	public ResponseEntity<?>   getByfistName(@PathVariable  String fristName) {
		try {
			List<GuestDTO> guestDTO = guestService.getByfistName(fristName);
			return new ResponseEntity<>(guestDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>((List<GuestDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//hiển thị dữ liệu trong bảng theo tên khách hàng
	@GetMapping("/search/ten/{lastName}")
	public ResponseEntity<?>  getBylastName(@PathVariable  String lastName) {
		try {
			List<GuestDTO> guestDTO = guestService.getBylastName(lastName);
			return new ResponseEntity<>(guestDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>((List<GuestDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// thêm dư liệu vào vào bảng
	@PostMapping
	public ResponseEntity<String> createQuest(@RequestBody GuestDTO guestDTO) {
		try {

			guestService.createGuest(guestDTO);
			return new ResponseEntity<>(guestDTO+"Thêm mới Ảnh thành công" , HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	// sửa dữ liệu theo
	@PutMapping("/{questId}")
	public ResponseEntity<String> updateProduct(@PathVariable String questId, @RequestBody GuestDTO guestDTO) {
		try {
			guestDTO.setQuestId(questId);
			guestService.updateGuest(guestDTO);
			return new ResponseEntity<>(guestDTO+"Cập nhật quyền người dùng thành công", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
 	// xóa dữ liệu
	@Transactional
	@DeleteMapping("/{questId}")
	public ResponseEntity<String> deleteProduct(@PathVariable String questId) {
		try {
			guestService.deleteGuest(questId);
			;
			return new ResponseEntity<>("Xóa Ảnh thành công", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
