package com.ruoyu.bean;


import java.io.Serializable;

public class ArticleCommentBean implements Serializable {
    private Integer articleCommentId = -1;
    private Integer articleId = -1;
    private String articleCommentDate = "";
    private String articleCommentUser = "";
    private String articleCommentEmail = ""; // 不显示，仅用来发送回复通知
    private String articleCommentContent = "";


    @Override
    public String toString() {
        return "ArticleCommentBean{" +
                "articleCommentId=" + articleCommentId +
                ", articleId=" + articleId +
                ", articleCommentDate='" + articleCommentDate + '\'' +
                ", articleCommentUser='" + articleCommentUser + '\'' +
                ", articleCommentEmail='" + articleCommentEmail + '\'' +
                ", articleCommentContent='" + articleCommentContent + '\'' +
                '}';
    }

    public Integer getArticleCommentId() {
        return articleCommentId;
    }

    public void setArticleCommentId(Integer articleCommentId) {
        this.articleCommentId = articleCommentId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleCommentDate() {
        return articleCommentDate;
    }

    public void setArticleCommentDate(String articleCommentDate) {
        this.articleCommentDate = articleCommentDate;
    }

    public String getArticleCommentUser() {
        return articleCommentUser;
    }

    public void setArticleCommentUser(String articleCommentUser) {
        this.articleCommentUser = articleCommentUser;
    }

    public String getArticleCommentEmail() {
        return articleCommentEmail;
    }

    public void setArticleCommentEmail(String articleCommentEmail) {
        this.articleCommentEmail = articleCommentEmail;
    }

    public String getArticleCommentContent() {
        return articleCommentContent;
    }

    public void setArticleCommentContent(String articleCommentContent) {
        this.articleCommentContent = articleCommentContent;
    }

    public ArticleCommentBean(Integer articleCommentId, Integer articleId, String articleCommentDate, String articleCommentUser, String articleCommentEmail, String articleCommentContent) {
        this.articleCommentId = articleCommentId;
        this.articleId = articleId;
        this.articleCommentDate = articleCommentDate;
        this.articleCommentUser = articleCommentUser;
        this.articleCommentEmail = articleCommentEmail;
        this.articleCommentContent = articleCommentContent;
    }

    public ArticleCommentBean() {
    }
}
