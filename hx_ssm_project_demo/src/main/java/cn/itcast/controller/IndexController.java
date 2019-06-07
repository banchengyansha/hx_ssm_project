package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

    // 用户跳转页面
    @RequestMapping("/{index}")
    private String index(@PathVariable("index") String index){
        return index;
    }

}
