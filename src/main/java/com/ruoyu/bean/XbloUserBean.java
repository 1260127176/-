package com.ruoyu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

public class XbloUserBean implements Serializable {
    private Integer xbloUserId = -1;
    private String xbloUsername = "";
    private String xbloPassword = "";
    private String email = null;

    @Override
    public String toString() {
        return "XbloUserBean{" +
                "xbloUserId=" + xbloUserId +
                ", xbloUsername='" + xbloUsername + '\'' +
                ", xbloPassword='" + xbloPassword + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public XbloUserBean(Integer xbloUserId, String xbloUsername, String xbloPassword, String email) {
        this.xbloUserId = xbloUserId;
        this.xbloUsername = xbloUsername;
        this.xbloPassword = xbloPassword;
        this.email = email;
    }

    public XbloUserBean() {
    }

    public Integer getXbloUserId() {
        return xbloUserId;
    }

    public void setXbloUserId(Integer xbloUserId) {
        this.xbloUserId = xbloUserId;
    }

    public String getXbloUsername() {
        return xbloUsername;
    }

    public void setXbloUsername(String xbloUsername) {
        this.xbloUsername = xbloUsername;
    }

    public String getXbloPassword() {
        return xbloPassword;
    }

    public void setXbloPassword(String xbloPassword) {
        this.xbloPassword = xbloPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
