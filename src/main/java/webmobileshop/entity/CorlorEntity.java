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
	private Long CorlorId;
	@Column(name = "CorlorName",columnDefinition = "NVARCHAR(MAX)")
	private String CorlorName;
	@Column(name = "CorlorCore")
	private String CorlorCore;

	public Long getCorlorId() {
		return CorlorId;
	}

	public void setCorlorId(Long corlorId) {
		CorlorId = corlorId;
	}

	public String getCorlorName() {
		return CorlorName;
	}

	public void setCorlorName(String corlorName) {
		CorlorName = corlorName;
	}

	public String getCorlorCore() {
		return CorlorCore;
	}

	public void setCorlorCore(String corlorCore) {
		CorlorCore = corlorCore;
	}
}
