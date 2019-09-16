package cn.com.demo.ssm.web.controller;

import cn.com.demo.ssm.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    @Qualifier("demoService")
    private IDemoService demoService;

    @RequestMapping("/demo")
    public ModelAndView demo(String name) {
        ModelAndView mv = new ModelAndView("demo");
        mv.addObject("name", name);
        // 调用后面的service
        this.demoService.demo(name);
        System.out.println("22222222222222222222");
        return mv;
    }
}
