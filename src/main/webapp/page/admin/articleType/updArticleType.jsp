<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.ruoyu.bean.*" %>

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
    <link href="<%=basePath%>/static/css/style.css" rel="stylesheet"
          type="text/css"/>
</head>

<%
    ArticleTypeBean articleTypeBean = (ArticleTypeBean) session.getAttribute("typeBean");
    System.out.println("获取到的类型信息:"+articleTypeBean);
    session.removeAttribute("typeBean");
%>

<body id="page">
<h2>修改文章类别</h2>
<form action="/type/update" method="post">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <input type="hidden" name="articleTypeId"  value="<%=articleTypeBean.getArticleTypeId()%>" />
        <tr>
            <th>类别：</th>
            <td><input type="text" name="articleTypeName" size="50"
                       value="<%=articleTypeBean.getArticleTypeName()%>" /></td>
        </tr>
        <tr>
            <th>描述：</th>
            <td><input type="text" name="articleTypeDesc" size="50"
                       value="<%=articleTypeBean.getArticleTypeDesc()%>" /></td>
        </tr>

        <tr>
            <th>&nbsp;</th>
            <td><input type="submit" class="bt" value="提交" /></td>
        </tr>
    </table>
</form>
</body>
</html>
