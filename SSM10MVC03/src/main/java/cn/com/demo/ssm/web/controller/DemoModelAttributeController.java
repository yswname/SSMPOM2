package cn.com.demo.ssm.web.controller;

import cn.com.demo.ssm.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mdAttr")
public class DemoModelAttributeController {
    @ModelAttribute
    public User init() {
        System.out.println("*************");
        return new User();
    }

    @RequestMapping("/test1")
    public void test1() {
        System.out.println("11111");
    }

    @RequestMapping("/test2")
    public void test2() {
        System.out.println("22222");
    }

    @RequestMapping("/test3")
    @ModelAttribute("user")
    public User test3() {
        System.out.println("3333");
        return new User();
    }
}
