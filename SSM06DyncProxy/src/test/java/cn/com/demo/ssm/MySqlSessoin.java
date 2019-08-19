package cn.com.demo.ssm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MySqlSessoin {
    public IDemo getObject() {
        IDemo demo = null;
        // CGLIB也可以同样效果
        // JDK中有一个Proxy类，提供了静态方法
        // 创建一个指定接口的对象！！！！！
        InvocationHandler hdl = new MyHandler();// 封装我们要执行的业务逻辑
        Class[] cls = {IDemo.class};
        // 创建指定接口的对象
        Object obj = Proxy.newProxyInstance(MySqlSessoin.class.getClassLoader(), cls, hdl);
        demo = (IDemo) obj;

        return demo;
    }
}
