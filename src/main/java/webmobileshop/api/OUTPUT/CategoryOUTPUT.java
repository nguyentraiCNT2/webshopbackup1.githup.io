package webmobileshop.api.OUTPUT;

import webmobileshop.dto.CategoryDTO;
import webmobileshop.dto.UserAccountDTO;

import java.util.ArrayList;
import java.util.List;

public class CategoryOUTPUT {
    private int page;
    private int totalPage;
    private List<CategoryDTO> listResult = new ArrayList<>();

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

    public List<CategoryDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<CategoryDTO> listResult) {
        this.listResult = listResult;
    }
}
