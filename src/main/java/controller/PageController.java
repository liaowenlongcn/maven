package controller;

import commn.ObjectHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.bo.GetListBo;
import pojo.request.GetListRequest;
import pojo.response.CommonRespnse;
import pojo.vo.BaseListVO;
import service.PageService;

import javax.security.auth.callback.Callback;
import java.util.List;
import java.util.Map;

/**
 * Created by wenlong.liao on 2018/9/3.
 */
@Controller
@RequestMapping("/page")
public class PageController  extends BaseController {

    @Autowired
    private PageService service;

    //查询列
    @RequestMapping("/getColumns")
    @ResponseBody
    public CommonRespnse<List<Map>> getColumns(Integer pageid) throws Exception {
        List<Map> list = service.getColumns(pageid);
        return CallBack(list);
    }

    //获取列表
    @RequestMapping("/getList")
    @ResponseBody
    public BaseListVO<Map> getList(GetListRequest request) throws Exception {
        GetListBo bo = new GetListBo();
        ObjectHelper.toBean(request, bo);

        BaseListVO<Map> listVo = new BaseListVO<Map>();
        List<Map> list = service.getList(bo);
        listVo.setData(list);
        listVo.setCount(1000);
        return listVo;
    }
}
