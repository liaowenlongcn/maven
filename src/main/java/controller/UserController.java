package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.beans.User;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
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

}