package webmobileshop.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class ProductDTO {
	private Long ProductId;
	private String Productcore;
	private String ProductName;
	private Long ImagesId;
	private Long VideoId;
	private Long CategoryItemId;
	private Long CategoryId;
	private Long CorlorId;
	private Long SizeId;
	private BigDecimal ProductPrice;
	private String ProductDescribe;
	private int Quantityinstock;
	private Date DateAdded;
	private int ProductView;
	private boolean ShowOrHidden;
	public Long getProductId() {
		return ProductId;
	}
	public void setProductId(Long productId) {
		ProductId = productId;
	}
	public String getProductcore() {
		return Productcore;
	}
	public void setProductcore(String productcore) {
		Productcore = productcore;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public Long getImagesId() {
		return ImagesId;
	}
	public void setImagesId(Long imagesId) {
		ImagesId = imagesId;
	}
	public Long getVideoId() {
		return VideoId;
	}
	public void setVideoId(Long videoId) {
		VideoId = videoId;
	}
	public Long getCategoryItemId() {
		return CategoryItemId;
	}
	public void setCategoryItemId(Long categoryItemId) {
		CategoryItemId = categoryItemId;
	}
	public Long getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(Long categoryId) {
		CategoryId = categoryId;
	}
	public Long getCorlorId() {
		return CorlorId;
	}
	public void setCorlorId(Long corlorId) {
		CorlorId = corlorId;
	}
	public Long getSizeId() {
		return SizeId;
	}
	public void setSizeId(Long sizeId) {
		SizeId = sizeId;
	}
	public BigDecimal getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		ProductPrice = productPrice;
	}
	public String getProductDescribe() {
		return ProductDescribe;
	}
	public void setProductDescribe(String productDescribe) {
		ProductDescribe = productDescribe;
	}
	public int getQuantityinstock() {
		return Quantityinstock;
	}
	public void setQuantityinstock(int quantityinstock) {
		Quantityinstock = quantityinstock;
	}
	public Date getDateAdded() {
		return DateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		DateAdded = dateAdded;
	}
	public int getProductView() {
		return ProductView;
	}
	public void setProductView(int productView) {
		ProductView = productView;
	}
	public boolean isShowOrHidden() {
		return ShowOrHidden;
	}
	public void setShowOrHidden(boolean showOrHidden) {
		ShowOrHidden = showOrHidden;
	}
	
	
}
