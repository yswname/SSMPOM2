package cn.com.demo.ssm.spring.mybatis.entity;

import java.io.Serializable;

public class CardEntity implements Serializable {
    private Integer icId;

    private String icCode;

    private String icAddress;

    private static final long serialVersionUID = 1L;

    public Integer getIcId() {
        return icId;
    }

    public void setIcId(Integer icId) {
        this.icId = icId;
    }

    public String getIcCode() {
        return icCode;
    }

    public void setIcCode(String icCode) {
        this.icCode = icCode == null ? null : icCode.trim();
    }

    public String getIcAddress() {
        return icAddress;
    }

    public void setIcAddress(String icAddress) {
        this.icAddress = icAddress == null ? null : icAddress.trim();
    }
}