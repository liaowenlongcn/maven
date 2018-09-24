package pojo.request.page;

import lombok.Data;

import java.util.HashMap;

/**
 * Created by wenlong.liao on 2018/9/24.
 */
@Data
public class SaveBaseFormRequest {

    public  String pageId;

    public HashMap<String,String> keyValue;

}
