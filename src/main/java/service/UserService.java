package service;

import org.springframework.stereotype.Service;
import pojo.bo.UserBo;
import pojo.vo.UserVo;
import java.util.List;


public interface UserService {
    //查询列表
    public List<UserVo> findList(UserBo userBo) throws Exception;
}
