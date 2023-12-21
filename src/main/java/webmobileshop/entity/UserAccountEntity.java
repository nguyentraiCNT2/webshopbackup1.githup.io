package webmobileshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "UserAccount")
@Data
public class UserAccountEntity {
	@Id
	@Column(name = "UserId")
	private String userId;
	@Column(name = "UserName",columnDefinition = "NVARCHAR(MAX)")
	private String userName;
	@Column(name = "Password")
	private String password;
	@Column(name = "FristName",columnDefinition = "NVARCHAR(MAX)")
	private String fristName;
	@Column(name = "LastName",columnDefinition = "NVARCHAR(MAX)")
	private String lastName;
	@Column(name = "Email")
	private String email;
	@Column(name = "Phone")
	private String phone;
	@Column(name = "GenDer",columnDefinition = "NVARCHAR(MAX)")
	private String genDer;
	@ManyToOne
	@JoinColumn(name = "ImagesId")
	private ImagesEntity images;
	@Column(name = "Status")
	private boolean status;
	@ManyToOne
	@JoinColumn(name = "RoleId")
	private RoleEntity roleDTO;
	@Column(name = "BlockUser")
	private boolean blockUser;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String Id) {
		userId = Id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String Name) {
		userName = Name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pass) {
		password = pass;
	}

	public String getFristName() {
		return fristName;
	}

	public void setFristName(String ho) {
		fristName = ho;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String ten) {
		lastName = ten;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String gmail) {
		email = gmail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String SDT) {
		phone = SDT;
	}

	public String getGenDer() {
		return genDer;
	}

	public void setGenDer(String sex) {
		genDer = sex;
	}

	public ImagesEntity getImages() {
		return images;
	}

	public void setImages(ImagesEntity anh) {
		images = anh;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean trangthai) {
		status = trangthai;
	}

	public RoleEntity getRoleDTO() {
		return roleDTO;
	}

	public void setRoleDTO(RoleEntity roleDTO) {
		this.roleDTO = roleDTO;
	}

	public boolean isBlockUser() {
		return blockUser;
	}

	public void setBlockUser(boolean block) {
		blockUser = block;
	}


}
