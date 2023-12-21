package webmobileshop.api.ADMIN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webmobileshop.dto.RoleDTO;
import webmobileshop.service.RoleServive;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/roleadmin/api")
public class RoleAPI {
	@Autowired
	private RoleServive roleServive;

	@Autowired
	public RoleAPI(RoleServive roleServive) {
		super();
		this.roleServive = roleServive;
	}

	@GetMapping("/admin/{roleId}")
	public ResponseEntity<?> getRoleById(@PathVariable Long roleId) {
		try {
			RoleDTO roleDTO = roleServive.getRoleByRoleId(roleId);
			return new ResponseEntity<>(roleDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	public ResponseEntity<List<RoleDTO>> getAllRole() {
		try {
			List<RoleDTO> roleDTO = roleServive.getAllRole();
			return new ResponseEntity<>(roleDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>((List<RoleDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/admin/search/phan-quen/{roleName}")
	public ResponseEntity<?> getRoleByName(@PathVariable String roleName) {
		try {
			List<RoleDTO> roleDTO = roleServive.getRoleName(roleName);
			return new ResponseEntity<>(roleDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/admin/create-role")
	public ResponseEntity<?> createRole(@RequestBody RoleDTO roleDTO) {
		try {
			roleServive.createRole(roleDTO);
			return new ResponseEntity<>("Thêm mới Quyền Người dùng thành công", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PutMapping("/admin/{roleid}")
	public ResponseEntity<String> updateRole(@PathVariable Long roleid, @RequestBody RoleDTO roleDTO) {
		try {
			roleDTO.setRoleId(roleid);
			roleServive.updateRole(roleDTO);
			return new ResponseEntity<>(roleDTO+"Cập nhật quyền người dùng thành công", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Transactional
	@DeleteMapping("/admin/{RoleId}")
	public ResponseEntity<String> deleteRole(@PathVariable Long RoleId) {
		try {
			roleServive.deleteRole(RoleId);
			;
			return new ResponseEntity<>("Xóa quyền người dùng thành công", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
