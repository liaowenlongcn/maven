package serviceImpl;

import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.bo.UserBo;
import pojo.bo.user.LoginBo;
import pojo.vo.UserVo;
import service.UserService;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    //用户登录
    public UserVo login(LoginBo loginBo) throws Exception {
        return mapper.login(loginBo);
    }

    public List<UserVo> findList(UserBo userBo) throws Exception {
        return mapper.findList(userBo);
    }

    public UserVo get(int id) throws Exception {
        return mapper.get(id);
    }

    public void update(int id, UserBo userBo) throws Exception {
         mapper.update(id,userBo);
    }
}
