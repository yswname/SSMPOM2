package cn.com.demoall.ssm.entity;

import java.io.Serializable;

public class UserEntity implements Serializable {
    private Integer urId;

    private String urUserName;

    private String urName;

    private Integer urAge;

    private static final long serialVersionUID = 1L;

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