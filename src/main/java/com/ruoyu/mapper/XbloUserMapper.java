package com.ruoyu.mapper;

import com.ruoyu.bean.ArticleBean;
import com.ruoyu.bean.XbloUserBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
@Component
@Mapper
public interface XbloUserMapper {
    //添加
    @Insert("INSERT INTO XbloUser(xbloUsername, xbloPassword,phone) VALUE(#{xbloUsername},#{xbloPassword},#{phone})")
    Integer addUser(XbloUserBean xbloUserBean);
    //删除
    @Delete("delete from XbloUser where xbloUserId =#{xbloUserId}")
    Integer delUser(@Param("xbloUserId") Integer xbloUserId);
    //修改
    @Update("update XbloUser set  xbloUsername = #{xbloUsername}, xbloPassword = #{xbloPassword}  WHERE xbloUserId = #{xbloUserId}")
    Integer updUser(XbloUserBean xbloUserBean);
    //查询一个
    @Select("select * from XbloUser where xbloUserId =#{xbloUserId}")
    XbloUserBean findById(@Param("xbloUserId") Integer xbloUserId);
    //查询全部
    @Select("select * from XbloUser")
    List<XbloUserBean> findAll();

    @Select("select * from XbloUser where xbloUsername=#{xbloUsername} AND xbloPassword=#{xbloPassword}")
    XbloUserBean login(String xbloUsername, String xbloPassword);
    //根据作者查询
    @Select("select * from XbloUser where xbloUserId=#{createUserId}")
    XbloUserBean findByAuthor(@Param("createUserId") Integer id);
}
