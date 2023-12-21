package webmobileshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Sizes")
@Data
public class SizeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SizeId")
	private Long SizeId;
	@Column(name = "SizeName",columnDefinition = "NVARCHAR(MAX)")
	private String SizeName;
	public Long getSizeId() {
		return SizeId;
	}
	public void setSizeId(Long sizeId) {
		SizeId = sizeId;
	}
	public String getSizeName() {
		return SizeName;
	}
	public void setSizeName(String sizeName) {
		SizeName = sizeName;
	}
}
