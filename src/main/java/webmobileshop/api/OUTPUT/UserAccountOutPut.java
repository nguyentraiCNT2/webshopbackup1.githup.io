package webmobileshop.api.OUTPUT;

import webmobileshop.dto.UserAccountDTO;

import java.util.ArrayList;
import java.util.List;

public class UserAccountOutPut {
    private int page;
    private int totalPage;
    private List<UserAccountDTO> listResult = new ArrayList<>();

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

    public List<UserAccountDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<UserAccountDTO> listResult) {
        this.listResult = listResult;
    }
}
