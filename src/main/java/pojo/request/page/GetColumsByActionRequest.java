package pojo.request.page;

/**
 * Created by wenlong.liao on 2018/9/20.
 */
public class GetColumsByActionRequest {
    public String pageId;
    public Integer actionType;

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public Integer getActionType() {
        return actionType;
    }

    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }

}
