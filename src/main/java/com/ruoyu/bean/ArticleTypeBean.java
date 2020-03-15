package com.ruoyu.bean;


import java.io.Serializable;

public class ArticleTypeBean implements Serializable {
    private Integer articleTypeId = -1;
    private String articleTypeName = "";
    private String articleTypeDesc = "";

    @Override
    public String toString() {
        return "ArticleTypeBean{" +
                "articleTypeId=" + articleTypeId +
                ", articleTypeName='" + articleTypeName + '\'' +
                ", articleTypeDesc='" + articleTypeDesc + '\'' +
                '}';
    }

    public ArticleTypeBean(Integer articleTypeId, String articleTypeName, String articleTypeDesc) {
        this.articleTypeId = articleTypeId;
        this.articleTypeName = articleTypeName;
        this.articleTypeDesc = articleTypeDesc;
    }

    public ArticleTypeBean() {
    }

    public Integer getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Integer articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public String getArticleTypeName() {
        return articleTypeName;
    }

    public void setArticleTypeName(String articleTypeName) {
        this.articleTypeName = articleTypeName;
    }

    public String getArticleTypeDesc() {
        return articleTypeDesc;
    }

    public void setArticleTypeDesc(String articleTypeDesc) {
        this.articleTypeDesc = articleTypeDesc;
    }
}
