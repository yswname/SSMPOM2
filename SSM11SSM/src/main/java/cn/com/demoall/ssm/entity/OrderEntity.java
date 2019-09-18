package cn.com.demoall.ssm.entity;

import java.io.Serializable;

public class OrderEntity implements Serializable {
    private Integer odId;

    private Integer odUrId;

    private String odName;

    private static final long serialVersionUID = 1L;

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public Integer getOdUrId() {
        return odUrId;
    }

    public void setOdUrId(Integer odUrId) {
        this.odUrId = odUrId;
    }

    public String getOdName() {
        return odName;
    }

    public void setOdName(String odName) {
        this.odName = odName == null ? null : odName.trim();
    }
}