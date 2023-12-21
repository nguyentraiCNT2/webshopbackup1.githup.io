package webmobileshop.dto;

import java.math.BigDecimal;

public class ImportDetailDTO {
	private Long ImportDetailId;
	private Long ImportId;
	private Long ProductId;
	private String UserId;
	private BigDecimal PriceAdded;
	private int QuantityAdded;
	public Long getImportDetailId() {
		return ImportDetailId;
	}
	public void setImportDetailId(Long importDetailId) {
		ImportDetailId = importDetailId;
	}
	public Long getImportId() {
		return ImportId;
	}
	public void setImportId(Long importId) {
		ImportId = importId;
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
	public BigDecimal getPriceAdded() {
		return PriceAdded;
	}
	public void setPriceAdded(BigDecimal priceAdded) {
		PriceAdded = priceAdded;
	}
	public int getQuantityAdded() {
		return QuantityAdded;
	}
	public void setQuantityAdded(int quantityAdded) {
		QuantityAdded = quantityAdded;
	}
	
}
