package pojo.request.page;

import lombok.Data;
import pojo.enums.ActionType;

/**
 * Created by wenlong.liao on 2018/9/24.
 */
@Data
public class GetEntityByIdRequest {

    public String pageId;

    public String itemId;

}
