package webmobileshop.entity;

import java.math.BigDecimal;
import java.sql.Date;

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
@Table(name = "ShoppingCart")
@Data
public class ShoppingCartEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ShoppingCartId")
	private Long ShoppingCartId;
	@ManyToOne
	@JoinColumn(name = "UserId")
	private UserAccountEntity UserId;
	@ManyToOne
	@JoinColumn(name = "ProductId")
	private ProductsEntity ProductId;
	@Column(name = "Quantity")
	private int Quantity;
	@Column(name = "ShippingPrice")
	private BigDecimal ShippingPrice;
	@Column(name = "TotalAmount")
	private BigDecimal TotalAmount;
	@Column(name = "ExtraDay")
	private Date ExtraDay;
	public Long getShoppingCartId() {
		return ShoppingCartId;
	}
	public void setShoppingCartId(Long shoppingCartId) {
		ShoppingCartId = shoppingCartId;
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
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public BigDecimal getShippingPrice() {
		return ShippingPrice;
	}
	public void setShippingPrice(BigDecimal shippingPrice) {
		ShippingPrice = shippingPrice;
	}
	public BigDecimal getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		TotalAmount = totalAmount;
	}
	public Date getExtraDay() {
		return ExtraDay;
	}
	public void setExtraDay(Date extraDay) {
		ExtraDay = extraDay;
	}
}
