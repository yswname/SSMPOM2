package cn.com.demo.ssm.spring.dao.impl;

import cn.com.demo.ssm.spring.dao.IUserDAO;

public class UserDAOImpl implements IUserDAO {
    public void save() {
        System.out.println("exectue userDAOImpl save");
    }

    public void findById(int id) {
        System.out.println("execute UserDAOImpl findById(" + id + ")");
    }

    public void findByUserName(String userName) {
        System.out.println("execute UserDAOImpl findByUserName(" + userName + ")");
    }
}
