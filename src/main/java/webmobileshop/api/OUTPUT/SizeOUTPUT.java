package webmobileshop.api.OUTPUT;

import webmobileshop.dto.SizeDTO;
import webmobileshop.dto.UserAccountDTO;

import java.util.ArrayList;
import java.util.List;

public class SizeOUTPUT {
    private int page;
    private int totalPage;
    private List<SizeDTO> listResult = new ArrayList<>();

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

    public List<SizeDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<SizeDTO> listResult) {
        this.listResult = listResult;
    }
}
