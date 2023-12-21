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
@Table(name ="Product")
@Data
public class ProductsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductId")
	private Long ProductId;
	@Column(name = "Productcore")
	private String Productcore;
	@Column(name = "ProductName",columnDefinition = "NVARCHAR(MAX)")
	private String ProductName;
	@ManyToOne
	@JoinColumn(name = "ImagesId")
	private ImagesEntity ImagesId;
	@ManyToOne
	@JoinColumn(name = "VideoId")
	private VideoEntity VideoId;
	@ManyToOne
	@JoinColumn(name = "CategoryItemId")
	private CategoryItemEntity CategoryItemId;
	@ManyToOne
	@JoinColumn(name = "CategoryId")
	private CtegoryEntity CategoryId;
	@ManyToOne
	@JoinColumn(name = "CorlorId")
	private CorlorEntity CorlorId;
	@ManyToOne
	@JoinColumn(name = "SizeId")
	private SizeEntity SizeId;
	@Column(name = "ProductPrice")
	private BigDecimal ProductPrice;
	@Column(name = "ProductDescribe",columnDefinition = "NVARCHAR(MAX)")
	private String ProductDescribe;
	@Column(name = "Quantityinstock")
	private int Quantityinstock;
	@Column(name = "DateAdded")
	private Date DateAdded;
	@Column(name = "ProductView")
	private int ProductView;
	@Column(name = "ShowOrHidden")
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
	public ImagesEntity getImagesId() {
		return ImagesId;
	}
	public void setImagesId(ImagesEntity imagesId) {
		ImagesId = imagesId;
	}
	public VideoEntity getVideoId() {
		return VideoId;
	}
	public void setVideoId(VideoEntity videoId) {
		VideoId = videoId;
	}
	public CategoryItemEntity getCategoryItemId() {
		return CategoryItemId;
	}
	public void setCategoryItemId(CategoryItemEntity categoryItemId) {
		CategoryItemId = categoryItemId;
	}
	public CtegoryEntity getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(CtegoryEntity categoryId) {
		CategoryId = categoryId;
	}
	public CorlorEntity getCorlorId() {
		return CorlorId;
	}
	public void setCorlorId(CorlorEntity corlorId) {
		CorlorId = corlorId;
	}
	public SizeEntity getSizeId() {
		return SizeId;
	}
	public void setSizeId(SizeEntity sizeId) {
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
