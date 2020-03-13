package com.ruoyu.service;

import com.github.pagehelper.PageInfo;
import com.ruoyu.bean.ArticleBean;
import com.ruoyu.bean.ArticleMessage;
import org.apache.ibatis.annotations.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

/**
 * Project_Name:springcloud-sonsul-demo
 * ClassName:ArticleService
 * Package:com.ruoyu.service
 *
 * @Date:2020/2/15 23:47
 * Author:1260127176@qq.com
 * author:12601
 */
public interface ArticleService {
    //添加
    Integer addArticle(ArticleBean articleBean);
    //删除
    Integer delArticle(@Param("articleId") Integer articleId);
    //修改
    Integer updArticle(ArticleBean articleBean);
    //按照id查询一个
    ArticleBean findByArticleId(@Param("articleId") Integer articleId);
    //按条件相似查询
    List<ArticleBean> findByTitle(@Param("keyword") String keyword);
    //查询全部
    List<ArticleBean> findAll();
    PageInfo<ArticleBean> findAll(Integer page);
    //查询阅读前十，倒序排列
    List<ArticleBean> findArticleTop10();
    List<ArticleMessage> findTypeNameById();
    List<ArticleMessage> findArticleMessaege(Integer pageNum);
//    Integer getArticleNum(String typeId);
}
