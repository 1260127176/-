package com.ruoyu.service;

import com.github.pagehelper.PageInfo;
import com.ruoyu.bean.ArticleBean;
import com.ruoyu.bean.ArticleTypeBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

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
public interface ArticleTypeService {

    //添加
    Integer addArticleType(ArticleTypeBean articleTypeBean);
    //删除
    Integer delArticleType(@Param("articletypeid") Integer articletypeid);
    //修改
    Integer updArticleType(ArticleTypeBean articleTypeBean);
    //查询一个
    ArticleTypeBean findByTypeId(@Param("articletypeid") Integer articletypeid);
    //查询全部
    List<ArticleTypeBean> findAll(Integer pageNum);
    List<ArticleTypeBean> findAll();
    //按照文章类型id查询
    List<ArticleBean> findArticleByTypeId(Integer articleTypeId,Integer page);
}
