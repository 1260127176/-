package com.ruoyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyu.bean.ArticleBean;
import com.ruoyu.bean.ArticleMessage;
import com.ruoyu.mapper.ArticleMapper;
import com.ruoyu.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

/**
 * Project_Name:springcloud-sonsul-demo
 * ClassName:ArticleImpl
 * Package:com.ruoyu.service.impl
 *
 * @Date:2020/2/15 23:48
 * Author:1260127176@qq.com
 * author:12601
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Integer addArticle(ArticleBean articleBean) {
        Integer integer = articleMapper.addArticle(articleBean);
        return integer;
    }

    @Override
    public Integer delArticle(Integer articleId) {
        Integer integer = articleMapper.delArticle(articleId);
        return integer;
    }

    @Override
    public Integer updArticle(ArticleBean articleBean) {
        Integer integer = articleMapper.updArticle(articleBean);
        return integer;
    }

    @Override
    public ArticleBean findByArticleId(Integer articleId) {
        ArticleBean articleBean = articleMapper.findByArticleId(articleId);
        articleBean.setArticleContent(articleBean.getArticleContent().replaceAll("\\s*", ""));
        return articleBean;
    }

    @Override
    public List<ArticleBean> findByTitle(String keyword) {
        List<ArticleBean> articleBeanList = articleMapper.findByTitle(keyword);
        for (ArticleBean articleBean : articleBeanList) {
            articleBean.setArticleContent(articleBean.getArticleContent().replaceAll("\\s*", ""));
        }
        return articleBeanList;
    }

    @Override
    public List<ArticleBean> findAll() {
        List<ArticleBean> articleBeanList = articleMapper.findAll();
        for (ArticleBean articleBean : articleBeanList) {
            articleBean.setArticleContent(articleBean.getArticleContent().replaceAll("\\s*", ""));
        }
        return articleBeanList;
    }

    @Override
    public List<ArticleBean> findAll(Integer page) {
        PageHelper.startPage(page,6);
        List<ArticleBean> articleBeanList = articleMapper.findAll();
        for (ArticleBean articleBean : articleBeanList) {
            articleBean.setArticleContent(articleBean.getArticleContent().replaceAll("\\s*|\t", ""));
        }
        return articleBeanList;
    }

    @Override
    public List<ArticleBean> findArticleTop10() {
        List<ArticleBean> articleBeanList = articleMapper.findArticleTop10();
        for (ArticleBean articleBean : articleBeanList) {
            articleBean.setArticleContent(articleBean.getArticleContent().replaceAll("\\s*|\t", ""));
        }
        return articleBeanList;
    }

    @Override
    public List<ArticleMessage> findTypeNameById() {
        List<ArticleMessage> typeAndArticle = articleMapper.findArticleMessaege();
        for (ArticleMessage articleMessage : typeAndArticle) {
            articleMessage.setArticleContent(articleMessage.getArticleContent().replaceAll("\\s*", ""));
        }
        return typeAndArticle;
    }

    @Override
    public List<ArticleMessage> findArticleMessaege(Integer pageNum) {
        PageHelper.startPage(pageNum,5);
        List<ArticleMessage> typeAndArticle = articleMapper.findArticleMessaege();
        for (ArticleMessage articleMessage : typeAndArticle) {
            articleMessage.setArticleContent(articleMessage.getArticleContent().replaceAll("\\s*|\t", ""));
        }
        return typeAndArticle;
    }

//    @Override
//    public Integer getArticleNum(String typeId) {
//        Integer count = articleMapper.findArticleNum(typeId);
//        return count;
//    }


//    public ModelAndView findTypeAndArticle(String dir) {
//        ModelAndView mv = new ModelAndView(dir);
//        List<ArticleBean> all = articleMapper.findAll();
//        for (int i=0;i<=all.size();i++) {
//            Map<String, Object> article = articleMapper.findTypeNameById(i);
//            mv.addObject("article"+i,article);
//        }
//        return mv;
//    }
}
