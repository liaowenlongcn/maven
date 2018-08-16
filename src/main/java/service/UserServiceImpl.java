package service;

import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.bo.UserBo;
import pojo.vo.UserVo;

import java.util.List;

/**
 * Created by wenlong.liao on 2018/8/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<UserVo> findList(UserBo userBo) throws Exception {
        return userMapper.findList(userBo);
    }
}
