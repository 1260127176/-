package com.ruoyu.service;

import com.ruoyu.bean.XbloLinkBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

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
public interface XbloLinkService {
    //添加
    Integer addArticleLink(XbloLinkBean xbloLinkBean);
    //删除
    Integer delArticleLink(@Param("XbloLinkId") Integer XbloLinkId);
    //修改
    Integer updArticleLink(XbloLinkBean xbloLinkBean);
    //查询一个
    XbloLinkBean findById(@Param("XbloLinkId") Integer XbloLinkId);
    //查询全部
    List<XbloLinkBean> findAll(Integer pageNum);
    List<XbloLinkBean> findAll();
}
