package controller;

import commn.ObjectHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pojo.bo.UserBo;
import pojo.bo.user.LoginBo;
import pojo.enums.ResultCode;
import pojo.request.user.LoginRequest;
import pojo.response.CommonRespnse;
import pojo.vo.BaseListVO;
import pojo.vo.UserVo;
import service.UserService;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    //用户登录
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    @ResponseBody
    public CommonRespnse<UserVo> login(@RequestBody LoginRequest request) throws Exception {
        LoginBo bo = new LoginBo();
        ObjectHelper.toBean(request, bo);
        UserVo vo = userService.login(bo);
        if (vo == null || vo.getId() == null) return CallBack(ResultCode.Failure, "用户名或密码错误！");
        return CallBack(vo);
    }

    //获取列表
    @RequestMapping("/getList")
    @ResponseBody
    public BaseListVO<UserVo> getList() throws Exception {
        BaseListVO<UserVo> listVo = new BaseListVO<UserVo>();
        List<UserVo> list = userService.findList(null);
        listVo.setData(list);
        listVo.setCount(1000);
        return listVo;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(Integer id) throws Exception {
        UserVo userVo = userService.get(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", userVo);
        modelAndView.setViewName("user/edit");
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public String save(UserBo userBo, MultipartFile imageFile) throws Exception {
        if (imageFile != null) {
            String originalFilename = imageFile.getOriginalFilename();
            String imagePath = "D:\\Download\\images\\";
            if (originalFilename != null && originalFilename.length() > 0) {
                String newFilename = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf('.'));
                File newFile = new File(imagePath + newFilename);
                imageFile.transferTo(newFile);
                userBo.setImg(newFilename);
            }
        }

        userService.update(userBo.getId(), userBo);
        return "redirect:findList";
    }

    @RequestMapping("/getUserById")
    public
    @ResponseBody
    UserVo getUserById(Integer id) throws Exception {
        UserVo userVo = userService.get(id);
        return userVo;
    }
}
