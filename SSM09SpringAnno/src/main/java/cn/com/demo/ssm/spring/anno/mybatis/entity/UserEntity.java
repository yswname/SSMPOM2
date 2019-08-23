package cn.com.demo.ssm.spring.anno.mybatis.entity;

import java.io.Serializable;
import java.util.List;

public class UserEntity implements Serializable {
    private Integer urId;

    private String urUserName;

    private String urName;

    private Integer urAge;

    private List<RoleEntity> roleList;

    private static final long serialVersionUID = 1L;

    public List<RoleEntity> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleEntity> roleList) {
        this.roleList = roleList;
    }

    public Integer getUrId() {
        return urId;
    }

    public void setUrId(Integer urId) {
        this.urId = urId;
    }

    public String getUrUserName() {
        return urUserName;
    }

    public void setUrUserName(String urUserName) {
        this.urUserName = urUserName == null ? null : urUserName.trim();
    }

    public String getUrName() {
        return urName;
    }

    public void setUrName(String urName) {
        this.urName = urName == null ? null : urName.trim();
    }

    public Integer getUrAge() {
        return urAge;
    }

    public void setUrAge(Integer urAge) {
        this.urAge = urAge;
    }
}