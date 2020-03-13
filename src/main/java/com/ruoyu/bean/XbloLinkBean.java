package com.ruoyu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class XbloLinkBean implements Serializable {
    private int xbloLinkId = -1;
    private String xbloLinkName = "";
    private String xbloLinkUrl = "";

}
