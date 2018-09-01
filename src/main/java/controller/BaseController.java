package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.enums.ResultCode;
import pojo.response.CommonRespnse;

import javax.swing.text.View;

@Controller
public class BaseController {

    protected <T> CommonRespnse<T> CallBack(T body)  {
        return CallBack( ResultCode.Success, "",body);
    }

    protected <T> CommonRespnse<T> CallBack(ResultCode code,T body)  {
        return CallBack( code, "",body);
    }

    protected <T> CommonRespnse<T> CallBack(ResultCode code,String message)  {
        return CallBack( code, message,null);
    }

    protected <T> CommonRespnse<T> CallBack(ResultCode code,String message, T body)  {
        CommonRespnse<T> respnse=new CommonRespnse<T>();
        respnse.setResultCode(code);
        respnse.setMessage(message);
        respnse.setBody(body);
        return respnse;
    }

    @RequestMapping("/page")
    public ModelAndView Redirect(String viewName){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

    @RequestMapping("/main")
    public ModelAndView Redirect(){
        return Redirect("home/index");
    }

}
