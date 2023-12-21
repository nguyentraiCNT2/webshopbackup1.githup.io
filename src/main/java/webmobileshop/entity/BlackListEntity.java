package webmobileshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BlackList")
public class BlackListEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BlackListId")
	private Long BlackListId;
	@ManyToOne
	@JoinColumn(name = "Userid")
	private UserAccountEntity Userid;
	@Column(name = "UserErorr",columnDefinition = "NVARCHAR(MAX)")
	private String UserErorr;

	public Long getBlackListId() {
		return BlackListId;
	}

	public void setBlackListId(Long blackListId) {
		BlackListId = blackListId;
	}

	public UserAccountEntity getUserid() {
		return Userid;
	}

	public void setUserid(UserAccountEntity userid) {
		Userid = userid;
	}

	public String getUserErorr() {
		return UserErorr;
	}

	public void setUserErorr(String userErorr) {
		UserErorr = userErorr;
	}

}
