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
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
