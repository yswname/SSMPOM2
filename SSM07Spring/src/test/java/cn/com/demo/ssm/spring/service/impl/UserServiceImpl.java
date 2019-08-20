package cn.com.demo.ssm.spring.service.impl;

import cn.com.demo.ssm.spring.dao.IUserDAO;

public class UserServiceImpl {
    private IUserDAO userDAO;

    public UserServiceImpl() {
        System.out.println("********************");
    }

    public boolean verify(String userName, String password) {
        boolean bool = false;
        // 查找数据库中的用户对象（包含数据库中密码）
        userDAO.findByUserName(userName);
        // 比较数据库密码
        String dbPassword = "123456";
        bool = dbPassword.equals(password);
        // 返回验证结果
        return bool;
    }

    public void setUserDAO(IUserDAO userDAO) {
        System.out.println("setter  userDAO!!!!!!!!!!");
        this.userDAO = userDAO;
    }
}
