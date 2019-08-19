package cn.com.demo.ssm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {
    @Override
    // 回调方法（调用前面接口的任何一个方法的时候，都回调用过来）
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        if (args != null && args.length == 1) {
            new MyLoger().log((String) args[0]);
        } else {
            new MyLoger().log("hello how are you!");
        }
        return result;
    }
}
