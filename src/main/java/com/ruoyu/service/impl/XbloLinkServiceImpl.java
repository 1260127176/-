package com.ruoyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.ruoyu.bean.XbloLinkBean;
import com.ruoyu.mapper.XbloLinkMapper;
import com.ruoyu.service.XbloLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Project_Name:springcloud-sonsul-demo
 * ClassName:XbloLinkServiceImpl
 * Package:com.ruoyu.service.impl
 *
 * @Date:2020/2/16 19:51
 * Author:1260127176@qq.com
 * author:12601
 */
@Service
public class XbloLinkServiceImpl implements XbloLinkService
{
    @Autowired
    private XbloLinkMapper xbloLinkMapper;
    @Override
    public Integer addArticleLink(XbloLinkBean xbloLinkBean) {
        Integer integer = xbloLinkMapper.addArticleLink(xbloLinkBean);
        return integer;
    }

    @Override
    public Integer delArticleLink(Integer XbloLinkId) {
        Integer integer = xbloLinkMapper.delArticleLink(XbloLinkId);
        return integer;
    }

    @Override
    public Integer updArticleLink(XbloLinkBean xbloLinkBean) {
        Integer integer = xbloLinkMapper.updArticleLink(xbloLinkBean);
        return integer;
    }

    @Override
    public XbloLinkBean findById(Integer XbloLinkId) {
        XbloLinkBean linkBean = xbloLinkMapper.findById(XbloLinkId);
        return linkBean;
    }


    @Override
    public List<XbloLinkBean> findAll(Integer pageNum) {
        PageHelper.startPage(pageNum,5);
        List<XbloLinkBean> linkBeanList = xbloLinkMapper.findAll();
        return linkBeanList;
    }

    @Override
    public List<XbloLinkBean> findAll() {
        List<XbloLinkBean> linkBeanList = xbloLinkMapper.findAll();
        return linkBeanList;
    }

}
