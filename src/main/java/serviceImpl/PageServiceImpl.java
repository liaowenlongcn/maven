package serviceImpl;

import mapper.PageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.bo.GetListBo;
import pojo.bo.page.GetColumsByActionBo;
import service.PageService;

import java.util.List;
import java.util.Map;

/**
 * Created by wenlong.liao on 2018/9/3.
 */
@Service
public class PageServiceImpl implements PageService {

    @Autowired
    private PageMapper mapper;

    public List<Map> getColumns(Integer pageId) throws Exception{
        return mapper.getColumns(pageId);
    }

    public List<Map> getList(GetListBo bo) throws Exception {
        return mapper.getList(bo);
    }

    public Integer getListCount(GetListBo bo) throws Exception {
        return mapper.getListCount(bo);
    }

    public List<Map> getColumsByAction(GetColumsByActionBo bo) throws Exception{
        return mapper.getColumsByAction(bo);
    }
}
