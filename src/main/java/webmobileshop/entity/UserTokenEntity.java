package webmobileshop.entity;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "UserToken")
public class UserTokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserTokenId")
    private Long userTokenId;
    @Column(name = "MainToken")
    private String mainToken;
    @Column(name = "ReplaceToken")
    private String replaceToken;
    @Column(name = "Expiredtime")
    private Date expiredtime;
    @Column(name = "Time")
    private Long time;
    @ManyToOne
    @JoinColumn(name = "UserId")
    private UserAccountEntity user;

    public Long getUserTokenId() {
        return userTokenId;
    }

    public void setUserTokenId(Long userTokenId) {
        this.userTokenId = userTokenId;
    }

    public String getMainToken() {
        return mainToken;
    }

    public void setMainToken(String mainToken) {
        this.mainToken = mainToken;
    }

    public String getReplaceToken() {
        return replaceToken;
    }

    public void setReplaceToken(String replaceToken) {
        this.replaceToken = replaceToken;
    }

    public Date getExpiredtime() {
        return expiredtime;
    }

    public void setExpiredtime(Date expiredtime) {
        this.expiredtime = expiredtime;
    }

    public UserAccountEntity getUser() {
        return user;
    }

    public void setUser(UserAccountEntity user) {
        this.user = user;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
