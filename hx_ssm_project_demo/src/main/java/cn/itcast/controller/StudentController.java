package cn.itcast.controller;

import cn.itcast.aop.Log;
import cn.itcast.domain.Student;
import cn.itcast.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/findAll")
    @Log//标识该方法需要记录日志
    public String findAll(Model model){
        List<Student> list = studentService.findAll();
        model.addAttribute("stulist",list);
        return "list";
    }

}
