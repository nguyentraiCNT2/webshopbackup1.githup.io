package webmobileshop.dto;

import java.sql.Date;

public class ImportDTO {
	private Long ImportId;
	private Date DateAdded;
	private Long Categoryid;
	private Long CategoryItemId;
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
	public Long getCategoryid() {
		return Categoryid;
	}
	public void setCategoryid(Long categoryid) {
		Categoryid = categoryid;
	}
	public Long getCategoryItemId() {
		return CategoryItemId;
	}
	public void setCategoryItemId(Long categoryItemId) {
		CategoryItemId = categoryItemId;
	}
	
	
}
