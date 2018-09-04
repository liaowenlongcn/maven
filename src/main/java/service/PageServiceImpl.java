package service;

import mapper.PageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.bo.GetListBo;

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
}
