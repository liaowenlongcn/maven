package mapper;

import pojo.bo.GetListBo;

import java.util.List;
import java.util.Map;

/**
 * Created by wenlong.liao on 2018/9/3.
 */
public interface PageMapper {

    public List<Map> getColumns(Integer pageId) throws Exception;

    public List<Map> getList(GetListBo bo) throws Exception;

    public Integer getListCount(GetListBo bo) throws Exception;
}
