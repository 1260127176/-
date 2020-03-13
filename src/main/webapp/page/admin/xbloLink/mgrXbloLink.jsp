<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ruoyu.bean.*" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.ruoyu.mapper.XbloLinkMapper" %>
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
    <title>链接管理界面</title>
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet"
          type="text/css"/>
</head>

<%
    PageInfo<XbloLinkBean> allArticleLink= (PageInfo<XbloLinkBean>) session.getAttribute("linkBeanList");
%>

<body id="page">
<h2>链接列表</h2>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <form action="/link/insert" method="post">
        <tr>
            <th>名称：</th>
            <td><input type="text" name="xbloLinkName" size="20" /></td>
        </tr>
        <tr>
            <th>URL：</th>
            <td><input type="text" name="xbloLinkUrl" size="50" /></td>
        </tr>
        <tr>
            <th></th>
            <td><input type="submit" class="bt" value="新增链接"/></td>
        </tr>
</form>

        <%
            for (int i=0;i<allArticleLink.getSize();i++){
        %>

        <tr>
            <th>名称：</th>
            <td><%=allArticleLink.getList().get(i).getXbloLinkName()%>
            </td>
        </tr>
        <tr>
            <th>URL：</th>
            <td><%=allArticleLink.getList().get(i).getXbloLinkUrl()%>
            </td>
        </tr>
        <tr>
            <th>操作：</th>
            <td><form action="/link/select" method="post" style="float:left;">
                <input type="hidden" name="xbloLinkId" value="<%=allArticleLink.getList().get(i).getXbloLinkId()%>"/>
                <button type="submit" class="easyui-linkbutton">修改</button>

            </form>
                 <form action="/link/delete" style="float:left;">
                    <input type="hidden" name="xbloLinkId" value="<%=allArticleLink.getList().get(i).getXbloLinkId()%>"/>
                    <button type="submit" class="easyui-linkbutton">删除</button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>

<div style="padding:10px;text-align: center" >
        <c:if test="<%=!allArticleLink.isIsFirstPage()%>">
            <form action="/link/selectAll" style="float: left ; align-content: center" method="post">
                <input type="hidden" name="pageNum" value="<%=allArticleLink.getNavigateFirstPage()%>"/>
                <input type="image" src="<%=basePath%>/static/images/first.png" onClick="document.name.submit()" />&nbsp;&nbsp;|
            </form>
        </c:if>

        <c:if test="<%=allArticleLink.isHasPreviousPage()%>">
            <form action="/link/selectAll" style="float: left;align-content: center" method="post">
                <input type="hidden" name="pageNum" value="<%=allArticleLink.getPrePage()%>"/>
                <input type="image" src="<%=basePath%>/static/images/pre.png" onclick="document.name.submit()" />&nbsp;&nbsp;|
            </form>
        </c:if>

        <c:forEach items="${linkBeanList.navigatepageNums}" var="num">
            <form action="/link/selectAll" style="float: left;color:${num eq pageInfo.pageNum?"red":""};align-content: center " method="post">
                <input type="hidden" name="pageNum" value="${num}"/>
                <c:if test="${num!=linkBeanList.pageNum}">
                <input type="submit" value="${num}"/>&nbsp;&nbsp;|</c:if>
            </form>
        </c:forEach>

        <c:if test="<%=allArticleLink.isHasNextPage()%>">
            <form action="/link/selectAll" style="float: left;align-content: center" method="post">
                <input type="hidden" name="pageNum" value="<%=allArticleLink.getNextPage()%>"/>
                <input type="image" src="<%=basePath%>/static/images/next.png" onclick="document.name.submit()"/>&nbsp;&nbsp;|
            </form>
        </c:if>
        <c:if test="<%=!allArticleLink.isIsLastPage()%>">
            <form action="/link/selectAll" style="float: left;align-content: center" method="post">
                <input type="hidden" name="pageNum" value="<%=allArticleLink.getNavigateLastPage()%>"/>
                <input type="image" src="<%=basePath%>/static/images/last.png" onclick="document.name.submit()"/>
            </form>
        </c:if>
        当前第<%=allArticleLink.getPageNum()%>/<%=allArticleLink.getPages()%>
    </div>
<%
    session.removeAttribute("linkBeanList");
%>
</body>
</html>
<script>
    document.getElementById("btn").disabled = true;
</script>