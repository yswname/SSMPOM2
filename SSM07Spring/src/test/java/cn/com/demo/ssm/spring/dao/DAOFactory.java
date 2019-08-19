package cn.com.demo.ssm.spring.dao;

import cn.com.demo.ssm.spring.dao.impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory factory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (factory == null) {
            factory = new DAOFactory();
        }
        return factory;
    }

    public IUserDAO createUserDAO() {
        return new UserDAOImpl();
    }
}
