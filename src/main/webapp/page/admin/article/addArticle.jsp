<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ruoyu.bean.*" %>
<%@ page import="com.ruoyu.mapper.ArticleTypeMapper" %>

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
    <title>文章发表</title>
    <link href="<%=basePath%>/static/css/style.css" rel="stylesheet"
          type="text/css"/>
</head>

<%
    XbloUserBean validXbloUserBean = (XbloUserBean) session.getAttribute("userBean");
    List<ArticleTypeBean> typeBeanList = (List<ArticleTypeBean>) session.getAttribute("typeBeanList");
    session.removeAttribute("typeBeanList");

%>

<body id="page">
<h2>发表文章</h2>
<form action="/article/insert"  method="post">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <input type="hidden" name="createUserId"
               value="<%=validXbloUserBean.getXbloUserId()%>" />
        <tr>
            <th>标题：</th>
            <td><input type="text" name="articleTitle" size="50" /></td>
        </tr>
        <tr>
            <th>文章类型：</th>
            <td>[<select name="articleTypeId">
                <%
                    if (typeBeanList.size() > 0) {
                        for (int i = 0; i < typeBeanList.size(); i++) {
                            ArticleTypeBean articleTypeBean = typeBeanList.get(i);
                %>
                <option value="<%=articleTypeBean.getArticleTypeId()%>"><%=articleTypeBean.getArticleTypeName()%>
                </option>
                <%
                        }
                    }
                %>
            </select>]
            </td>
        </tr>
        <tr>
            <th>简介：</th>
            <td><textarea name="articleSummary" rows="5" cols="80"></textarea></td>
        </tr>
        <tr>
            <th>内容：</th>
            <td><textarea name="articleContent" rows="20" cols="80"></textarea></td>
        </tr>

        <tr>
            <th>&nbsp;</th>
            <td><input type="submit" class="bt" value="提交" /></td>
        </tr>
    </table>
</form>
</body>
</html>
