package webmobileshop.dto;

import java.sql.Date;

public class OrderDTO {
	private Long OrderId;
	private Long ProductId;
	private String UserId;
	private String QuestId;
	private Date DateBooking;
	private Date DateDelivery;
	private boolean CancelOrder;
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
	public String getQuestId() {
		return QuestId;
	}
	public void setQuestId(String questId) {
		QuestId = questId;
	}
	public Date getDateBooking() {
		return DateBooking;
	}
	public void setDateBooking(Date dateBooking) {
		DateBooking = dateBooking;
	}
	public Date getDateDelivery() {
		return DateDelivery;
	}
	public void setDateDelivery(Date dateDelivery) {
		DateDelivery = dateDelivery;
	}
	public boolean isCancelOrder() {
		return CancelOrder;
	}
	public void setCancelOrder(boolean cancelOrder) {
		CancelOrder = cancelOrder;
	}
	
	
}
