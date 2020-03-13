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
    <title>文章修改</title>
    <link href="../../../static/css/style.css" rel="stylesheet"
          type="text/css"/>
</head>

<%
    XbloUserBean xbloUser = (XbloUserBean) session.getAttribute("userBean");
    ArticleBean articleBean = (ArticleBean) session.getAttribute("articleBean");
    session.removeAttribute("articleBean");
%>

<body id="page">
<h2>修改文章</h2>
<form action="/article/update"
      method="post">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <input type="hidden" name="updArticle" value="Y" />
        <input type="hidden" name="articleTypeId"
               value="<%=articleBean.getArticleTypeId()%>" />
        <input type="hidden" name="createUserId"
               value="<%=articleBean.getCreateUserId()%>" />
        <input type="hidden" name="articleId"
               value="<%=articleBean.getArticleId()%>" />
        <input type="hidden" name="createDate"
               value="<%=articleBean.getCreateDate()%>" />
        <input type="hidden" name="visitCount"
               value="<%=articleBean.getVisitCount()%>" />
        <input type="hidden" name="createUserId"
               value="<%=articleBean.getCreateUserId()%>" />
        <tr>
            <th>标题：</th>
            <td><input type="text" name="articleTitle" size="50"
                       value="<%=articleBean.getArticleTitle()%>" />类型
            </td>
        </tr>
        <tr>
            <th>简介：</th>
            <td><textarea name="articleSummary" rows="5" cols="80"><%=articleBean.getArticleSummary()%></textarea></td>
        </tr>
        <tr>
            <th>内容：</th>
            <td><textarea name="articleContent" rows="20" cols="80"><%=articleBean.getArticleContent()%>
			</textarea></td>
        </tr>

        <tr>
            <th>&nbsp;</th>
            <td><input type="submit" class="bt" value="提交" /></td>
        </tr>
    </table>
</form>
</body>
</html>
