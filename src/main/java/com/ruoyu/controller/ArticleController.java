package com.ruoyu.controller;

import com.github.pagehelper.PageInfo;
import com.ruoyu.bean.*;
import com.ruoyu.service.*;
import com.ruoyu.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * Project_Name:springcloud-sonsul-demo
 * ClassName:ArticleCommentController
 * Package:com.ruoyu.controller
 *
 * @Date:2020/2/11 20:22
 * Author:1260127176@qq.com
 * author:12601
 */
@Controller
@RequestMapping("article")
public class ArticleController{
    @Autowired
    ArticleService articleService;

    @Autowired
    ArticleServiceImpl articleServiceImpl;

    @Autowired
    ArticleTypeService articleTypeService;

    @Autowired
    XbloUserService xbloUserService;

    @Autowired
    ArticleCommentService articleCommentService;

    @Autowired
    XbloLinkService xbloLinkService;

    @Autowired
    HttpServletRequest request;

//添加
    @RequestMapping("insert")
    public String addArticle(ArticleBean articleBean,String pageNum){
        if (pageNum==null || pageNum.equals("")) {
            pageNum="1";
        }
        int page = Integer.parseInt(pageNum);
        articleBean.setVisitCount(0);
        articleBean.setCreateDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        Integer integer = articleService.addArticle(articleBean);
        return "forward:/article/pageInto";
    }
//刪除
    @RequestMapping("delete")
    public String delArticle(Integer articleId){
        Integer integer = articleService.delArticle(articleId);
        List<ArticleMessage> typeAndArticle = articleService.findTypeNameById();
//        List<ArticleBean> articleBeanList = articleService.findAll();
        request.getSession().setAttribute("typeAndArticle",typeAndArticle);
        return "admin/article/mgrArticle";
    }
//修改
    @RequestMapping("update")
    public String updateArticle(ArticleBean articleBean){
        Integer integer = articleService.updArticle(articleBean);
        if (integer>0){
            List<ArticleMessage> typeAndArticle = articleService.findTypeNameById();
            List<ArticleBean> articleBeanList = articleService.findAll();
            request.getSession().setAttribute("articleBeanList",articleBeanList);
            request.getSession().setAttribute("typeAndArticle",typeAndArticle);
            return "admin/article/mgrArticle";
        }else {
            request.getSession().setAttribute("articleBean",articleBean);
            return "admin/article/updArticle";
        }
    }

//通过关键字查询，将查询结果，文章数量，分类数返回页面显示
    @RequestMapping("select")
    public String findArticleByTitle( String keyword) {
        keyword="%"+keyword+"%";
        List<ArticleBean> articleBeanList = articleService.findByTitle(keyword);
        List<ArticleTypeBean> typeBeanList = articleTypeService.findAll();
        request.setAttribute("articleBeanList",articleBeanList);
        request.setAttribute("typeBeanList",typeBeanList);
        return "admin/siteInfo";
    }

//按文章id查询文章
    @RequestMapping("findById/{operating}")
    public String findById(@PathVariable("operating")String operating, String articleId){
        System.out.println("-------------articleId:"+articleId);
        int articleId1 = Integer.parseInt(articleId);
        ArticleBean articleBean = articleService.findByArticleId(articleId1);
        List<ArticleBean> top10 = articleService.findArticleTop10();
        List<ArticleBean> articleBeanList = articleService.findAll();
        List<ArticleTypeBean> typeBeanList = articleTypeService.findAll();
        XbloUserBean userBean = xbloUserService.findByAuthor(articleBean.getCreateUserId());
        List<ArticleCommentBean> commentBeanList = articleCommentService.findByArticleId(articleBean.getArticleId());
        List<XbloLinkBean> linkBeanList = xbloLinkService.findAll();

        request.getSession().setAttribute("articleBean",articleBean);
        request.getSession().setAttribute("userBean",userBean);
        request.getSession().setAttribute("top10",top10);
        request.getSession().setAttribute("commentBeanList",commentBeanList);
        request.getSession().setAttribute("typeBeanList",typeBeanList);
        request.getSession().setAttribute("articleBeanList",articleBeanList);
        request.getSession().setAttribute("linkBeanList",linkBeanList);
        if (operating.equals("find")) {
            articleBean.setVisitCount(articleBean.getVisitCount()+1);
            articleService.updArticle(articleBean);
            return "front/article/viewArticle";
        } else if (operating.equals("upd")){
            return "admin/article/updArticle";
        }else {
            return "front/article/viewArticle";
        }
    }
    @RequestMapping("selectAll")
    public String selectAll(String pageNum,String src){
        if (pageNum==null || pageNum.equals("")) {
            pageNum="1";
        }
        int page = Integer.parseInt(pageNum);
        List<ArticleBean> articleBeanList = articleService.findAll(page);
        PageInfo<ArticleBean> pageInfo = new PageInfo<>(articleBeanList);
        HashSet<ArticleTypeBean> set = new HashSet<>();
        for (ArticleBean articleBean : pageInfo.getList()) {
            ArticleTypeBean typeBean = articleTypeService.findByTypeId(articleBean.getArticleTypeId());
            set.add(typeBean);
        }
        List<ArticleTypeBean> typeBeanList = articleTypeService.findAll();
        request.getSession().setAttribute("articleBeanList",articleBeanList);
        request.getSession().setAttribute("typeBeanList",typeBeanList);
        return src;
    }
    @RequestMapping("pageInto")
    public String toArticle( String pageNum){
        if (pageNum==null || pageNum.equals("")) {
            pageNum="1";
        }
        int page = Integer.parseInt(pageNum);
        List<ArticleMessage> articleMessaege = articleService.findArticleMessaege(page);
        PageInfo<ArticleMessage> pageInfo = new PageInfo<>(articleMessaege);
        request.getSession().setAttribute("articleMessaege",articleMessaege);
        request.getSession().setAttribute("pageInfo",pageInfo);
        return "admin/article/mgrArticle";
    }


}
