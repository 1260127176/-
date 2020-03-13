<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.ruoyu.bean.*" %>
<%@ page import="com.github.pagehelper.PageInfo" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
    out.print(basePath);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>站点信息</title>
    <link href="<%=basePath%>/static/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/jquery-easyui-1.7.0/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/jquery-easyui-1.7.0/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/jquery-easyui-1.7.0/demo/demo.css">
    <script type="text/javascript" src="<%=basePath%>/static/jquery-easyui-1.7.0/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/static/jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
</head>

<%
    PageInfo<ArticleBean> articleBeanList = (PageInfo<ArticleBean>) session.getAttribute("articleBeanList");
    List<ArticleTypeBean> typeBeanList= (List<ArticleTypeBean>) session.getAttribute("typeBeanList");

    int searchArticleCount = 0;
    if (articleBeanList == null){
        searchArticleCount = 0;
    } else{
        searchArticleCount = articleBeanList.getSize();
    }
%>

<body id="page">
<h2>站点信息</h2>

<form action="/pageInfo" method="post">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <th>站点名称：</th>
            <td>若鱼Blog</td>
        </tr>
        <tr>
            <th>文章数量：</th>
            <td><strong><%=searchArticleCount%></strong>
                篇包含在<strong><%=typeBeanList.size()%></strong>个分类中
            </td>
        </tr>
        <tr>
            <th>搜索结果：</th>
            <td><%=searchArticleCount%>篇</td>
        </tr>
        <tr>
            <th>关键字：</th>
            <td>
                <input type="text" name="keyword" size="60"/>
                <input type="hidden" name="src" value="admin/siteInfo"/>
                <input type="submit" class="bt" value="搜索文章"/>
            </td>
        </tr>
    </table>
</form>

        <%
            if (searchArticleCount > 0) {
                for (int i=0;i<articleBeanList.getSize();i++){
        %>
<form action="/article/findById/find" method="post">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <th height="50" width="140">标题：</th>
            <td>
                    <input type="hidden" name="articleId" value="<%=articleBeanList.getList().get(i).getArticleId()%>"/>
                    <input type="submit" value="<%=articleBeanList.getList().get(i).getArticleTitle()%>" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true" />
            </td>
        </tr>

        <tr>
            <th height="50" width="140">简介：</th>
            <td><%=articleBeanList.getList().get(i).getArticleSummary()%>
            </td>
        </tr>
    </table>
</form>
        <%
                }
            }
        %>
<div style="padding:10px;text-align: center" >
    <c:if test="<%=!articleBeanList.isIsFirstPage()%>">
        <form action="/article/selectAll" style="float: left ; align-content: center" method="post">
            <input type="hidden" name="src" value="admin/siteInfo"/>
            <input type="hidden" name="pageNum" value="<%=articleBeanList.getNavigateFirstPage()%>"/>
            <input type="image" src="<%=basePath%>/static/images/first.png" onClick="document.name.submit()" />&nbsp;&nbsp;|
        </form>
    </c:if>

    <c:if test="<%=articleBeanList.isHasPreviousPage()%>">
        <form action="/article/selectAll" style="float: left;align-content: center" method="post">
            <input type="hidden" name="src" value="admin/siteInfo"/>
            <input type="hidden" name="pageNum" value="<%=articleBeanList.getPrePage()%>"/>
            <input type="image" src="<%=basePath%>/static/images/pre.png" onclick="document.name.submit()" />&nbsp;&nbsp;|
        </form>
    </c:if>

    <c:forEach items="${articleBeanList.navigatepageNums}" var="num">
        <form action="/article/selectAll" style="float: left;color:${num eq pageInfo.pageNum?"red":""};align-content: center " method="post">
            <input type="hidden" name="src" value="admin/siteInfo"/>
            <input type="hidden" name="pageNum" value="${num}"/>
            <input type="submit" value="${num}"/>&nbsp;&nbsp;|
        </form>
    </c:forEach>

    <c:if test="<%=articleBeanList.isHasNextPage()%>">
        <form action="/article/selectAll" style="float: left;align-content: center" method="post">
            <input type="hidden" name="src" value="admin/siteInfo"/>
            <input type="hidden" name="pageNum" value="<%=articleBeanList.getNextPage()%>"/>
            <input type="image" src="<%=basePath%>/static/images/next.png" onclick="document.name.submit()"/>&nbsp;&nbsp;|
        </form>
    </c:if>
    <c:if test="<%=!articleBeanList.isIsLastPage()%>">
        <form action="/article/selectAll" style="float: left;align-content: center" method="post">
            <input type="hidden" name="src" value="admin/siteInfo"/>
            <input type="hidden" name="pageNum" value="<%=articleBeanList.getNavigateLastPage()%>"/>
            <input type="image" src="<%=basePath%>/static/images/last.png" onclick="document.name.submit()"/>
        </form>
    </c:if>
    当前第<%=articleBeanList.getPageNum()%>/<%=articleBeanList.getPages()%>
</div>
<%
    session.removeAttribute("articleBeanList");
    session.removeAttribute("typeBeanList");
%>
</body>
</html>
