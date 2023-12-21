package webmobileshop.dto;

import java.math.BigDecimal;

public class OrderDetailDTO {
	private Long OrderDetailId;
	private Long OrderId;
	private Long ProductId;
	private String UserId;
	private String ProductName;
	private int Quantity;
	private BigDecimal Price;
	public Long getOrderDetailId() {
		return OrderDetailId;
	}
	public void setOrderDetailId(Long orderDetailId) {
		OrderDetailId = orderDetailId;
	}

	public Long getOrderId() {
		return OrderId;
	}
	public void setOrderId(Long orderId) {
		OrderId = orderId;
	}
	public Long getProductId() {
		return ProductId;
	}
	public void setProductId(Long productId) {
		ProductId = productId;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
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
