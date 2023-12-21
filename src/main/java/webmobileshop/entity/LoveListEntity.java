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
@Table(name = "LoveList")
@Data
public class LoveListEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LoveListId")
	private Long LoveListId;
	@Column(name = "LoveListName",columnDefinition = "NVARCHAR(MAX)")
	private String LoveListName;
	@ManyToOne
	@JoinColumn(name = "UserId")
	private UserAccountEntity UserId;
	@ManyToOne
	@JoinColumn(name = "ProductId")
	private ProductsEntity ProductId;
	@Column(name = "Status")
	private boolean Status;
	public Long getLoveListId() {
		return LoveListId;
	}
	public void setLoveListId(Long loveListId) {
		LoveListId = loveListId;
	}
	public String getLoveListName() {
		return LoveListName;
	}
	public void setLoveListName(String loveListName) {
		LoveListName = loveListName;
	}
	public UserAccountEntity getUserId() {
		return UserId;
	}
	public void setUserId(UserAccountEntity userId) {
		UserId = userId;
	}
	public ProductsEntity getProductId() {
		return ProductId;
	}
	public void setProductId(ProductsEntity productId) {
		ProductId = productId;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
}
