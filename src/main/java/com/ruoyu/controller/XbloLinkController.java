package com.ruoyu.controller;

import com.github.pagehelper.PageInfo;
import com.ruoyu.bean.XbloLinkBean;
import com.ruoyu.service.XbloLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("link")
public class XbloLinkController{
    @Autowired
    XbloLinkService xbloLinkService;

    @Autowired
    HttpServletRequest request;

    @RequestMapping("insert")
    public String addArticleLink(XbloLinkBean xbloLinkBean) {
        xbloLinkService.addArticleLink(xbloLinkBean);
//        List<XbloLinkBean> linkBeanList = xbloLinkService.findAll();
//        request.getSession().setAttribute("linkBeanList",linkBeanList);
        return "forward:/link/selectAll";
    }

    @RequestMapping("delete")
    public String delArticleLink(Integer xbloLinkId) {
        xbloLinkService.delArticleLink(xbloLinkId);
        List<XbloLinkBean> linkBeanList = xbloLinkService.findAll();
        request.getSession().setAttribute("linkBeanList",linkBeanList);
        return "forward:/link/selectAll";
    }

    @RequestMapping("update")
    public String updateArticleLink(XbloLinkBean xbloLinkBean) {
        xbloLinkService.updArticleLink(xbloLinkBean);
        List<XbloLinkBean> linkBeanList = xbloLinkService.findAll();
        request.getSession().setAttribute("linkBeanList",linkBeanList);
        return "forward:/link/selectAll";
    }

    @RequestMapping("select")
    public String findOneArticleLink( Integer xbloLinkId) {
        XbloLinkBean linkBean = xbloLinkService.findById(xbloLinkId);
        request.getSession().setAttribute("linkBean",linkBean);
        return "admin/xbloLink/updXbloLink";
    }

    @RequestMapping("selectAll")
    public String findAllArticleLink(String pageNum) {
        if (pageNum==null || pageNum.equals("")) {
            pageNum="1";
        }
        int page = Integer.parseInt(pageNum);
        List<XbloLinkBean> allArticleLink = xbloLinkService.findAll(page);
        PageInfo<XbloLinkBean> pageInfo = new PageInfo<>(allArticleLink);
        request.getSession().setAttribute("linkBeanList",pageInfo);
        return "admin/xbloLink/mgrXbloLink";
    }
}
