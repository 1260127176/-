package com.ruoyu.util;//package com.ruoyu.util;
//
//import com.github.pagehelper.PageHelper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Properties;
//
///**
// * Project_Name:ruoyu
// * ClassName:PageHelperConfig
// * Package:com.ruoyu.util
// *
// * @Date:2020/2/25 14:02
// * Author:1260127176@qq.com
// * author:12601
// */
//@Configuration
//public class PageHelperConfig {
//    @Bean
//    public PageHelper getPageHelper(){
//        PageHelper pageHelper=new PageHelper();
//        Properties properties=new Properties();
//        properties.setProperty("helperDialect","mysql");
//        properties.setProperty("reasonable","true");
//        properties.setProperty("supportMethodsArguments","true");
//        properties.setProperty("params","count=countSql");
//        pageHelper.setProperties(properties);
//        return pageHelper;
//    }
//}
