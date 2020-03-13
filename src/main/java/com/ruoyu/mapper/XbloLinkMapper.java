package com.ruoyu.mapper;

import com.ruoyu.bean.ArticleBean;
import com.ruoyu.bean.XbloLinkBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Project_Name:springcloud-sonsul-demo
 * ClassName:XbloLinkMapper
 * Package:com.ruoyu.mapper
 *
 * @Date:2020/2/11 16:12
 * Author:1260127176@qq.com
 * author:12601
 */
@Component
@Mapper
public interface XbloLinkMapper {
    //添加
    @Insert("INSERT INTO XbloLink(xbloLinkName,xbloLinkUrl) VALUES (#{xbloLinkName},#{xbloLinkUrl})")
    Integer addArticleLink(XbloLinkBean xbloLinkBean);
    //删除
    @Delete("delete from XbloLink where xbloLinkId =#{XbloLinkId}")
    Integer delArticleLink(@Param("XbloLinkId") Integer XbloLinkId);
    //修改
    @Update("update XbloLink set xbloLinkName = #{xbloLinkName},  xbloLinkUrl =#{xbloLinkUrl} where xbloLinkId =#{xbloLinkId} ")
    Integer updArticleLink(XbloLinkBean xbloLinkBean);
    //查询一个
    @Select("SELECT xbloLinkId,xbloLinkName,xbloLinkUrl FROM XBloLink where xbloLinkId=#{XbloLinkId}")
    XbloLinkBean findById(@Param("XbloLinkId") Integer XbloLinkId);
    //查询全部
    @Select("SELECT * FROM XbloLink")
    List<XbloLinkBean> findAll();
}
