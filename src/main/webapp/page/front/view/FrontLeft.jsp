<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ruoyu.bean.*" %>

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
    <link href="${pageContext.request.contextPath}/static/css/default.css" rel="stylesheet"
          type="text/css" media="screen"/>
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
            <!-- Google 站内搜索结束 --></li>
        <li>
            <h2>排行</h2>
            <ul>
                <%
                    List<ArticleBean> articleListTop = (List<ArticleBean>) session.getAttribute("top10");
                    if (articleListTop.size() > 0) {
                        for (int i = 0; i < articleListTop.size(); i++) {
                            ArticleBean articleBean = (ArticleBean) articleListTop
                                    .get(i);
                %>
                <li><a  href="/article/findById/find">
                    <input type="hidden" name="articleId" value="<%=articleBean.getArticleId()%>">
                    <%=articleBean.getArticleTitle()%></a>(<%=articleBean.getVisitCount()%>)
                </li>
                <%
                        }
                    }
                %>
            </ul>
        </li>
        <li>
            <h2>分类</h2>
            <ul>
                <%
                    List<ArticleTypeBean> articleTypeList = (List<ArticleTypeBean>) session.getAttribute("typeBeanList");
                    List<ArticleBean> articleList = (List<ArticleBean>) session.getAttribute("articleBeanList");
                    if (articleTypeList.size() > 0) {
                        for (int i = 0; i < articleTypeList.size(); i++) {
                            ArticleTypeBean articleTypeBean = (ArticleTypeBean) articleTypeList.get(i);
                %>
                <li><a
                        href="/type/selectByTypeId" methods="post">
                    <input type="hidden" name="articleTypeId" value="<%=articleTypeBean.getArticleTypeId()%>">

                    <%=articleTypeBean.getArticleTypeName()%>
                </a>
                    <%
                        int size=0;
                        for (ArticleBean articleBean : articleList) {
                            if (articleBean.getArticleTypeId()==articleTypeBean.getArticleTypeId()){
                                size += 1;
                            }
                        }
                    %>
                    (<%=size%>)
                </li>
                <%
                        }
                    }
                %>
            </ul>
        </li>
        <li>
            <h2>链接</h2>
            <ul>
                <%
                    List<XbloLinkBean> xbloLinkList = (List<XbloLinkBean>) session.getAttribute("linkBeanList");
                    if (xbloLinkList.size() > 0) {
                        for (int i = 0; i < xbloLinkList.size(); i++) {
                            XbloLinkBean xbloLinkBean = (XbloLinkBean) xbloLinkList
                                    .get(i);
                %>
                <li><a href="http://<%=xbloLinkBean.getXbloLinkUrl()%>"
                       target=_blank><%=xbloLinkBean.getXbloLinkName()%>
                </a></li>
                <%
                        }
                    }
                %>
            </ul>
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