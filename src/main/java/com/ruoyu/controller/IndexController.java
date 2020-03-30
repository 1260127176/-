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

    @RequestMapping("ruoyu")
    public String toIndex(@RequestParam(value = "pageNum",required = false,defaultValue = "1") String pageNum){
        int page = Integer.parseInt(pageNum);
        List<ArticleBean> articleBeanList1 = articleService.findAll();
        List<ArticleBean> articleBeanList = articleService.findAll(page);
        PageInfo<ArticleBean> pageInfo = new PageInfo<>(articleBeanList);
        request.getSession().setAttribute("pageInfo", pageInfo);
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
        request.getSession().setAttribute("requestUrl","/ruoyu");
        return "front/FrontIndex";
    }
    @RequestMapping("pageInfo")
    public String toPage(@RequestParam(value = "src",required = false,defaultValue = "admin/siteInfo")String src,
                         @RequestParam(value = "pageNum",required = false,defaultValue = "1") String pageNum
    ) {
        request.setAttribute("src", src);
        int page = Integer.parseInt(pageNum);
        switch (src) {
            case "admin/siteInfo": {
                List<ArticleBean> articleBeanList = articleService.findAll(page);
                PageInfo<ArticleBean> pageInfo = new PageInfo<>(articleBeanList);
                List<ArticleTypeBean> typeBeanList = articleTypeService.findAll();
                request.getSession().setAttribute("articleBeanList", pageInfo);
                request.getSession().setAttribute("typeBeanList", typeBeanList);
                break;
            }
            case "admin/article/addArticle": {
                List<ArticleTypeBean> typeBeanList = articleTypeService.findAll();
                request.getSession().setAttribute("typeBeanList", typeBeanList);
                break;
            }
            case "admin/article/mgrArticle": {
                List<ArticleMessage> articleMessaege = articleService.findArticleMessaege(page);
                PageInfo<ArticleMessage> pageInfo = new PageInfo<>(articleMessaege);
                request.getSession().setAttribute("articleMessaege", articleMessaege);
                request.getSession().setAttribute("pageInfo", pageInfo);
                break;
            }
            case "admin/articleType/mgrArticleType": {
                List<ArticleTypeBean> typeBeanList = articleTypeService.findAll(page);
                PageInfo<ArticleTypeBean> pageInfo = new PageInfo<>(typeBeanList);
                request.getSession().setAttribute("typeBeanList", pageInfo);
                break;
            }
            case "admin/xbloLink/mgrXbloLink": {
                List<XbloLinkBean> linkBeanList = xbloLinkService.findAll(page);
                PageInfo<XbloLinkBean> pageInfo = new PageInfo<>(linkBeanList);
                request.getSession().setAttribute("linkBeanList", pageInfo);
                break;
            }
            case "admin/xbloUser/mgrXbloUser": {
                List<XbloUserBean> userBeanList = xbloUserService.findAll(page);
                PageInfo<XbloUserBean> pageInfo = new PageInfo<>(userBeanList);
                request.getSession().setAttribute("userBeanList", pageInfo);
                break;
            }

            default:
                System.out.println("无对应匹配值");
        }
        return "admin/admin";
//        if (src.equals("admin/siteInfo")){
//            List<ArticleBean> articleBeanList = articleService.findAll(page);
//            PageInfo<ArticleBean> pageInfo = new PageInfo<>(articleBeanList);
//            List<ArticleTypeBean> typeBeanList = articleTypeService.findAll();
//            request.getSession().setAttribute("articleBeanList",pageInfo);
//            request.getSession().setAttribute("typeBeanList",typeBeanList);
//        }else if (src.equals("admin/article/addArticle")){
//            List<ArticleTypeBean> typeBeanList = articleTypeService.findAll();
//            request.getSession().setAttribute("typeBeanList",typeBeanList);
//
//        }else if (src.equals("admin/article/mgrArticle")){
////            PageInfo<ArticleBean> page = articleService.findAll(pageNum);
////            List<Map<String, Object>> typeAndArticle = articleService.findTypeNameById();
//            List<ArticleMessage> articleMessaege = articleService.findArticleMessaege(page);
//            PageInfo<ArticleMessage> pageInfo = new PageInfo<>(articleMessaege);
//            request.getSession().setAttribute("articleMessaege",articleMessaege);
//            request.getSession().setAttribute("pageInfo",pageInfo);
//        }else if (src.equals("admin/articleType/mgrArticleType")){
//            List<ArticleTypeBean> typeBeanList = articleTypeService.findAll(page);
//            PageInfo<ArticleTypeBean> pageInfo = new PageInfo<>(typeBeanList);
//            request.getSession().setAttribute("typeBeanList",pageInfo);
//
//        }else if (src.equals("admin/xbloLink/mgrXbloLink")){
//            List<XbloLinkBean> linkBeanList = xbloLinkService.findAll(page);
//            PageInfo<XbloLinkBean> pageInfo = new PageInfo<>(linkBeanList);
//            request.getSession().setAttribute("linkBeanList",pageInfo);
//
//        }else if (src.equals("admin/xbloUser/mgrXbloUser")){
//            List<XbloUserBean> userBeanList = xbloUserService.findAll(page);
//            PageInfo<XbloUserBean> pageInfo = new PageInfo<>(userBeanList);
//            request.getSession().setAttribute("userBeanList",pageInfo);
//
//        }
//        return "admin/admin";
//    }

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
}