package webmobileshop.service;

import java.util.List;

import webmobileshop.dto.RoleDTO;

public interface RoleServive {
	
		RoleDTO getRoleByRoleId(Long RoleId);
	
		void createRole(RoleDTO roleDTO);

	    void updateRole( RoleDTO roleDTO);

	    void deleteRole(Long roleId);
	    
	    List<RoleDTO> getAllRole();
	    
	    List<RoleDTO> getRoleName(String roleName);
}
