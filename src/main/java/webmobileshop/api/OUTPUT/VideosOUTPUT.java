package webmobileshop.api.OUTPUT;

import webmobileshop.dto.UserTokenDTO;
import webmobileshop.dto.VideoDTO;

import java.util.ArrayList;
import java.util.List;

public class VideosOUTPUT {
    private int page;
    private int totalPage;
    private List<VideoDTO> listResult = new ArrayList<>();

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

    public List<VideoDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<VideoDTO> listResult) {
        this.listResult = listResult;
    }
}
