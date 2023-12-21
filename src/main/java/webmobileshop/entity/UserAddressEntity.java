package webmobileshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "UserAddress")
@Data
public class UserAddressEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserAddressId")
	private Long userAddressId;
	@ManyToOne
	@JoinColumn(name = "UserId")
	private UserAccountEntity userId;
	@Column(name = "Address",columnDefinition = "NVARCHAR(MAX)")
	private String address;
	@Column(name = "Country",columnDefinition = "NVARCHAR(MAX)")
	private String country;
	@Column(name = "Province",columnDefinition = "NVARCHAR(MAX)")
	private String province;
	@Column(name = "District",columnDefinition = "NVARCHAR(MAX)")
	private String district;
	@Column(name = "Commune",columnDefinition = "NVARCHAR(MAX)")
	private String commune;
	@Column(name = "ApartmentNumber")
	private String apartmentNumber;
	@Column(name = "Phone")
	private String phone;

	public Long getUserAddressId() {
		return userAddressId;
	}

	public void setUserAddressId(Long Id) {
		userAddressId = Id;
	}

	public UserAccountEntity getUserId() {
		return userId;
	}

	public void setUserId(UserAccountEntity user) {
		userId = user;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
