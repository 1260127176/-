package com.ruoyu.controller;

import com.github.pagehelper.PageInfo;
import com.ruoyu.bean.*;
import com.ruoyu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("type")
public class ArticleTypeController {
    @Autowired
    ArticleTypeService articleTypeService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    ArticleService articleService;

    @Autowired
    XbloLinkService xbloLinkService;
    @Autowired
    ArticleCommentService articleCommentService;

    @Autowired
    XbloUserService xbloUserService;

    @RequestMapping("insert")
    public String addArticleType(ArticleTypeBean articleTypeBean) {
        articleTypeService.addArticleType(articleTypeBean);
        return "forward:/type/selectAll";
    }

    @RequestMapping("delete")
    public String delArticleType(String articletypeid) {
        System.out.println("删除类型操作的类型id："+articletypeid);
        int articleTypeId = Integer.parseInt(articletypeid);
        articleTypeService.delArticleType(articleTypeId);
        return "forward:/type/selectAll";
    }

    @RequestMapping("update")
    public String updateArticleType(ArticleTypeBean articleTypeBean) {
        articleTypeService.updArticleType(articleTypeBean);
        return "forward:/type/selectAll";
    }

//    ????
    @RequestMapping("select")
    public String findOneArticleType(String articletypeid) {
        int articleTypeId = Integer.parseInt(articletypeid);
        System.out.println("获取到的类型ID："+articletypeid);
        ArticleTypeBean typeBean = articleTypeService.findByTypeId(articleTypeId);
        request.getSession().setAttribute("typeBean",typeBean);
        return "admin/articleType/updArticleType";
    }

    @RequestMapping("selectAll")
    public String findAllArticleType(String pageNum) {
        if (pageNum==null || pageNum.equals("")) {
            pageNum="1";
        }
        int page = Integer.parseInt(pageNum);
        List<ArticleTypeBean> typeBeanList = articleTypeService.findAll(page);
        PageInfo<ArticleTypeBean> pageInfo = new PageInfo<>(typeBeanList);
        request.getSession().setAttribute("typeBeanList",pageInfo);
        return "admin/articleType/mgrArticleType";
    }
    @RequestMapping("/selectByTypeId")
    public String findArticleForType(Integer articleTypeId,
                                     @RequestParam(value = "pageNum",required = false,defaultValue = "1") String pageNum
    ){
        int page=Integer.parseInt(pageNum);
        List<ArticleBean> articleBeanList = articleTypeService.findArticleByTypeId(articleTypeId,page);
        PageInfo<ArticleBean> pageInfo = new PageInfo<ArticleBean>(articleBeanList);
        List<ArticleBean> articleBeanList1 = articleService.findAll();
        List<ArticleBean> top10 = articleService.findArticleTop10();
        List<ArticleTypeBean> typeBeanList = articleTypeService.findAll();
        List<XbloLinkBean> linkBeanList = xbloLinkService.findAll();
        List<ArticleCommentBean> commentBeanList = articleCommentService.findAll();
        List<XbloUserBean> userBeanList = xbloUserService.findAll();
        request.getSession().setAttribute("articleBeanList",articleBeanList1);
        request.getSession().setAttribute("commentBeanList",commentBeanList);
        request.getSession().setAttribute("typeBeanList",typeBeanList);
        request.getSession().setAttribute("linkBeanList",linkBeanList);
        request.getSession().setAttribute("top10",top10);
        request.getSession().setAttribute("userBeanList",userBeanList);
        request.getSession().setAttribute("pageInfo", pageInfo);
        request.getSession().setAttribute("requestUrl", "type/selectByTypeId");
        request.getSession().setAttribute("articleTypeId", articleTypeId);
        return "front/FrontIndex";
    }
}
