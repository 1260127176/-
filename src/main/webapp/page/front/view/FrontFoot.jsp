<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java"  pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>博客-页尾</title>
    <link href="${pageContext.request.contextPath}/static/css/default.css" rel="stylesheet" type="text/css" media="screen"/>
</head>
<body>
<div id="footer">
    <p id="legal">&copy;2020 ruoyu blog</p>
    <p id="legal">若鱼博客<a href="https://blog.csdn.net/weixin_45014184">ruoyu</a></p>
    <p id="links">Powered by <a href="http://blog.csdn.net/t0nsha/">t0nsha</a></p>
</div>
</body>
</html>