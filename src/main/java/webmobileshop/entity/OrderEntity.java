package webmobileshop.entity;

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
@Table(name = "Orders")
@Data
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderId")
	private Long OrderId;
	@ManyToOne
	@JoinColumn(name = "ProductId")
	private ProductsEntity ProductId;
	@ManyToOne
	@JoinColumn(name = "UserId")
	private UserAccountEntity UserId;
	@ManyToOne
	@JoinColumn(name = "QuestId")
	private GuestEntity QuestId;
	@Column(name = "DateBooking")
	private Date DateBooking;
	@Column(name = "DateDelivery")
	private Date DateDelivery;
	@Column(name = "CancelOrder")
	private boolean CancelOrder;
	public Long getOrderId() {
		return OrderId;
	}
	public void setOrderId(Long orderId) {
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
	public GuestEntity getGuestId() {
		return QuestId;
	}
	public void setGuestId(GuestEntity questId) {
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
