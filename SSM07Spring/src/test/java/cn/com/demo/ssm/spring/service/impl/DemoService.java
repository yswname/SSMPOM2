package cn.com.demo.ssm.spring.service.impl;

import cn.com.demo.ssm.spring.dao.IUserDAO;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DemoService {
    private int testInt;
    private String testString;
    private Map<Object, Object> testMap;
    private Properties testProps;
    private List testList;
    private IUserDAO userDAO;

    public DemoService() {
    }

    public DemoService(String testString, int testInt) {
        this.testInt = testInt;
        this.testString = testString;
    }

    public DemoService(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public int getTestInt() {
        return testInt;
    }

    public void setTestInt(int testInt) {
        this.testInt = testInt;
    }

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }


    public Map<Object, Object> getTestMap() {
        return testMap;
    }

    public void setTestMap(Map<Object, Object> testMap) {
        this.testMap = testMap;
    }

    public Properties getTestProps() {
        return testProps;
    }

    public void setTestProps(Properties testProps) {
        this.testProps = testProps;
    }

    public List getTestList() {
        return testList;
    }

    public void setTestList(List testList) {
        this.testList = testList;
    }

    public IUserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
