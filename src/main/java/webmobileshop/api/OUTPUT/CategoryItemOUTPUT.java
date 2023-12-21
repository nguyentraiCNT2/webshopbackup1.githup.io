package webmobileshop.api.OUTPUT;

import webmobileshop.dto.CategoryDTO;
import webmobileshop.dto.CategotyItemDTO;

import java.util.ArrayList;
import java.util.List;

public class CategoryItemOUTPUT {
    private int page;
    private int totalPage;
    private List<CategotyItemDTO> listResult = new ArrayList<>();

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

    public List<CategotyItemDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<CategotyItemDTO> listResult) {
        this.listResult = listResult;
    }
}
