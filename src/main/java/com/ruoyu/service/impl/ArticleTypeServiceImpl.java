package com.ruoyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyu.bean.ArticleBean;
import com.ruoyu.bean.ArticleMessage;
import com.ruoyu.bean.ArticleTypeBean;
import com.ruoyu.mapper.ArticleTypeMapper;
import com.ruoyu.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Project_Name:springcloud-sonsul-demo
 * ClassName:ArticleTypeServiceImpl
 * Package:com.ruoyu.service.impl
 *
 * @Date:2020/2/16 19:50
 * Author:1260127176@qq.com
 * author:12601
 */
@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {
    @Autowired
    ArticleTypeMapper articleTypeMapper;

    @Override
    public Integer addArticleType(ArticleTypeBean articleTypeBean) {
        Integer integer = articleTypeMapper.addArticleType(articleTypeBean);
        return integer;
    }

    @Override
    public Integer delArticleType(Integer articletypeid) {
        Integer integer = articleTypeMapper.delArticleType(articletypeid);
        return integer;
    }

    @Override
    public Integer updArticleType(ArticleTypeBean articleTypeBean) {
        Integer integer = articleTypeMapper.updArticleType(articleTypeBean);
        return integer;
    }

    @Override
    public ArticleTypeBean findByTypeId(Integer articletypeid) {
        ArticleTypeBean typeBean = articleTypeMapper.findByTypeId(articletypeid);
        return typeBean;
    }

    @Override
    public List<ArticleTypeBean> findAll(Integer pageNum) {
        PageHelper.startPage(pageNum,5);
        List<ArticleTypeBean> typeBeanList = articleTypeMapper.findAll();
        return typeBeanList;
    }

    @Override
    public List<ArticleTypeBean> findAll() {
        List<ArticleTypeBean> typeBeanList = articleTypeMapper.findAll();
        return typeBeanList;
    }

    @Override
    public List<ArticleBean> findArticleByTypeId(Integer articleTypeId) {
        List<ArticleBean> articleBeanList = articleTypeMapper.findArticleByTypeId(articleTypeId);
        return articleBeanList;
    }

}
