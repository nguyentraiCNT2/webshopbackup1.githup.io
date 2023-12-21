package webmobileshop.dto;

public class UserAccountDTO {
	private String UserId;
	private String UserName;
	private String Password;
	private String FristName;
	private String LastName;
	private String Email;
	private String Phone;
	private String GenDer;
	private Long Images;
	private boolean Status;
	private Long RoleDTO;
	private boolean BlockUser;
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getFristName() {
		return FristName;
	}
	public void setFristName(String fristName) {
		FristName = fristName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getGenDer() {
		return GenDer;
	}
	public void setGenDer(String genDer) {
		GenDer = genDer;
	}
	public Long getImages() {
		return Images;
	}
	public void setImages(Long images) {
		Images = images;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}

	public Long getRoleDTO() {
		return RoleDTO;
	}

	public void setRoleDTO(Long roleDTO) {
		RoleDTO = roleDTO;
	}

	public boolean isBlockUser() {
		return BlockUser;
	}
	public void setBlockUser(boolean blockUser) {
		BlockUser = blockUser;
	}



}
