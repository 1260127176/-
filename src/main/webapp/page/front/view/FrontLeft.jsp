<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ruoyu.bean.*" %>
<%@ page import="com.github.pagehelper.PageInfo" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>博客-侧栏</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=path%>/static/layuiadmin/layui/css/layui.css"  media="all">
    <link href="${pageContext.request.contextPath}/static/css/default.css" rel="stylesheet"
          type="text/css" media="screen"/>
    <style>
        .img{
            width: 20px;
            height: 20px;
        }
    </style>
</head>
<body>
<div id="sidebar">
    <ul>
        <li id="search">
            <h2>搜索</h2>
            <!-- Google站内搜索开始 -->
            <form method="get" action="/article/selectAll">
                <fieldset><input type=text name=q>
                    <input type=submit name=btnG value="搜索">
                </fieldset>
            </form>
            <!-- Google 站内搜索结束 -->
        </li>
    </ul>

    <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="demo" style="margin-right: 10px;width: 270px">
        <li class="layui-nav-item layui-nav-itemed">
            <a href="javascript:;">分类</a>
            <dl class="layui-nav-child">
                    <%
                    List<ArticleTypeBean> articleTypeList =(List<ArticleTypeBean>) session.getAttribute("typeBeanList");
                    List<ArticleBean> articleList = (List<ArticleBean>) session.getAttribute("articleBeanList");

                    if (articleTypeList.size() > 0) {
                        for (int i = 0; i < articleTypeList.size(); i++) {
                            ArticleTypeBean articleTypeBean = (ArticleTypeBean) articleTypeList.get(i);
                %>
                <dd>
                    <form action="<%=path%>/type/selectByTypeId" method="post">
                        <input type="hidden" name="articleTypeId" value="<%=articleTypeBean.getArticleTypeId()%>">
                        <input type="submit" class="button" value="<%=articleTypeBean.getArticleTypeName()%>" />

                    <%
                        int size=0;
                        for (ArticleBean articleBean : articleList) {
                            if (articleBean.getArticleTypeId()==articleTypeBean.getArticleTypeId()){
                                size += 1;
                            }
                        }
                    %>
                    (<%=size%>)
                    </form>
                </dd>
                    <%
                        }
                    }
                %>
        </li>


        <li class="layui-nav-item">
            <a href="javascript:;">排行</a>
            <dl class="layui-nav-child">
                <%
                    List<ArticleBean> articleListTop = (List<ArticleBean>) session.getAttribute("top10");
                    if (articleListTop.size() > 0) {
                        for (int i = 0; i < articleListTop.size(); i++) {
                            ArticleBean articleBean = (ArticleBean) articleListTop
                                    .get(i);
                %>
                <dd>
                    <form  action="/article/findById/find">
                        <input type="hidden" name="articleId" value="<%=articleBean.getArticleId()%>">
                        <input type="submit" class="button" value="<%=articleBean.getArticleTitle()%>" />(<%=articleBean.getVisitCount()%>)
                    </form>
                </dd>
                <%
                        }
                    }
                %>
            </dl>
        </li>

        <li class="layui-nav-item">
            <a href="javascript:;">链接</a>
            <dl class="layui-nav-child">
                <%
                    List<XbloLinkBean> xbloLinkList = (List<XbloLinkBean>) session.getAttribute("linkBeanList");
                    if (xbloLinkList.size() > 0) {
                        for (int i = 0; i < xbloLinkList.size(); i++) {
                            XbloLinkBean xbloLinkBean = (XbloLinkBean) xbloLinkList
                                    .get(i);
                %>
                <dd>
                    <a href="http://<%=xbloLinkBean.getXbloLinkUrl()%>"
                       target=_blank><%=xbloLinkBean.getXbloLinkName()%>
                    </a>
                </dd>
                <%
                        }
                    }
                %>
            </dl>
        </li>
    </ul>

</div>
</body>
</html>
<%
    session.removeAttribute("top10");
    session.removeAttribute("typeBeanList");
    session.removeAttribute("articleBeanList");
    session.removeAttribute("linkBeanList");
%>
<script src="<%=path%>/static/layuiadmin/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use('element', function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

        //监听导航点击
        element.on('nav(demo)', function(elem){
            //console.log(elem)
            layer.msg(elem.text());
        });
    });
</script>