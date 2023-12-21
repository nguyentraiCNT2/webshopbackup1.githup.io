package webmobileshop.dto;

public class LoveListDTO {
	private Long LoveListId;
	private String LoveListName;
	private String UserId;
	private Long ProductId;
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
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	
	
}
