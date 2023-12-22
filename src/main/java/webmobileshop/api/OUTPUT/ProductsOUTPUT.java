package webmobileshop.api.OUTPUT;

import webmobileshop.dto.CorlorDTO;
import webmobileshop.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class ProductsOUTPUT {
    private int page;
    private int totalPage;
    private List<ProductDTO> listResult = new ArrayList<>();

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

    public List<ProductDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<ProductDTO> listResult) {
        this.listResult = listResult;
    }
}
