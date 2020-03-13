package com.ruoyu.mapper;

import com.ruoyu.bean.ArticleBean;
import com.ruoyu.bean.ArticleTypeBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Project_Name:springcloud-sonsul-demo
 * ClassName:ArticleTypeMapper
 * Package:com.ruoyu.mapper
 *
 * @Date:2020/2/11 16:12
 * Author:1260127176@qq.com
 * author:12601
 */
@Component
@Mapper
public interface ArticleTypeMapper {

    //添加
    @Insert("INSERT INTO ArticleType(articletypename, articletypedesc) VALUES (#{articleTypeName},#{articleTypeDesc})")
    Integer addArticleType(ArticleTypeBean articleTypeBean);
    //删除
    @Delete("delete from ArticleType where articletypeid =#{articletypeid}")
    Integer delArticleType(@Param("articletypeid") Integer articletypeid);
    //修改
    @Update("update ArticleType set articletypename = #{articleTypeName},articletypedesc = #{articleTypeDesc}  where articleTypeId =#{articleTypeId}")
    Integer updArticleType(ArticleTypeBean articleTypeBean);
    //查询一个
    @Select("select * FROM ArticleType where articletypeid=#{articletypeid}")
    ArticleTypeBean findByTypeId(@Param("articletypeid") Integer articletypeid);
    //查询全部
    @Select("select * from articleType order by articleTypeId desc")
    List<ArticleTypeBean> findAll();
    //按照文章类型id查询
    @Select("SELECT * FROM article WHERE articleTypeId = #{articleTypeId} ORDER BY createDate DESC")
    List<ArticleBean> findArticleByTypeId(Integer articleTypeId);
}
