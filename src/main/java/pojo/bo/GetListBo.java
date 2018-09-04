package pojo.bo;

/**
 * Created by wenlong.liao on 2018/9/3.
 */
public class GetListBo {
    private Integer page;

    private Integer limit;

    private String keyValue;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

}
