package cn.com.demo.ssm.web.controller;

import cn.com.demo.ssm.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/request")
public class DemoRequestParamController {
    // HttpServletRequest 获取请求数据
    // 1 request对象
    // 2 从request对象中获取想要得数据
    @GetMapping("/req")
    public void test1(HttpServletRequest request) {
        String name = request.getParameter("name");
        System.out.println("test1->" + name);
    }

    // 可以通过定义普通类型得参数，自动接收request对象中得参数值
    // 1 缺省对应  两个参数得name一一对应
    // 2 @RequestParam 实现请求Parameter同Method得param对应
    //    name required defaultValue
    @GetMapping("/req2")
    public void test2(@RequestParam(name = "name1", required = false) String name,
                      @RequestParam(name = "age1", required = false, defaultValue = "0") int age) {
        System.out.println("test2->" + name + "," + age);
    }

    // 定义对象类型得参数，接收请求
    @GetMapping("/req3")
    public void test3(User user, User user2) {
        System.out.println("test3->" + user);
        System.out.println("test3->" + user2);
    }

    // Restfull
    @GetMapping("/req3/{age}")
    public void test4(@PathVariable("age") int age) {
        System.out.println("test4=>" + age);
    }
}
