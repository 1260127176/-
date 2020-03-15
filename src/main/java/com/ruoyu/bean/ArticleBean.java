package com.ruoyu.bean;


import java.io.Serializable;

public class ArticleBean implements Serializable {

    // DB字段
    private int articleId = -1; // 文章ID
    private int articleTypeId = -1; // 类型ID
    private String articleTitle = ""; // 文章标题
    private String articleSummary = ""; // 文章摘要
    private String articleContent = ""; // 文章内容
    private String createDate = ""; // 创建时间
    private int visitCount = 0; // 访问次数
    private int createUserId = -1; // 用户ID


    @Override
    public String toString() {
        return "ArticleBean{" +
                "articleId=" + articleId +
                ", articleTypeId=" + articleTypeId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleSummary='" + articleSummary + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", createDate='" + createDate + '\'' +
                ", visitCount=" + visitCount +
                ", createUserId=" + createUserId +
                '}';
    }

    public ArticleBean(int articleId, int articleTypeId, String articleTitle, String articleSummary, String articleContent, String createDate, int visitCount, int createUserId) {
        this.articleId = articleId;
        this.articleTypeId = articleTypeId;
        this.articleTitle = articleTitle;
        this.articleSummary = articleSummary;
        this.articleContent = articleContent;
        this.createDate = createDate;
        this.visitCount = visitCount;
        this.createUserId = createUserId;
    }

    public ArticleBean() {
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(int articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public int getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(int createUserId) {
        this.createUserId = createUserId;
    }
}
