package webmobileshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Corlor")
public class CorlorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CorlorId")
	private Long corlorId;
	@Column(name = "CorlorName",columnDefinition = "NVARCHAR(MAX)")
	private String corlorName;
	@Column(name = "CorlorCore")
	private String corlorCore;

	public Long getCorlorId() {
		return corlorId;
	}

	public void setCorlorId(Long corlorId) {
		this.corlorId = corlorId;
	}

	public String getCorlorName() {
		return corlorName;
	}

	public void setCorlorName(String corlorName) {
		this.corlorName = corlorName;
	}

	public String getCorlorCore() {
		return corlorCore;
	}

	public void setCorlorCore(String corlorCore) {
		this.corlorCore = corlorCore;
	}
}
