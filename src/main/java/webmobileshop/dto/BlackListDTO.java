package webmobileshop.dto;

public class BlackListDTO {
	private Long BlackListId;
	private String Userid;
	private String UserErorr;
	public Long getBlackListId() {
		return BlackListId;
	}
	public void setBlackListId(Long blackListId) {
		BlackListId = blackListId;
	}
	public String getUserid() {
		return Userid;
	}
	public void setUserid(String userid) {
		Userid = userid;
	}
	public String getUserErorr() {
		return UserErorr;
	}
	public void setUserErorr(String userErorr) {
		UserErorr = userErorr;
	}
	
}
