package webmobileshop.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class ShoppingCartDTO {

	private Long ShoppingCartId;
	private String UserId;
	private Long ProductId;
	private int Quantity;
	private BigDecimal ShippingPrice;
	private BigDecimal TotalAmount;
	private Date ExtraDay;
	public Long getShoppingCartId() {
		return ShoppingCartId;
	}
	public void setShoppingCartId(Long shoppingCartId) {
		ShoppingCartId = shoppingCartId;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public Long getProductId() {
		return ProductId;
	}
	public void setProductId(Long productId) {
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
