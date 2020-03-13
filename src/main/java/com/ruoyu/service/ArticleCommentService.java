package com.ruoyu.service;

import com.ruoyu.bean.ArticleCommentBean;
import org.apache.ibatis.annotations.*;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Project_Name:springcloud-sonsul-demo
 * ClassName:ArticleCommentMapper
 * Package:com.ruoyu.mapper
 *
 * @Date:2020/2/11 16:11
 * Author:1260127176@qq.com
 * author:12601
 */
public interface ArticleCommentService {
    //添加
    Integer addArticleComment(ArticleCommentBean articleCommentBean);
    //删除
    Integer delArticleComment(@Param("articleCommentId") Integer articleCommentId);
    //修改
    Integer updArticleComment(ArticleCommentBean articleCommentBean);
    //查询一个
    ArticleCommentBean findByCommentId(@Param("articleCommentId") Integer articleCommentId);
    //根据文章id查评论
    List<ArticleCommentBean> findByArticleId(@Param("articleId") Integer articleId);
    //查询全部
    List<ArticleCommentBean> findAll();
}
