package pojo.bo.page;

import lombok.Data;
import java.util.HashMap;

/**
 * Created by wenlong.liao on 2018/9/22.
 */
@Data
public class InsertValueBo {

    public String tableName;

     public HashMap<String,String> keyValue;
}
