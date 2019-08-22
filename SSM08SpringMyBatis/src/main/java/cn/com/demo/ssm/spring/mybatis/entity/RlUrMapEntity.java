package cn.com.demo.ssm.spring.mybatis.entity;

import java.io.Serializable;

public class RlUrMapEntity implements Serializable {
    private Integer mpUrId;

    private Integer mpRlId;

    private static final long serialVersionUID = 1L;

    public Integer getMpUrId() {
        return mpUrId;
    }

    public void setMpUrId(Integer mpUrId) {
        this.mpUrId = mpUrId;
    }

    public Integer getMpRlId() {
        return mpRlId;
    }

    public void setMpRlId(Integer mpRlId) {
        this.mpRlId = mpRlId;
    }
}