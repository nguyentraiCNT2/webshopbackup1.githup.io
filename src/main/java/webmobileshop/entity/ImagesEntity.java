package webmobileshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Images")
@Data
public class ImagesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ImagesId")
	private Long imagesId;
	@Column(name = "name",columnDefinition = "NVARCHAR(MAX)")
	private String name;
	@Column(name = "ShowOrHidden")
	private boolean ShowOrHidden;

	public Long getImagesId() {
		return imagesId;
	}

	public void setImagesId(Long Id) {
		imagesId = Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isShowOrHidden() {
		return ShowOrHidden;
	}

	public void setShowOrHidden(boolean showOrHidden) {
		ShowOrHidden = showOrHidden;
	}
}
