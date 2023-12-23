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
	private Long shoppingCartId;
	@ManyToOne
	@JoinColumn(name = "UserId")
	private UserAccountEntity userId;
	@ManyToOne
	@JoinColumn(name = "ProductId")
	private ProductsEntity productId;
	@Column(name = "Quantity")
	private int quantity;
	@Column(name = "ShippingPrice")
	private BigDecimal shippingPrice;
	@Column(name = "TotalAmount")
	private BigDecimal totalAmount;
	@Column(name = "ExtraDay")
	private Date extraDay;

	public Long getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(Long shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	public UserAccountEntity getUserId() {
		return userId;
	}

	public void setUserId(UserAccountEntity userId) {
		this.userId = userId;
	}

	public ProductsEntity getProductId() {
		return productId;
	}

	public void setProductId(ProductsEntity productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getShippingPrice() {
		return shippingPrice;
	}

	public void setShippingPrice(BigDecimal shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getExtraDay() {
		return extraDay;
	}

	public void setExtraDay(Date extraDay) {
		this.extraDay = extraDay;
	}
}
