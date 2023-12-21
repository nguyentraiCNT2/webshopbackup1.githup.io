package webmobileshop.dto;

import lombok.Data;

@Data
public class ImagesDTO {
	private Long ImagesId;
	private String name;
	private boolean ShowOrHidden;
	public Long getImagesId() {
		return ImagesId;
	}
	public void setImagesId(Long imagesId) {
		ImagesId = imagesId;
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
