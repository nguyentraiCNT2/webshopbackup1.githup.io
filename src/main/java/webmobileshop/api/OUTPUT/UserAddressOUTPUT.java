package webmobileshop.api.OUTPUT;

import webmobileshop.dto.UserAddressDTO;

import java.util.ArrayList;
import java.util.List;

public class UserAddressOUTPUT {
    private int page;
    private int totalPage;
    private List<UserAddressDTO> listResult = new ArrayList<>();

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

    public List<UserAddressDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<UserAddressDTO> listResult) {
        this.listResult = listResult;
    }
}
