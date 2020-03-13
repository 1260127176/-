package com.ruoyu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleTypeBean implements Serializable {
    private int articleTypeId = -1;
    private String articleTypeName = "";
    private String articleTypeDesc = "";

}
