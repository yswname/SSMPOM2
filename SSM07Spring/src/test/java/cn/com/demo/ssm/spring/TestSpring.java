package cn.com.demo.ssm.spring;

import cn.com.demo.ssm.spring.po.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSpring {
    public static void main(String[] args) {
        // 创建一个Spring容器对象，对象在初始化的时候，自动读取/解析xml中的信息
        ApplicationContext ctx = new ClassPathXmlApplicationContext("demoApplicationContext.xml");
        Person person = ctx.getBean(Person.class);
        System.out.println(person.getCard().getAddress().getCity());

//        DemoService demoService1 = ctx.getBean("demoService1", DemoService.class);
//        Map map = demoService1.getTestMap();
//        Set<Map.Entry> entrys = map.entrySet();
//        for (Map.Entry entry : entrys) {
//            Object key = entry.getKey();
//            Object value = entry.getValue();
//            System.out.println(key.getClass().getName() + ":" + key + "--->" + value.getClass().getName() + ":" + value);
//        }
//        List list = demoService1.getTestList();
//        for (Object obj : list) {
//            System.out.println(obj.getClass().getName() + ",,," + obj);
//        }

//        DemoService demoService2 = ctx.getBean("demoService2", DemoService.class);
//        DemoService demoService21 = ctx.getBean("demoService2", DemoService.class);
//        System.out.println(demoService2 == demoService21);
//        DemoService demoService3 = ctx.getBean("demoService3", DemoService.class);
//        DemoService demoService31 = ctx.getBean("abc", DemoService.class);
//        System.out.println(demoService3 == demoService31);
//        System.out.println(demoService2 == demoService3);
//        System.out.println(demoService3.getUserDAO());
//
//        DAOFactory factory = ctx.getBean("daoFactory", DAOFactory.class);
//        IUserDAO userDAO2 = ctx.getBean("userDAO2", IUserDAO.class);
//        System.out.println(factory + "\n\r" + userDAO2);

//        // 从容器中获取被管理的对象（service对象）
//        UserServiceImpl userService = (UserServiceImpl) ctx.getBean("userService");
//        boolean bool = userService.verify("zhangsan", "123456");
//        System.out.println(bool);
//
//        IUserDAO userDAO = ctx.getBean("userDAO", IUserDAO.class);
//        System.out.println(userDAO);
//
//        IUserDAO userDAO2 = ctx.getBean(IUserDAO.class);
//        String[] alias = ctx.getAliases("userService");
//        String[] names = ctx.getBeanDefinitionNames();

    }
}
