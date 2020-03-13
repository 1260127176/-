<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.github.pagehelper.PageInfo" %>
<%@ page import="com.ruoyu.bean.ArticleMessage" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>管理界面</title>
    <link href="<%=basePath%>/static/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/jquery-easyui-1.7.0/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/jquery-easyui-1.7.0/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/jquery-easyui-1.7.0/demo/demo.css">
    <script type="text/javascript" src="<%=basePath%>/static/jquery-easyui-1.7.0/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/static/jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
</head>

<%
//    List<Map<String,Object>> articleMessaege = (List<Map<String, Object>>) session.getAttribute("articleMessaege");
    PageInfo<ArticleMessage> pageInfo = (PageInfo<ArticleMessage>) session.getAttribute("pageInfo");
//    session.removeAttribute("articleMessaege");
//    System.out.println(pages);
%>

<body id="page">
<h2>文章操作</h2>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <%
        for (int i=0;i<pageInfo.getSize();i++) {
            String articleTypeName = (String) pageInfo.getList().get(i).getArticleTypeName();
            if (articleTypeName == null || articleTypeName.equals(""))
                articleTypeName = "未分类";
    %>
    <tr>
        <th>标题：</th>
        <td>[<%=pageInfo.getList().get(i).getArticleTypeName()%>]
            <%=pageInfo.getList().get(i).getArticleTitle()%>
        </td>
    </tr>
    <tr>
        <th >简介：</th>
        <td><textarea readonly="readonly"><%=pageInfo.getList().get(i).getArticleSummary()%></textarea></td>
    </tr>
    <tr>
        <th>操作：</th>
        <td>
            <form action="/article/findById/find" style="float: left">
            <input type="hidden" name="articleId" value="<%=pageInfo.getList().get(i).getArticleId()%>"/>
<%--                <a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true">查看</a>--%>
                <button type="submit" class="easyui-linkbutton">查看</button>
            </form>

            <form action="/article/findById/upd" style="float: left">
                <input type="hidden" name="articleId" value="<%=pageInfo.getList().get(i).getArticleId()%>"/>
<%--                <a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true">修改</a>--%>
                <button type="submit" class="easyui-linkbutton">修改</button>
            </form>

            <form action="/article/delete" style="float: left">
                <input type="hidden" name="articleId" value="<%=pageInfo.getList().get(i).getArticleId()%>"/>
<%--                <a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true">删除</a>--%>
                <button type="submit" class="easyui-linkbutton">删除</button>
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>
<div style="padding:10px;text-align: center" >
    <c:if test="<%=!pageInfo.isIsFirstPage()%>">
        <form action="/article/pageInto" style="float: left ; align-content: center" method="post">
            <input type="hidden" name="src" value="admin/article/mgrArticle"/>
            <input type="hidden" name="pageNum" value="<%=pageInfo.getNavigateFirstPage()%>"/>
            <input type="image" src="<%=basePath%>/static/images/first.png" onClick="document.name.submit()" />&nbsp;&nbsp;|
        </form>
    </c:if>

    <c:if test="<%=pageInfo.isHasPreviousPage()%>">
    <form action="/article/pageInto" style="float: left;align-content: center" method="post">
        <input type="hidden" name="src" value="admin/article/mgrArticle"/>
        <input type="hidden" name="pageNum" value="<%=pageInfo.getPrePage()%>"/>
        <input type="image" src="<%=basePath%>/static/images/pre.png" onclick="document.name.submit()" />&nbsp;&nbsp;|
    </form>
    </c:if>

    <c:forEach items="${pageInfo.navigatepageNums}" var="num">
        <form action="/article/pageInto" style="float: left;color:${num eq pageInfo.pageNum?"red":""};align-content: center " method="post">
            <input type="hidden" name="src" value="admin/article/mgrArticle"/>
            <input type="hidden" name="pageNum" value="${num}"/>
            <input type="submit" value="${num}"/>&nbsp;&nbsp;|
        </form>
    </c:forEach>

    <c:if test="<%=pageInfo.isHasNextPage()%>">
    <form action="/article/pageInto" style="float: left;align-content: center" method="post">
        <input type="hidden" name="src" value="admin/article/mgrArticle"/>
        <input type="hidden" name="pageNum" value="<%=pageInfo.getNextPage()%>"/>
        <input type="image" src="<%=basePath%>/static/images/next.png" onclick="document.name.submit()"/>&nbsp;&nbsp;|
    </form>
    </c:if>
    <c:if test="<%=!pageInfo.isIsLastPage()%>">
        <form action="/article/pageInto" style="float: left;align-content: center" method="post">
            <input type="hidden" name="src" value="admin/article/mgrArticle"/>
            <input type="hidden" name="pageNum" value="<%=pageInfo.getNavigateLastPage()%>"/>
            <input type="image" src="<%=basePath%>/static/images/last.png" onclick="document.name.submit()"/>
        </form>
    </c:if>
    当前第<%=pageInfo.getPageNum()%>/<%=pageInfo.getPages()%>
</div>

</body>
</html>