package mapper;

import pojo.bo.UserBo;
import pojo.vo.UserVo;

import java.util.List;

/**
 * Created by wenlong.liao on 2018/8/16.
 */
public interface UserMapper {
    //查询列表
    public List<UserVo> findList(UserBo userBo) throws Exception;

}
