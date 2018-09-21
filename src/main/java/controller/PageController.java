package controller;

import commn.ObjectHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.bo.GetListBo;
import pojo.bo.page.GetColumsByActionBo;
import pojo.request.GetListRequest;
import pojo.request.page.GetColumsByActionRequest;
import pojo.response.CommonRespnse;
import pojo.vo.BaseListVO;
import service.PageService;

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

    //查询字段信息
    @RequestMapping(value = "/getColumsByAction", method = {RequestMethod.POST})
    @ResponseBody
    public CommonRespnse<List<Map>> getColumsByAction(@RequestBody GetColumsByActionRequest request) throws Exception {
        GetColumsByActionBo bo=new GetColumsByActionBo();
        ObjectHelper.toBean(request, bo);
        List<Map> list = service.getColumsByAction(bo);
        return CallBack(list);
    }


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
        Integer count=service.getListCount(bo);
        listVo.setCount(count);
        return listVo;
    }
}
