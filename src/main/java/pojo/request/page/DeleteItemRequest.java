package pojo.request.page;

import lombok.Data;

import java.util.List;

/**
 * Created by wenlong.liao on 2018/9/26.
 */
@Data
public class DeleteItemRequest {
    public List<String> ids;

    public String pageId;
}
