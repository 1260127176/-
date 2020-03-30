package com.ruoyu.mapper;

import com.github.pagehelper.PageInfo;
import com.ruoyu.bean.ArticleBean;
import com.ruoyu.bean.ArticleCommentBean;
import com.ruoyu.bean.ArticleMessage;
import com.ruoyu.bean.XbloUserBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Project_Name:springcloud-sonsul-demo
 * ClassName:ArticleMapper
 * Package:com.ruoyu.mapper
 *
 * @Date:2020/2/11 15:48
 * Author:1260127176@qq.com
 * author:12601
 */
@Component
@Mapper
public interface ArticleMapper {
    //添加
    @Insert("insert into article(articleTypeId,articleTitle,articleSummary,articleContent,createDate,visitCount,createUserId)" +
            " value(#{articleTypeId},#{articleTitle},#{articleSummary},#{articleContent},#{createDate},#{visitCount},#{createUserId}) ")
    Integer addArticle(ArticleBean articleBean);
    //删除
    @Delete("delete from article where articleId=#{articleId}")
    Integer delArticle(@Param("articleId") Integer articleId);
    //修改
    @Update("update article set articleTypeId=#{articleTypeId},articleTitle=#{articleTitle},articleSummary=#{articleSummary}," +
            "articleContent=#{articleContent} where articleId=#{articleId}")
    Integer updArticle(ArticleBean articleBean);
    //按照id查询一个
    @Select("select * from article where articleId=#{articleId}")
    ArticleBean findByArticleId(@Param("articleId") Integer articleId);

    //根据articleId查询出的typeid 查询typename
    @Select("SELECT a.*,t.*,u.* FROM article AS a,articletype AS t,xblouser AS u WHERE " +
            "t.articleTypeId = a.articleTypeId AND a.createUserId=u.xbloUserId ")
    Map<String,Object> findTypeNameById();
    @Select("SELECT a.*,t.articleTypeName,u.xbloUsername FROM article AS a,articletype AS t,xblouser AS u WHERE " +
            "t.articleTypeId = a.articleTypeId AND a.createUserId=u.xbloUserId order by createDate DESC ")
    List<ArticleMessage> findArticleMessaege();
    //按条件相似查询
    @Select("SELECT  * FROM Article WHERE articleTitle LIKE #{keyword} OR " +
            "articleSummary LIKE #{keyword} OR articleContent LIKE #{keyword} order by createDate DESC ")
    List<ArticleBean> findByTitle(String keyword);
    //查询全部
    @Select("select * from article order by createDate DESC")
    List<ArticleBean> findAll();
//查询阅读前十，倒序排列
    @Select("SELECT  * FROM   article  ORDER BY visitCount DESC Limit 0,10")
    List<ArticleBean> findArticleTop10();
//    @Select("select COUNT(*) from article where articleTypeId=#{articleTypeId}")
//    Integer findArticleNum(String articleTypeId);
}
