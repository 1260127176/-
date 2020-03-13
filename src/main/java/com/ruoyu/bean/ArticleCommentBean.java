package com.ruoyu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCommentBean implements Serializable {
    private Integer articleCommentId = -1;
    private Integer articleId = -1;
    private String articleCommentDate = "";
    private String articleCommentUser = "";
    private String articleCommentEmail = ""; // 不显示，仅用来发送回复通知
    private String articleCommentContent = "";

}
