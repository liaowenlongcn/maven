package service;

import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.bo.UserBo;
import pojo.vo.UserVo;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<UserVo> findList(UserBo userBo) throws Exception {
        return userMapper.findList(userBo);
    }

    public UserVo get(int id) throws Exception {
        return userMapper.get(id);
    }

    public void update(int id, UserBo userBo) throws Exception {
         userMapper.update(id,userBo);
    }
}
