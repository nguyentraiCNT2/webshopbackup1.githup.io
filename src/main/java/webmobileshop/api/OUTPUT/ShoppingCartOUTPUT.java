package webmobileshop.api.OUTPUT;

import webmobileshop.dto.ProductDTO;
import webmobileshop.dto.ShoppingCartDTO;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartOUTPUT {
    private int page;
    private int totalPage;
    private List<ShoppingCartDTO> listResult = new ArrayList<>();

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

    public List<ShoppingCartDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<ShoppingCartDTO> listResult) {
        this.listResult = listResult;
    }
}
