package service;

import pojo.bean.page.Page;
import pojo.bo.GetListBo;
import pojo.bo.page.EntityInfoBo;
import pojo.bo.page.GetColumsByActionBo;
import pojo.bo.page.InsertValueBo;

import java.util.List;
import java.util.Map;

/**
 * Created by wenlong.liao on 2018/9/3.
 */
public interface PageService {

    public List<Map> getColumns(Integer pageId) throws Exception;

    public List<Map> getList(GetListBo bo) throws Exception;

    public Integer getListCount(GetListBo bo) throws Exception;

    public List<Map> getColumsByAction(GetColumsByActionBo bo) throws Exception;

    public Integer saveValues(InsertValueBo bo) throws Exception;

    public Page getPageById(String id) throws Exception;

    public Map getEntityById(EntityInfoBo bo) throws Exception;
}
