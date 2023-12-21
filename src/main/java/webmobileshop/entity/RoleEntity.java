package webmobileshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Roles")
@Data
public class RoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roleId")
	private Long roleId;
	@Column(name = "roleName",columnDefinition = "NVARCHAR(MAX)")
	private String roleName;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long Id) {
		roleId = Id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String Name) {
		roleName = Name;
	}
}
