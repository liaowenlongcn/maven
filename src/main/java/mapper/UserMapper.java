package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.bo.UserBo;
import pojo.vo.UserVo;

import java.util.List;

/**
 * Created by wenlong.liao on 2018/8/16.
 */
public interface UserMapper {
    //查询列表
    public List<UserVo> findList(UserBo userBo) throws Exception;
    //查询实体
    public UserVo get(int id) throws Exception;
    //更新实体
    public void update(int id,@Param("userBo") UserBo userBo) throws Exception;

}
