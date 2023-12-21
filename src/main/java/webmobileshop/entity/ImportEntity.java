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
@Table(name = "Import")
@Data
public class ImportEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ImportId")
	private Long ImportId;
	@Column(name = "DateAdded")
	private Date DateAdded;
	@ManyToOne
	@JoinColumn(name = "Categoryid")
	private CtegoryEntity Categoryid;
	@ManyToOne
	@JoinColumn(name = "CategoryItemId")
	private CategoryItemEntity CategoryItemId;
	public Long getImportId() {
		return ImportId;
	}
	public void setImportId(Long importId) {
		ImportId = importId;
	}
	public Date getDateAdded() {
		return DateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		DateAdded = dateAdded;
	}
	public CtegoryEntity getCategoryid() {
		return Categoryid;
	}
	public void setCategoryid(CtegoryEntity categoryid) {
		Categoryid = categoryid;
	}
	public CategoryItemEntity getCategoryItemId() {
		return CategoryItemId;
	}
	public void setCategoryItemId(CategoryItemEntity categoryItemId) {
		CategoryItemId = categoryItemId;
	}
	
}
