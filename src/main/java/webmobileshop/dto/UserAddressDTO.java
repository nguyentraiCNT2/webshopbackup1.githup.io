package webmobileshop.dto;

public class UserAddressDTO {
	private Long UserAddressId;
	private String UserId;
	private String Address;
	private String Country;
	private String Province;
	private String District;
	private String Commune;
	private String ApartmentNumber;
	private String Phone;
	public Long getUserAddressId() {
		return UserAddressId;
	}
	public void setUserAddressId(Long userAddressId) {
		UserAddressId = userAddressId;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public String getCommune() {
		return Commune;
	}
	public void setCommune(String commune) {
		Commune = commune;
	}
	public String getApartmentNumber() {
		return ApartmentNumber;
	}
	public void setApartmentNumber(String apartmentNumber) {
		ApartmentNumber = apartmentNumber;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	
	
}
