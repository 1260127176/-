package com.ruoyu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class XbloUserBean implements Serializable {
    private Integer xbloUserId = -1;
    private String xbloUsername = "";
    private String xbloPassword = "";
    private String email = null;

}
