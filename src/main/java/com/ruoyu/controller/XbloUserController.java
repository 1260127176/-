package com.ruoyu.controller;

import com.github.pagehelper.PageInfo;
import com.ruoyu.bean.ArticleBean;
import com.ruoyu.bean.ArticleTypeBean;
import com.ruoyu.bean.XbloUserBean;
import com.ruoyu.service.ArticleService;
import com.ruoyu.service.ArticleTypeService;
import com.ruoyu.service.XbloUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

@Controller
@RequestMapping("user")
public class XbloUserController{
    @Autowired
    ArticleService articleService;

    @Autowired
    ArticleTypeService articleTypeService;

    @Autowired
    XbloUserService xbloUserService;

    @RequestMapping("insert")
    @Transactional
    public String addUser(XbloUserBean xbloUserBean) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(xbloUserBean.getXbloPassword().getBytes());
        xbloUserBean.setXbloPassword(new BigInteger(1, md5.digest()).toString(16));
        xbloUserService.addUser(xbloUserBean);
        return "admin/xbloUser/mgrXbloUser";
    }

    @RequestMapping("delete")
    public String delUser(String xbloUserId) {
        int xBloUserId = Integer.parseInt(xbloUserId);
        xbloUserService.delUser(xBloUserId);
        return "forward:/user/selectAll";
    }

    @RequestMapping("update")
    public String updateUser(XbloUserBean xbloUserBean) {
        xbloUserService.updUser(xbloUserBean);
        return "forward:/user/selectAll";
    }

    @RequestMapping("select/{operating}")
    public String findOneUser(@PathVariable("operating") String operating,String xbloUserId,HttpServletRequest request) {
        int xBloUserId = Integer.parseInt(xbloUserId);
        if (operating.equals("find")){
            XbloUserBean userBean = xbloUserService.findById(xBloUserId);
            request.getSession().setAttribute("userBean",userBean);
            return "admin/xbloUser/updXbloUser";
        }else {
            return null;
        }

    }

    @RequestMapping("selectAll")
    public String findAllUser(HttpServletRequest request,String pageNum) {
        if (pageNum==null || pageNum.equals("")) {
            pageNum="1";
        }
        int page = Integer.parseInt(pageNum);
        List<XbloUserBean> userBeanList = xbloUserService.findAll(page);
        PageInfo<XbloUserBean> pageInfo = new PageInfo<>(userBeanList);
        List<ArticleBean> articleBeanList = articleService.findAll();
        List<ArticleTypeBean> typeBeanList = articleTypeService.findAll();
        request.getSession().setAttribute("articleBeanList",articleBeanList);
        request.getSession().setAttribute("typeBeanList",typeBeanList);
        request.getSession().setAttribute("userBeanList",pageInfo);
        return "admin/xbloUser/mgrXbloUser";
    }
    @RequestMapping("login")
    public String login(String xbloUsername,String xbloPassword,HttpServletRequest request,
                        @RequestParam(value = "pageNum",required = false,defaultValue = "1") String pageNum){
        int page = Integer.parseInt(pageNum);
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            md5.update(xbloPassword.getBytes());
            new BigInteger(1, md5.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        XbloUserBean userBean = xbloUserService.login(xbloUsername, xbloPassword);
        System.out.println("==================="+userBean);
        if (userBean != null && !userBean.equals("")){
            List<ArticleTypeBean> typeBeanList = articleTypeService.findAll();
            List<ArticleBean> articleBeanList = articleService.findAll(page);
            PageInfo<ArticleBean> pageInfo = new PageInfo<>(articleBeanList);

            request.getSession().setAttribute("articleBeanList",pageInfo);
            request.getSession().setAttribute("userBean",userBean);
            request.getSession().setAttribute("typeBeanList",typeBeanList);
            request.getSession().setAttribute("loginMessage",userBean.getXbloUsername());
            return "admin/admin";
        }else {
            showMessageDialog(null,"登录失败，请重新登录","标题",JOptionPane.ERROR_MESSAGE);
            return "admin/login/login";
        }
    }
    @RequestMapping("tologin")
    public String tologin(HttpServletRequest request){
        XbloUserBean userBean = (XbloUserBean) request.getSession().getAttribute("userBean");
        if (userBean ==null || userBean.equals("")) {
            return "admin/login/login";
        } else{
            return "forward:/pageInfo";}
    }
    @RequestMapping("loginout")
    public String loginout(HttpServletRequest request){
        Object[] options ={ "确定", "取消" };  //自定义按钮上的文字
        int res = JOptionPane.showOptionDialog(null, "确定退出当前账号？", "标题",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (res == JOptionPane.YES_OPTION)
        {
            request.getSession().removeAttribute("userBean");
            System.out.println("成功退出登录");
            return "admin/front/FrontIndex";
        } else {
            System.out.println("取消注销");
            return null;
        }
    }
    @RequestMapping("registered")
    public String registered(XbloUserBean xbloUserBean){
        Integer integer = xbloUserService.addUser(xbloUserBean);
        return "forward:/ruoyu";
    }
}

