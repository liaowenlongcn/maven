package pojo.bo.page;

import lombok.Data;

import java.util.List;

/**
 * Created by wenlong.liao on 2018/9/25.
 */
@Data
public class DeleteBo{
    public String tableName;
    public List<String> ids;
}
