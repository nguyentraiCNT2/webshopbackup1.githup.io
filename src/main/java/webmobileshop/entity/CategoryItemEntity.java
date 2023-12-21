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
	private Long categoryItemId;
	@Column(name ="CategoryItemName",columnDefinition = "NVARCHAR(MAX)")
	private String categoryItemName;
	@Column(name ="CategoryItemLogo",columnDefinition = "NVARCHAR(MAX)")
	private String categoryItemLogo;

	public Long getCategoryItemId() {
		return categoryItemId;
	}

	public void setCategoryItemId(Long categoryItemId) {
		this.categoryItemId = categoryItemId;
	}

	public String getCategoryItemName() {
		return categoryItemName;
	}

	public void setCategoryItemName(String categoryItemName) {
		this.categoryItemName = categoryItemName;
	}

	public String getCategoryItemLogo() {
		return categoryItemLogo;
	}

	public void setCategoryItemLogo(String categoryItemLogo) {
		this.categoryItemLogo = categoryItemLogo;
	}
}
