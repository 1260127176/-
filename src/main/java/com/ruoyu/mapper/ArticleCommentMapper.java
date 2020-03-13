package com.ruoyu.mapper;

import com.ruoyu.bean.ArticleCommentBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

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
@Component
@Mapper
public interface ArticleCommentMapper {
    //添加
    @Insert("INSERT INTO articlecomment(articleid,articlecommentdate,articlecommentuser,articlecommentemail,articlecommentcontent) " +
            "VALUES (#{articleId},#{articleCommentDate},#{articleCommentUser},#{articleCommentEmail},#{articleCommentContent})")
    Integer addArticleComment(@RequestBody ArticleCommentBean articleCommentBean);
    //删除
    @Delete("delete from articlecomment where articlecommentid=#{articleCommentId}")
    Integer delArticleComment(@Param("articleCommentId") Integer articleCommentId);
    //修改
    @Update("update article set articleTypeId=#{articleTypeId},articleTitle=#{articleTitle},articleSummary=#{articleSummary}," +
            "articleContent=#{articleContent},createDate=#{createDate},visitCount=#{visitCount},createUserId=#{createUserId})")
    Integer updArticleComment(@RequestBody ArticleCommentBean articleCommentBean);
    //查询一个
    @Select("SELECT * FROM articlecomment WHERE articleCommentId = #{articleCommentId}")
    ArticleCommentBean findByCommentId(@Param("articleCommentId") Integer articleCommentId);
    //根据文章id查评论
    @Select("SELECT * FROM articlecomment WHERE articleId = #{articleId} order by articleCommentDate desc")
    List<ArticleCommentBean> findByArticleId(@Param("articleId") Integer articleId);
    //查询全部
    @Select("select * from articlecomment order by articleCommentDate desc")
    List<ArticleCommentBean> findAll();

}
