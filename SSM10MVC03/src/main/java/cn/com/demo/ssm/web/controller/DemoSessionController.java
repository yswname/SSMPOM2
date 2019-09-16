package cn.com.demo.ssm.web.controller;

import cn.com.demo.ssm.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/session")
@SessionAttributes(value = "user")// 将model中user属性的值，set到session对象中
public class DemoSessionController {
    @RequestMapping("/set")
    public String setAttribute(@ModelAttribute User user) {// user   TestDemo->testDemo
        System.out.println("1request");
        String result = "demo";
        return result;
    }

    @RequestMapping("/get")// 有才能获取，否则异常
    public void getAttribute(@SessionAttribute("user") User user) {
        System.out.println("2request");
        System.out.println(user);
    }

    @RequestMapping("/logout")
    public void finishSession(SessionStatus status) {
        System.out.println("3request");
        status.setComplete();
    }

    @ModelAttribute("user")
    public User init() {
        System.out.println("************");
        return new User();
    }
}
