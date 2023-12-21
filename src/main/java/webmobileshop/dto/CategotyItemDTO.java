package webmobileshop.dto;

public class CategotyItemDTO {
	private Long CategoryItemId;
	private String CategoryItemName;
	private String CategoryItemLogo;
	public Long getCategoryItemId() {
		return CategoryItemId;
	}
	public void setCategoryItemId(Long categoryItemId) {
		CategoryItemId = categoryItemId;
	}
	public String getCategoryItemName() {
		return CategoryItemName;
	}
	public void setCategoryItemName(String categoryItemName) {
		CategoryItemName = categoryItemName;
	}
	public String getCategoryItemLogo() {
		return CategoryItemLogo;
	}
	public void setCategoryItemLogo(String categoryItemLogo) {
		CategoryItemLogo = categoryItemLogo;
	}
	
}
