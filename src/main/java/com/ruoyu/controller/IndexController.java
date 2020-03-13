package com.ruoyu.controller;

import com.github.pagehelper.PageInfo;
import com.ruoyu.bean.*;
import com.ruoyu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Project_Name:springcloud-sonsul-demo
 * ClassName:IndexController
 * Package:com.ruoyu.controller
 *
 * @Date:2020/2/16 1:33
 * Author:1260127176@qq.com
 * author:12601
 */
@Controller
public class IndexController {
    @Autowired
    ArticleTypeService articleTypeService;
    
    @Autowired
    ArticleService articleService;
    
    @Autowired
    ArticleCommentService articleCommentService;
    
    @Autowired
    XbloUserService xbloUserService;
    
    @Autowired
    XbloLinkService xbloLinkService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    @RequestMapping("ruoyu")
    public String toIndex(String pageNum){
        System.out.println("pageNum:"+pageNum+"-------------");
        if (pageNum==null || pageNum.equals("")) {
            pageNum="1";
        }
        int page = Integer.parseInt(pageNum);
        List<ArticleBean> articleBeanList = articleService.findAll();
        List<ArticleMessage> articleMessaege = articleService.findArticleMessaege(page);
        PageInfo<ArticleMessage> pageInfo = new PageInfo<>(articleMessaege);
        List<ArticleBean> top10 = articleService.findArticleTop10();
        List<ArticleTypeBean> typeBeanList = articleTypeService.findAll(page);
        List<XbloLinkBean> linkBeanList = xbloLinkService.findAll();
        request.getSession().setAttribute("articleBeanList",articleBeanList);
        request.getSession().setAttribute("pageInfo",pageInfo);
        request.getSession().setAttribute("typeBeanList",typeBeanList);
        request.getSession().setAttribute("linkBeanList",linkBeanList);
        request.getSession().setAttribute("top10",top10);
        System.out.println("END---");
        return "front/FrontIndex";
    }
    @RequestMapping("pageInfo")
    public String toPage(String src, String pageNum){
        request.setAttribute("src",src);
        if (pageNum==null || pageNum.equals("")) {
            pageNum="1";
        }
        int page = Integer.parseInt(pageNum);
        if (src==null || src.equals("")){
            src="admin/siteInfo";
        }
        if (src.equals("admin/siteInfo")){
            PageInfo<ArticleBean> articleBeanList = articleService.findAll(page);
            List<ArticleTypeBean> typeBeanList = articleTypeService.findAll();
            request.getSession().setAttribute("articleBeanList",articleBeanList);
            request.getSession().setAttribute("typeBeanList",typeBeanList);
        }else if (src.equals("admin/article/addArticle")){
            List<ArticleTypeBean> typeBeanList = articleTypeService.findAll();
            request.getSession().setAttribute("typeBeanList",typeBeanList);

        }else if (src.equals("admin/article/mgrArticle")){
//            PageInfo<ArticleBean> page = articleService.findAll(pageNum);
//            List<Map<String, Object>> typeAndArticle = articleService.findTypeNameById();
            List<ArticleMessage> articleMessaege = articleService.findArticleMessaege(page);
            PageInfo<ArticleMessage> pageInfo = new PageInfo<>(articleMessaege);
            request.getSession().setAttribute("articleMessaege",articleMessaege);
            request.getSession().setAttribute("pageInfo",pageInfo);


        }else if (src.equals("admin/articleType/mgrArticleType")){
            List<ArticleTypeBean> typeBeanList = articleTypeService.findAll(page);
            PageInfo<ArticleTypeBean> pageInfo = new PageInfo<>(typeBeanList);
            request.getSession().setAttribute("typeBeanList",pageInfo);

        }else if (src.equals("admin/xbloLink/mgrXbloLink")){
            List<XbloLinkBean> linkBeanList = xbloLinkService.findAll(page);
            PageInfo<XbloLinkBean> pageInfo = new PageInfo<>(linkBeanList);
            request.getSession().setAttribute("linkBeanList",pageInfo);

        }else if (src.equals("admin/xbloUser/mgrXbloUser")){
            List<XbloUserBean> userBeanList = xbloUserService.findAll(page);
            PageInfo<XbloUserBean> pageInfo = new PageInfo<>(userBeanList);
            request.getSession().setAttribute("userBeanList",pageInfo);

        }
        return "admin/admin";
    }

//    /**
//     * 注册页面点击发送验证码，传送邮箱到后端，发送验证码到邮箱
//     */
//    @RequestMapping("/sendcode")
//    @ResponseBody
//    public String sendCode(String email, HttpServletRequest request){
//
//        String code = CodeUtils.getCode();
//        HttpSession session = request.getSession();
//        session.setAttribute("code",code);
//        session.setAttribute("email",email);
////        String msg = userService.sendCode(code,email);
//
////        return msg;
//        return null;
//    }

//    /**
//     * 异步校验 注册验证码与邮箱验证码是否一致
//     */
//    @RequestMapping("/checkoutcode")
//    @ResponseBody
//    public String checkoutCode(String code,HttpServletRequest request){
//        HttpSession session = request.getSession();
//        String sessioncode = (String) session.getAttribute("code");
//        if(code.equals(sessioncode)){
//            return "1";
//        }
//
//        return "0";
//    }

}