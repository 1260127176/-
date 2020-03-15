package com.ruoyu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Project_Name:ruoyu
 * ClassName:ArticleMessage
 * Package:com.ruoyu.bean
 *
 * @Date:2020/2/26 15:04
 * Author:1260127176@qq.com
 * author:12601
 */
public class ArticleMessage implements Serializable {
    private int articleId = -1; // 文章ID
    private String articleTitle = ""; // 文章标题
    private String articleSummary = ""; // 文章摘要
    private String articleContent = ""; // 文章内容
    private String createDate = ""; // 创建时间
    private int visitCount = 0; // 访问次数
    private int createUserId = -1; // 用户ID
    private String articleTypeName = "";
    private String xbloUsername = "";

    @Override
    public String toString() {
        return "ArticleMessage{" +
                "articleId=" + articleId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleSummary='" + articleSummary + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", createDate='" + createDate + '\'' +
                ", visitCount=" + visitCount +
                ", createUserId=" + createUserId +
                ", articleTypeName='" + articleTypeName + '\'' +
                ", xbloUsername='" + xbloUsername + '\'' +
                '}';
    }

    public ArticleMessage(int articleId, String articleTitle, String articleSummary, String articleContent, String createDate, int visitCount, int createUserId, String articleTypeName, String xbloUsername) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleSummary = articleSummary;
        this.articleContent = articleContent;
        this.createDate = createDate;
        this.visitCount = visitCount;
        this.createUserId = createUserId;
        this.articleTypeName = articleTypeName;
        this.xbloUsername = xbloUsername;
    }

    public ArticleMessage() {
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
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

    public String getArticleTypeName() {
        return articleTypeName;
    }

    public void setArticleTypeName(String articleTypeName) {
        this.articleTypeName = articleTypeName;
    }

    public String getXbloUsername() {
        return xbloUsername;
    }

    public void setXbloUsername(String xbloUsername) {
        this.xbloUsername = xbloUsername;
    }
}
