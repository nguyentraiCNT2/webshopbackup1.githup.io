package webmobileshop.entity;

import java.math.BigDecimal;

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
@Table(name = "ImportDetail")
@Data
public class ImportDetailEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ImportDetailId")
	private Long ImportDetailId;
	@ManyToOne
	@JoinColumn(name = "ImportId")
	private ImportEntity ImportId;
	@ManyToOne
	@JoinColumn(name = "ProductId")
	private ProductsEntity ProductId;
	@ManyToOne
	@JoinColumn(name = "UserId")
	private UserAccountEntity UserId;
	@Column(name = "PriceAdded")
	private BigDecimal PriceAdded;
	@Column(name = "QuantityAdded")
	private int QuantityAdded;
	public Long getImportDetailId() {
		return ImportDetailId;
	}
	public void setImportDetail(Long importDetailId) {
		ImportDetailId = importDetailId;
	}
	public ImportEntity getImportId() {
		return ImportId;
	}
	public void setImportId(ImportEntity importId) {
		ImportId = importId;
	}
	public ProductsEntity getProductId() {
		return ProductId;
	}
	public void setProductId(ProductsEntity productId) {
		ProductId = productId;
	}
	public UserAccountEntity getUserId() {
		return UserId;
	}
	public void setUserId(UserAccountEntity userId) {
		UserId = userId;
	}
	public BigDecimal getPriceAdded() {
		return PriceAdded;
	}
	public void setPriceAdded(BigDecimal priceAdded) {
		PriceAdded = priceAdded;
	}
	public int getQuantityAdded() {
		return QuantityAdded;
	}
	public void setQuantityAdded(int quantityAdded) {
		QuantityAdded = quantityAdded;
	}
}
