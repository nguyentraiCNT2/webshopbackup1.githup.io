package webmobileshop.dto;

public class ReviewDTO {
	private Long ReviewId;
	private Long ProductId;
	private String UserId;
	private String Content;
	private int  ReviewStar;
	private boolean Status;
	public Long getReviewId() {
		return ReviewId;
	}
	public void setReviewId(Long reviewId) {
		ReviewId = reviewId;
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
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public int getReviewStar() {
		return ReviewStar;
	}
	public void setReviewStar(int reviewStar) {
		ReviewStar = reviewStar;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	
	
}
