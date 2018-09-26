package controller;

import commn.ObjectHelper;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.bo.GetListBo;
import pojo.bo.page.DeleteBo;
import pojo.bo.page.EntityInfoBo;
import pojo.bo.page.GetColumsByActionBo;
import pojo.bo.page.InsertValueBo;
import pojo.enums.ActionType;
import pojo.request.GetListRequest;
import pojo.request.page.DeleteItemRequest;
import pojo.request.page.GetColumsByActionRequest;
import pojo.request.page.GetEntityByIdRequest;
import pojo.request.page.SaveBaseFormRequest;
import pojo.response.CommonRespnse;
import pojo.vo.BaseListVO;
import service.PageService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by wenlong.liao on 2018/9/3.
 */
@Controller
@RequestMapping("/page")
public class PageController extends BaseController {

    @Autowired
    private PageService service;

    //查询字段信息
    @RequestMapping(value = "/getColumsByAction", method = {RequestMethod.POST})
    @ResponseBody
    public CommonRespnse<List<Map>> getColumsByAction(@RequestBody GetColumsByActionRequest request) throws Exception {
        GetColumsByActionBo bo = new GetColumsByActionBo();
        ObjectHelper.toBean(request, bo);
        bo.actionType = request.actionType.getValue();
        List<Map> list = service.getColumsByAction(bo);
        return CallBack(list);
    }

    //查询字段值
    @RequestMapping(value = "/getEntityById", method = {RequestMethod.POST})
    @ResponseBody
    public CommonRespnse<Map> getEntityById(@RequestBody GetEntityByIdRequest request) throws Exception {
        EntityInfoBo bo = new EntityInfoBo();
        bo.tableName = service.getPageById(request.pageId).tableName;
        bo.id = request.itemId;
        Map map = service.getEntityById(bo);
        return CallBack(map);
    }

    //保存表单
    @RequestMapping(value = "/saveBaseForm", method = {RequestMethod.POST})
    @ResponseBody
    public CommonRespnse<Integer> saveBaseForm(@RequestBody SaveBaseFormRequest request) throws Exception {
        InsertValueBo bo = new InsertValueBo();
        ObjectHelper.toBean(request, bo);
        String tableName = service.getPageById(request.pageId).tableName;
        if (bo.keyValue.containsKey("id")) {
            bo.keyValue.put("updatetime", ObjectHelper.getDatetime());
            bo.keyValue.put("updateuser", "");
        }
        else {
            bo.keyValue.put("createtime", ObjectHelper.getDatetime());
            bo.keyValue.put("createuser", "");
        }
        bo.tableName = tableName;
        Integer count = service.saveValues(bo);
        return CallBack(count);
    }

    //删除记录
    @RequestMapping(value = "/deleteItems", method = {RequestMethod.POST})
    @ResponseBody
    public CommonRespnse<Integer> deleteItems(@RequestBody DeleteItemRequest request) throws Exception {
        DeleteBo bo = new DeleteBo();
        ObjectHelper.toBean(request, bo);
        String tableName = service.getPageById(request.pageId).tableName;
        bo.tableName = tableName;
        Integer count = service.delete(bo);
        return CallBack(count);
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
        Integer count = service.getListCount(bo);
        listVo.setCount(count);
        return listVo;
    }
}
