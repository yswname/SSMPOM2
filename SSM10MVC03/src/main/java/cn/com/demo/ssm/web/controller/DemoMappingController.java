package cn.com.demo.ssm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/mapping")
public class DemoMappingController {
    @RequestMapping("/test1")
    public void test1() {
        System.out.println("test1");
    }

    @RequestMapping(value = "/test3", method = RequestMethod.DELETE)
    public void test3() {
        System.out.println("test3");
    }

    //@GetMapping("/test2")//@PostMapping("/test2)
    @PostMapping("/test2")
    public void test2() {
        System.out.println("test2");
    }

    // 请求名称需要时test4，请求中一定要有name为age的参数
    //                      age=3    age!=3   !age
    @RequestMapping(value = "/test4", params = "!age")
    public void test4() {
        System.out.println("test4");
    }


}
