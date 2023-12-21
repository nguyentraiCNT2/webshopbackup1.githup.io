package webmobileshop.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class UserTokenDTO {
    private Long UserTokenId;
    private String MainToken;
    private String ReplaceToken;
    private Date Expiredtime;
    private String User;
    private Long time;
    public Long getUserTokenId() {
        return UserTokenId;
    }

    public void setUserTokenId(Long userTokenId) {
        UserTokenId = userTokenId;
    }

    public String getMainToken() {
        return MainToken;
    }

    public void setMainToken(String mainToken) {
        MainToken = mainToken;
    }

    public String getReplaceToken() {
        return ReplaceToken;
    }

    public void setReplaceToken(String replaceToken) {
        ReplaceToken = replaceToken;
    }

    public Date getExpiredtime() {
        return Expiredtime;
    }

    public void setExpiredtime(Date expiredtime) {
        Expiredtime = expiredtime;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
