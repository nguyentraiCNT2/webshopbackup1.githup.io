package webmobileshop.api.OUTPUT;

import webmobileshop.dto.UserTokenDTO;

import java.util.ArrayList;
import java.util.List;

public class UserTokenOUTPUT {
    private int page;
    private int totalPage;
    private List<UserTokenDTO> listResult = new ArrayList<>();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<UserTokenDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<UserTokenDTO> listResult) {
        this.listResult = listResult;
    }
}
