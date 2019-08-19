package cn.com.demo.ssm.spring.dao;

public interface IUserDAO {
    public void save();

    public void findById(int id);

    public void findByUserName(String userName);
}
