package com.ruoyu.service;

import com.ruoyu.bean.XbloUserBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Project_Name:springcloud-sonsul-demo
 * ClassName:XbloUserMapper
 * Package:com.ruoyu.mapper
 *
 * @Date:2020/2/11 16:12
 * Author:1260127176@qq.com
 * author:12601
 */
public interface XbloUserService {
    //添加
    Integer addUser(XbloUserBean xbloUserBean);
    //删除
    Integer delUser(@Param("xbloUserId") Integer xbloUserId);
    //修改
    Integer updUser(XbloUserBean xbloUserBean);
    //查询一个
    XbloUserBean findById(@Param("xbloUserId") Integer xbloUserId);
    //查询全部
    List<XbloUserBean> findAll();
    List<XbloUserBean> findAll(Integer pageNum);
    XbloUserBean login(String xbloUsername, String xbloPassword);

    XbloUserBean findByAuthor(@Param("createUserId") Integer id);
}
