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
	private Long blackListId;
	@ManyToOne
	@JoinColumn(name = "Userid")
	private UserAccountEntity userid;
	@Column(name = "UserErorr",columnDefinition = "NVARCHAR(MAX)")
	private String userErorr;

	public Long getBlackListId() {
		return blackListId;
	}

	public void setBlackListId(Long blackListId) {
		this.blackListId = blackListId;
	}

	public UserAccountEntity getUserid() {
		return userid;
	}

	public void setUserid(UserAccountEntity userid) {
		this.userid = userid;
	}

	public String getUserErorr() {
		return userErorr;
	}

	public void setUserErorr(String userErorr) {
		this.userErorr = userErorr;
	}
}
