package cn.com.demo.ssm.web.controller;

import cn.com.demo.ssm.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

@Controller
@RequestMapping("/res")
public class DemoResponseController {
    @RequestMapping("/test8")
    @ResponseBody
    public User test8() {
        User user = new User();
        user.setAge(10);
        user.setName("zhangsan");
        user.setUserName("zzz");
        return user;
    }

    @RequestMapping("/test7")
    public String test7() {
        return "forward:/res/test5";// "redirect:url"
    }

    @RequestMapping("/test6")
    @ResponseBody
    public String test6() {
        return "hello,测试响应";
    }

    @RequestMapping("/test5")
    public String test5(Model model) {
        model.addAttribute("name", "李四");
        return "demo";
    }

    @RequestMapping("/test4")
    public ModelAndView test4() {
        ModelAndView mv = new ModelAndView();
        // view name  /WEB-INF/jsp/     .jsp
        mv.setViewName("demo");
        mv.addObject("name", "张三");
        // request.setAttribute("name", "张三");
        return mv;
    }

    @RequestMapping("/test3")
    public void test3(Writer out, Reader reader) {
        try {
            out.write("Hello,how are you !!!!!!!!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/test1")
    public void test1(HttpServletResponse res) {
        res.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter out = res.getWriter();
            out.println("Hello ,how are you!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/test2")
    public void test2(HttpServletRequest req, HttpServletResponse res) {
        try {
            req.getRequestDispatcher("/WEB-INF/jsp/demo.jsp").forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
