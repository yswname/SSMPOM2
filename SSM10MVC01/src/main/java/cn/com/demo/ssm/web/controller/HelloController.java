package cn.com.demo.ssm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller// @Component Service Resportory
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/hello")   //  /hello/hello   request.getParameter("name")
    public ModelAndView hello(String name) {
        ModelAndView mv = new ModelAndView("hello");// WEB-INF/jsp/hello.jsp
        mv.addObject("name", name);
        return mv;
    }
}
