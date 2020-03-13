package com.ruoyu.controller;

import com.github.pagehelper.PageInfo;
import com.ruoyu.bean.ArticleBean;
import com.ruoyu.bean.ArticleTypeBean;
import com.ruoyu.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("type")
public class ArticleTypeController {
    @Autowired
    ArticleTypeService articleTypeService;

    @Autowired
    HttpServletRequest request;

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
    @RequestMapping("selectByTypeId")
    String findAllByTypeId(Integer articleTypeId){
        List<ArticleBean> articleBeanList = articleTypeService.findArticleByTypeId(articleTypeId);
        request.setAttribute("articleBeanList",articleBeanList);
        return "forward:/";
    }
}
