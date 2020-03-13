package com.ruoyu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
