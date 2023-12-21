package webmobileshop.dto;

import lombok.Data;

@Data
public class RoleDTO {
	private Long RoleId;
	private String RoleName;
	
	public Long getRoleId() {
		return RoleId;
	}
	public void setRoleId(Long roleId) {
		RoleId = roleId;
	}
	public String getRoleName() {
		return RoleName;
	}
	public void setRoleName(String roleName) {
		RoleName = roleName;
	}
	
	
}
