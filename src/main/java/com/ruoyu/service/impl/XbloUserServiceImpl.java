package com.ruoyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.ruoyu.bean.XbloUserBean;
import com.ruoyu.mapper.XbloUserMapper;
import com.ruoyu.service.XbloUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Project_Name:springcloud-sonsul-demo
 * ClassName:XbloUserServiceImpl
 * Package:com.ruoyu.service.impl
 *
 * @Date:2020/2/16 19:52
 * Author:1260127176@qq.com
 * author:12601
 */
@Service
public class XbloUserServiceImpl implements XbloUserService {
    @Autowired
    private XbloUserMapper xbloUserMapper;

    @Override
    public Integer addUser(XbloUserBean xbloUserBean) {
        Integer integer = xbloUserMapper.addUser(xbloUserBean);
        return integer;
    }

    @Override
    public Integer delUser(Integer xbloUserId) {
        Integer integer = xbloUserMapper.delUser(xbloUserId);
        return integer;
    }

    @Override
    public Integer updUser(XbloUserBean xbloUserBean) {
        Integer integer = xbloUserMapper.updUser(xbloUserBean);
        return integer;
    }

    @Override
    public XbloUserBean findById(Integer xbloUserId) {
        XbloUserBean userBean = xbloUserMapper.findById(xbloUserId);
        return userBean;
    }

    @Override
    public List<XbloUserBean> findAll() {
        List<XbloUserBean> userBeanList = xbloUserMapper.findAll();
        return userBeanList;
    }

    @Override
    public List<XbloUserBean> findAll(Integer pageNum) {
        PageHelper.startPage(pageNum,6);
        List<XbloUserBean> userBeanList = xbloUserMapper.findAll();
        return userBeanList;
    }

    @Override
    public XbloUserBean login(String xbloUsername, String xbloPassword) {
        XbloUserBean userBean = xbloUserMapper.login(xbloUsername, xbloPassword);
        return userBean;
    }

    @Override
    public XbloUserBean findByAuthor(Integer id) {
        XbloUserBean userBean = xbloUserMapper.findByAuthor(id);
        return userBean;
    }


}
