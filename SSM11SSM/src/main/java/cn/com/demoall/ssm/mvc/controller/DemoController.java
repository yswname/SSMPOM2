package cn.com.demoall.ssm.mvc.controller;

import cn.com.demoall.ssm.entity.UserEntity;
import cn.com.demoall.ssm.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    @Qualifier("demoService")
    private IDemoService demoService;

    @RequestMapping("/test1")
    public String test1(Model model) {
        model.addAttribute("name", "张三");
        return "test";
    }

    @RequestMapping("/registerPage")
    public String registerPage() {
        return "demoRegister";
    }

    @RequestMapping("/register")
    public String register(UserEntity user, Model model) {
        String result = "forward:/demo/userList";// 转向用户列表
        try {
            this.demoService.register(user);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", e.getMessage());
            result = "forward:/demo/registerPage";
        }
        return result;
    }

    @RequestMapping("/userList")
    public String userList(Model model) {
        List<UserEntity> userList = this.demoService.searchAllUsers();
        model.addAttribute("userList", userList);
        return "userList";
    }
}
