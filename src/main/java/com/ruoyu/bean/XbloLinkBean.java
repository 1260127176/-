package com.ruoyu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

public class XbloLinkBean implements Serializable {
    private int xbloLinkId = -1;
    private String xbloLinkName = "";
    private String xbloLinkUrl = "";

    @Override
    public String toString() {
        return "XbloLinkBean{" +
                "xbloLinkId=" + xbloLinkId +
                ", xbloLinkName='" + xbloLinkName + '\'' +
                ", xbloLinkUrl='" + xbloLinkUrl + '\'' +
                '}';
    }

    public XbloLinkBean(int xbloLinkId, String xbloLinkName, String xbloLinkUrl) {
        this.xbloLinkId = xbloLinkId;
        this.xbloLinkName = xbloLinkName;
        this.xbloLinkUrl = xbloLinkUrl;
    }

    public XbloLinkBean() {
    }

    public int getXbloLinkId() {
        return xbloLinkId;
    }

    public void setXbloLinkId(int xbloLinkId) {
        this.xbloLinkId = xbloLinkId;
    }

    public String getXbloLinkName() {
        return xbloLinkName;
    }

    public void setXbloLinkName(String xbloLinkName) {
        this.xbloLinkName = xbloLinkName;
    }

    public String getXbloLinkUrl() {
        return xbloLinkUrl;
    }

    public void setXbloLinkUrl(String xbloLinkUrl) {
        this.xbloLinkUrl = xbloLinkUrl;
    }
}
