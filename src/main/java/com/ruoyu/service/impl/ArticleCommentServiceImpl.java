package com.ruoyu.service.impl;

import com.ruoyu.bean.ArticleCommentBean;
import com.ruoyu.mapper.ArticleCommentMapper;
import com.ruoyu.service.ArticleCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ArticleCommentServiceImpl implements ArticleCommentService {
    @Autowired
    private ArticleCommentMapper articleCommentMapper;


    @Override
    public Integer addArticleComment(ArticleCommentBean articleCommentBean) {
        Integer integer = articleCommentMapper.addArticleComment(articleCommentBean);
        return integer;
    }

    @Override
    public Integer delArticleComment(Integer articleCommentId) {
        Integer integer = articleCommentMapper.delArticleComment(articleCommentId);
        return integer;
    }

    @Override
    public Integer updArticleComment(ArticleCommentBean articleCommentBean) {
        Integer integer = articleCommentMapper.updArticleComment(articleCommentBean);
        return integer;
    }

    @Override
    public ArticleCommentBean findByCommentId(Integer articleCommentId) {
        ArticleCommentBean commentBean = articleCommentMapper.findByCommentId(articleCommentId);
        commentBean.setArticleCommentContent(commentBean.getArticleCommentContent().replaceAll("\\s*", ""));
        return commentBean;
    }

    @Override
    public List<ArticleCommentBean> findByArticleId(Integer articleId) {
        List<ArticleCommentBean> commentBeanList = articleCommentMapper.findByArticleId(articleId);
        for (ArticleCommentBean commentBean : commentBeanList) {
            commentBean.setArticleCommentContent(commentBean.getArticleCommentContent().replaceAll("\\s*", ""));
        }
        return commentBeanList;

    }

    @Override
    public List<ArticleCommentBean> findAll() {
        List<ArticleCommentBean> commentBeanList = articleCommentMapper.findAll();
        for (ArticleCommentBean commentBean : commentBeanList) {
            commentBean.setArticleCommentContent(commentBean.getArticleCommentContent().replaceAll("\\s*", ""));
        }
        return commentBeanList;
    }


}
