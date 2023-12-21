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
@Table(name = "OrderDetail")
@Data
public class OrderDetailEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderDetailId")
	private Long OrderDetailId;
	@ManyToOne
	@JoinColumn(name = "OrderId")
	private OrderEntity OrderId;
	@ManyToOne
	@JoinColumn(name = "ProductId")
	private ProductsEntity ProductId;
	@ManyToOne
	@JoinColumn(name = "UserId")
	private UserAccountEntity UserId;
	@Column(name = "ProductName",columnDefinition = "NVARCHAR(MAX)")
	private String ProductName;
	@Column(name = "Quantity")
	private int Quantity;
	@Column(name = "Price")
	private BigDecimal Price;
	public Long getOrderDetailId() {
		return OrderDetailId;
	}
	public void setOrderDetailId(Long orderDetailId) {
		OrderDetailId = orderDetailId;
	}
	public OrderEntity getOrderId() {
		return OrderId;
	}
	public void setOrderId(OrderEntity orderId) {
		OrderId = orderId;
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
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public BigDecimal getPrice() {
		return Price;
	}
	public void setPrice(BigDecimal price) {
		Price = price;
	}
}
