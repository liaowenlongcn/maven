package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.bean.User;
import pojo.vo.UserVo;
import service.UserService;
import service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

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
    public ModelAndView edit() throws Exception {
        UserVo userVo=  userService.get(1);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("user",userVo);
        modelAndView.setViewName("user/edit");
        return modelAndView;
    }

    @RequestMapping(value = "/save",method ={RequestMethod.POST})
    public String save() throws Exception {
        //userService.update(1,null);
         return "redirect:findList";
    }
}
