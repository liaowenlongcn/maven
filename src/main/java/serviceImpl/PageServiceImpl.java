package serviceImpl;

import mapper.PageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.bean.page.Page;
import pojo.bo.GetListBo;
import pojo.bo.page.DeleteBo;
import pojo.bo.page.EntityInfoBo;
import pojo.bo.page.GetColumsByActionBo;
import pojo.bo.page.InsertValueBo;
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

    public Integer saveValues(InsertValueBo bo) throws Exception{
        return  mapper.saveValues(bo);
    }

    public Page getPageById(String id) throws Exception{
        return  mapper.getPageById(id);
    }

    public Map getEntityById(EntityInfoBo bo) throws Exception{
        return  mapper.getEntityById(bo);
    }

    public Integer delete(DeleteBo bo) throws Exception{
        return  mapper.delete(bo);
    }
}
