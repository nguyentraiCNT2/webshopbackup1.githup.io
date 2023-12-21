package webmobileshop.api.OUTPUT;

import webmobileshop.dto.CorlorDTO;
import webmobileshop.dto.VideoDTO;

import java.util.ArrayList;
import java.util.List;

public class CorlorOUTPUT {
    private int page;
    private int totalPage;
    private List<CorlorDTO> listResult = new ArrayList<>();

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

    public List<CorlorDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<CorlorDTO> listResult) {
        this.listResult = listResult;
    }
}
