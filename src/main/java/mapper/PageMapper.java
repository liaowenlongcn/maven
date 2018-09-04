package mapper;

import pojo.bo.GetListBo;

import java.util.List;
import java.util.Map;

/**
 * Created by wenlong.liao on 2018/9/3.
 */
public interface PageMapper {
    //查询列
    public List<Map> getColumns(Integer pageId) throws Exception;
    //查询列表
    public List<Map> getList(GetListBo bo) throws Exception;
}
