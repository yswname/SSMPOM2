package cn.com.demo.ssm;

public class TestMain {
    public static void main(String[] args) {
        IDemo demo = new MySqlSessoin().getObject();//new DemoImpl();
        demo.test2("渊博");
    }
}
