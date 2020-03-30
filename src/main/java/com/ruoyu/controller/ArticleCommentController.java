package com.ruoyu.controller;

import com.ruoyu.bean.*;
import com.ruoyu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Project_Name:springcloud-sonsul-demo
 * ClassName:ArticleController
 * Package:com.ruoyu.controller
 *
 * @Date:2020/2/11 20:22
 * Author:1260127176@qq.com
 * author:12601
 */
@Controller
@RequestMapping("comment")
public class ArticleCommentController {
    @Autowired
    ArticleCommentService articleCommentService;

    @Autowired
    ArticleService articleService;

    @Autowired
    ArticleTypeService articleTypeService;

    @Autowired
    XbloUserService xbloUserService;

    @Autowired
    XbloLinkService xbloLinkService;

    @Autowired
    HttpServletRequest request;

    @RequestMapping(value = "insert")
    public String addArticleComment( String articleCommentUser, String articleCommentEmail,
                                     String articleCommentContent, String articleId,String pageNum) {
        if (pageNum==null || pageNum.equals("")) {
            pageNum="1";
        }
        int page = Integer.parseInt(pageNum);
        ArticleCommentBean articleCommentBean=new ArticleCommentBean();
        articleCommentBean.setArticleCommentDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        articleCommentBean.setArticleCommentContent(articleCommentContent);
        articleCommentBean.setArticleCommentEmail(articleCommentEmail);
        articleCommentBean.setArticleCommentUser(articleCommentUser);
        articleCommentBean.setArticleId(Integer.parseInt(articleId));
        articleCommentService.addArticleComment(articleCommentBean);
        List<ArticleCommentBean> commentBeanList = articleCommentService.findByArticleId(Integer.parseInt(articleId));
        ArticleBean articleBean = articleService.findByArticleId(Integer.parseInt(articleId));
        XbloUserBean userBean = xbloUserService.findByAuthor(articleBean.getCreateUserId());
        List<ArticleTypeBean> typeBeanList = articleTypeService.findAll(page);
        List<ArticleBean> top10 = articleService.findArticleTop10();
        List<ArticleBean> articleBeanList = articleService.findAll();
        List<XbloLinkBean> linkBeanList = xbloLinkService.findAll();
        request.getSession().setAttribute("articleBeanList",articleBeanList);
        request.getSession().setAttribute("commentBeanList",commentBeanList);
        request.getSession().setAttribute("linkBeanList",linkBeanList);
        request.getSession().setAttribute("typeBeanList",typeBeanList);
        request.getSession().setAttribute("articleBean",articleBean);
        request.getSession().setAttribute("userBean",userBean);
        request.getSession().setAttribute("top10",top10);
        try {
            articleCommentBean.setArticleCommentDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            Integer integer = articleCommentService.addArticleComment(articleCommentBean);
        }catch ( Exception e){
            System.out.println(e.getMessage());
        }
            return "front/article/viewArticle";

    }

    @RequestMapping("delete")
    public Integer delArticleComment(Integer articleCommentId) {
        Integer integer = articleCommentService.delArticleComment(articleCommentId);
        return null;
    }

    @RequestMapping("update")
    public Integer updateArticleComment(ArticleCommentBean articleCommentBean) {
        Integer integer = articleCommentService.updArticleComment(articleCommentBean);
        return null;
    }

    @RequestMapping("selectOne")
    public ArticleCommentBean findOneArticleComment(Integer articleCommentId) {
        ArticleCommentBean commentBean = articleCommentService.findByCommentId(articleCommentId);
        request.setAttribute("commentBean",commentBean);
        return null;
    }

    @RequestMapping("select")
    public String findCommentByArticleId(Integer articleId,String pageNum) {
        if (pageNum==null || pageNum.equals("")) {
            pageNum="1";
        }
        int page = Integer.parseInt(pageNum);
        List<ArticleCommentBean> commentBeanList = articleCommentService.findByArticleId(articleId);
        ArticleBean articleBean = articleService.findByArticleId(articleId);
        List<ArticleBean> top10 = articleService.findArticleTop10();
        List<ArticleTypeBean> typeBeanList = articleTypeService.findAll(page);
        //设置成用文章id查询评论时进入初始阅读页面，将文章，排行，类别，链接信息传递过去
        request.setAttribute("commentBeanList",commentBeanList);
        request.setAttribute("articleBean",articleBean);
        request.setAttribute("top10",top10);
        request.setAttribute("typeBeanList",typeBeanList);
        return "front/article/viewArticle";
    }

    @RequestMapping("selectAll")
    public String findAllArticleComment() {
        List<ArticleCommentBean> allArticleComment = articleCommentService.findAll();
//        List<ArticleBean> articleBeanList = articleService.findAll();
//        request.setAttribute("allArticleComment",allArticleComment);
//        request.setAttribute("articleBeanList",articleBeanList);
        return null;
    }

}
