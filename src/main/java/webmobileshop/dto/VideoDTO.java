package webmobileshop.dto;

public class VideoDTO {
	private Long VideoId;
	private String VideoName;
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
