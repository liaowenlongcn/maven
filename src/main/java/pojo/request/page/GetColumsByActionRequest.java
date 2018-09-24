package pojo.request.page;

import lombok.Data;
import pojo.enums.ActionType;

/**
 * Created by wenlong.liao on 2018/9/20.
 */
@Data
public class GetColumsByActionRequest {

    public String pageId;

    public ActionType actionType;

}
