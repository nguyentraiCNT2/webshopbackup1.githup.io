package webmobileshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CategoryItem")
public class CategoryItemEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="CategoryItemId")
	private Long CategoryItemId;
	@Column(name ="CategoryItemName",columnDefinition = "NVARCHAR(MAX)")
	private String CategoryItemName;
	@Column(name ="CategoryItemLogo",columnDefinition = "NVARCHAR(MAX)")
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
