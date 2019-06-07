package cn.itcast.controller;

import cn.itcast.aop.Log;
import cn.itcast.common.Result;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @Log//标识该方法需要记录日志
    public String login(HttpServletRequest request, User user){

        log.info("------------> 用户登录 : username = " + user.getName());

        User u = userService.login(user);
        if(u!= null){
            request.getSession().setAttribute("loginUser",u);
            log.info("------------> 用户登录成功");
        }else{
            log.error("------------> 用户登录失败");
        }
        return "redirect:/student/findAll.do";
    }

}
