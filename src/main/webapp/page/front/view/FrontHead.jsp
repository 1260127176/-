<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java"  pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>博客-页头</title>
    <link href="${pageContext.request.contextPath}/static/css/default.css" rel="stylesheet" type="text/css" media="screen"/>
</head>
<body>
<!-- start header -->
<div id="feeds"><a href="/user/tologin" id="entries-rss">登录 (RSS)</a> <b>&nbsp;|&nbsp;</b> <a href="#" id="comments-rss">
    (RSS)</a></div>
<hr/>
<div id="logo">
    <h1><a href="/ruoyu">若鱼Blog</a></h1>
    <p><a href="http://blog.csdn.net/t0nsha" target=_blank>珍惜每一天</a></p>
</div>
<hr/>
<!-- end header -->
<!-- start menu -->
<div id="menu">
    <ul>
        <li class="active"><a href="/ruoyu">首页</a></li>
        <%
        if (session.getAttribute("loginName")==null ||session.getAttribute("loginName").equals("")) {
        %>
        <li><a href="/user/tologin">管理
        </a></li>
        <%
            }
        %>
    </ul>
</div>
<!-- end menu -->
</body>
</html>