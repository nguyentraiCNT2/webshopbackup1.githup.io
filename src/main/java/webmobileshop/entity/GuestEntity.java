package webmobileshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Guest")
@Data
public class GuestEntity {
	@Id
	@Column(name = "QuestId")
	private String questId;
	   @Column(name = "QuestName",columnDefinition = "NVARCHAR(MAX)")
	private String questName;
	   @Column(name = "QuestAddress",columnDefinition = "NVARCHAR(MAX)")
	private String questAddress;
	   @Column(name = "QuestPhone")
	private String questPhone;
	   @Column(name = "QuestEmail")
	private String questEmail;
	   @Column(name = "FristName",columnDefinition = "NVARCHAR(MAX)")
	private String fristName;
	   @Column(name = "LastName",columnDefinition = "NVARCHAR(MAX)")
	private String lastName;
	public String getQuestId() {
		return questId;
	}
	public void setQuestId(String Id) {
		questId = Id;
	}
	public String getQuestName() {
		return questName;
	}
	public void setQuestName(String Name) {
		questName = Name;
	}
	public String getQuestAddress() {
		return questAddress;
	}
	public void setQuestAddress(String Address) {
		questAddress = Address;
	}
	public String getQuestPhone() {
		return questPhone;
	}
	public void setQuestPhone(String Phone) {
		questPhone = Phone;
	}
	public String getQuestEmail() {
		return questEmail;
	}
	public void setQuestEmail(String Email) {
		questEmail = Email;
	}
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String ho) {
		fristName = ho;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String ten) {
		lastName = ten;
	}
}
