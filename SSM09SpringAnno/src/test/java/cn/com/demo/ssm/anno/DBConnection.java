package cn.com.demo.ssm.anno;

import java.lang.reflect.Method;
import java.sql.*;

public class DBConnection {
    private String userName;
    private String url;
    private String password;

    public DBConnection() {
        this.init();
    }

    @DBInfo(driverClassName = "com.mysql.jdbc.Driver", url = "jdbc:mysql://localhost:3306/snacks_db?characterEncoding=utf8", password = "123456", age = 13, username = "root")
    private void init() {
        // 读取加载DBConnection的init方法上的注解信息
        // DBConnection的类对象
        Class cls = DBConnection.class;
        //  获取init对象
        try {
            Method initMethod = cls.getDeclaredMethod("init", null);
            //  获取DBInfo注解对象
            DBInfo dbInfo = initMethod.getAnnotation(DBInfo.class);

            String driverName = dbInfo.driverClassName();
            int age = dbInfo.age();
            this.url = dbInfo.url();
            this.userName = dbInfo.username();
            this.password = dbInfo.password();

            System.out.println("age=" + age);
            Class.forName(driverName);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void close(Connection conn, Statement stmt, ResultSet rs) {

    }

    public static void main(String[] args) {
        DBConnection dbConn = new DBConnection();
        Connection conn = dbConn.getConnection();
        System.out.println(conn);
    }
}
