package cn.com.demo.ssm.spring.anno.mybatis.entity;

import java.io.Serializable;
import java.util.List;

public class RoleEntity implements Serializable {
    private Integer rlId;

    private String rlName;

    private List<UserEntity> userList;

    private static final long serialVersionUID = 1L;

    public List<UserEntity> getUserList() {
        return userList;
    }

    public void setUserList(List<UserEntity> userList) {
        this.userList = userList;
    }

    public Integer getRlId() {
        return rlId;
    }

    public void setRlId(Integer rlId) {
        this.rlId = rlId;
    }

    public String getRlName() {
        return rlName;
    }

    public void setRlName(String rlName) {
        this.rlName = rlName == null ? null : rlName.trim();
    }
}