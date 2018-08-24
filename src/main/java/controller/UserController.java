package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.ModelAndView;
import pojo.bean.User;
import pojo.bo.UserBo;
import pojo.vo.UserVo;
import service.UserService;
import service.UserServiceImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public ModelAndView list(){
        List<User> list= new ArrayList<User>();

        User user1=new User();
        user1.setName("张三");
        user1.setSex(true);
        user1.setAge(18);
        list.add(user1);

        User user2=new User();
        user2.setName("李四");
        user2.setSex(false);
        user2.setAge(28);
        list.add(user2);

        User user3=new User();
        user3.setName("王五");
        user3.setSex(true);
        user3.setAge(16);
        list.add(user3);

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("user/list");
        return modelAndView;
    }

    @RequestMapping("/findList")
    public ModelAndView findList() throws Exception {
        List<UserVo> list=  userService.findList(null);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("user/list");
        return modelAndView;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(Integer id) throws Exception {
        UserVo userVo=  userService.get(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("user",userVo);
        modelAndView.setViewName("user/edit");
        return modelAndView;
    }

    @RequestMapping(value = "/save",method ={RequestMethod.POST})
    public String save(UserBo userBo, MultipartFile imageFile) throws Exception {
        if(imageFile!=null){
            String originalFilename=imageFile.getOriginalFilename();
            String imagePath="D:\\Download\\images\\";
            if(originalFilename!=null&&originalFilename.length()>0){
                String newFilename= UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf('.'));
                File newFile=new File(imagePath+newFilename);
                imageFile.transferTo(newFile);
                userBo.setImg(newFilename);
            }
        }

        userService.update(userBo.getId(),userBo);
        return "redirect:findList";
    }
}
