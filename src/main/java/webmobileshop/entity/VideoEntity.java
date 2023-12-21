package webmobileshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Videos")
@Data
public class VideoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VideoId")
	private Long videoId;
	@Column(name = "VideoName",columnDefinition = "NVARCHAR(MAX)")
	private String videoName;
	@Column(name = "ShowOrHidden")
	private boolean showOrHidden;

	public Long getVideoId() {
		return videoId;
	}

	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public boolean isShowOrHidden() {
		return showOrHidden;
	}

	public void setShowOrHidden(boolean showOrHidden) {
		this.showOrHidden = showOrHidden;
	}
}
