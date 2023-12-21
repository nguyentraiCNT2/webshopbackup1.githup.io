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
	private Long VideoId;
	@Column(name = "VideoName",columnDefinition = "NVARCHAR(MAX)")
	private String VideoName;
	@Column(name = "ShowOrHidden")
	private boolean ShowOrHidden;
	public Long getVideoId() {
		return VideoId;
	}
	public void setVideoId(Long videoId) {
		VideoId = videoId;
	}
	public String getVideoName() {
		return VideoName;
	}
	public void setVideoName(String videoName) {
		VideoName = videoName;
	}
	public boolean isShowOrHidden() {
		return ShowOrHidden;
	}
	public void setShowOrHidden(boolean showOrHidden) {
		ShowOrHidden = showOrHidden;
	}
}
