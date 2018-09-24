import lombok.experimental.var;
import mapper.PageMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.bo.page.GetColumsByActionBo;
import pojo.bo.page.InsertValueBo;
import service.PageService;
import serviceImpl.PageServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wenlong.liao on 2018/9/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:*.xml"})
public class PageServiceTest {
    @Autowired
    private PageService service;

    @Test
    public void testGetColumsByAction() throws Exception {
        GetColumsByActionBo bo = new GetColumsByActionBo();
        bo.setActionType(3);
        bo.setPageId("1");
        List<Map> result = service.getColumsByAction(bo);
        System.out.println(result);
    }

    @Test
    public void testSaveValues() throws Exception {
        InsertValueBo bo = new InsertValueBo();
        bo.tableName = "sys_user";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("username", "4567");
        map.put("password", "8901");
        bo.keyValue = map;
        Integer result = service.saveValues(bo);
        System.out.println(result);
    }
}



