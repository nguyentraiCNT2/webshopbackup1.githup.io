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
	private Long productId;
	@Column(name = "Productcore")
	private String productcore;
	@Column(name = "ProductName",columnDefinition = "NVARCHAR(MAX)")
	private String productName;
	@ManyToOne
	@JoinColumn(name = "ImagesId")
	private ImagesEntity imagesId;
	@ManyToOne
	@JoinColumn(name = "VideoId")
	private VideoEntity videoId;
	@ManyToOne
	@JoinColumn(name = "CategoryItemId")
	private CategoryItemEntity categoryItemId;
	@ManyToOne
	@JoinColumn(name = "CategoryId")
	private CtegoryEntity categoryId;
	@ManyToOne
	@JoinColumn(name = "CorlorId")
	private CorlorEntity corlorId;
	@ManyToOne
	@JoinColumn(name = "SizeId")
	private SizeEntity sizeId;
	@Column(name = "ProductPrice")
	private BigDecimal productPrice;
	@Column(name = "ProductDescribe",columnDefinition = "NVARCHAR(MAX)")
	private String productDescribe;
	@Column(name = "Quantityinstock")
	private int quantityinstock;
	@Column(name = "DateAdded")
	private Date dateAdded;
	@Column(name = "ProductView")
	private int productView;
	@Column(name = "ShowOrHidden")
		private boolean showOrHidden;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductcore() {
		return productcore;
	}

	public void setProductcore(String productcore) {
		this.productcore = productcore;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ImagesEntity getImagesId() {
		return imagesId;
	}

	public void setImagesId(ImagesEntity imagesId) {
		this.imagesId = imagesId;
	}

	public VideoEntity getVideoId() {
		return videoId;
	}

	public void setVideoId(VideoEntity videoId) {
		this.videoId = videoId;
	}

	public CategoryItemEntity getCategoryItemId() {
		return categoryItemId;
	}

	public void setCategoryItemId(CategoryItemEntity categoryItemId) {
		this.categoryItemId = categoryItemId;
	}

	public CtegoryEntity getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(CtegoryEntity categoryId) {
		this.categoryId = categoryId;
	}

	public CorlorEntity getCorlorId() {
		return corlorId;
	}

	public void setCorlorId(CorlorEntity corlorId) {
		this.corlorId = corlorId;
	}

	public SizeEntity getSizeId() {
		return sizeId;
	}

	public void setSizeId(SizeEntity sizeId) {
		this.sizeId = sizeId;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDescribe() {
		return productDescribe;
	}

	public void setProductDescribe(String productDescribe) {
		this.productDescribe = productDescribe;
	}

	public int getQuantityinstock() {
		return quantityinstock;
	}

	public void setQuantityinstock(int quantityinstock) {
		this.quantityinstock = quantityinstock;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public int getProductView() {
		return productView;
	}

	public void setProductView(int productView) {
		this.productView = productView;
	}

	public boolean isShowOrHidden() {
		return showOrHidden;
	}

	public void setShowOrHidden(boolean showOrHidden) {
		this.showOrHidden = showOrHidden;
	}
}
