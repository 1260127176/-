<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ruoyu.bean.*" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.ruoyu.mapper.ArticleTypeMapper" %>
<%@ page import="com.github.pagehelper.PageInfo" %>

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
    <title>类别管理</title>
    <link href="<%=basePath%>/static/css/style.css" rel="stylesheet"
          type="text/css"/>
</head>

<%
    PageInfo<ArticleTypeBean> allArticleType = (PageInfo<ArticleTypeBean>) session.getAttribute("typeBeanList");
    System.out.println("-------文章类型PageInfo:"+allArticleType);
%>

<body id="page">
<h2>类别列表</h2>

    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <form action="/type/insert" method="post">
            <tr>
                <th>类别：</th>
                <td><input type="text" name="articleTypeName" size="20" /></td>
            </tr>
            <tr>
                <th>描述：</th>
                <td><input type="text" name="articleTypeDesc" size="50" /></td>
            </tr>
            <tr>
                <th></th>
                <td><input type="submit" class="bt" value="新增类别"/></td>
            </tr>
        </form>
        <%
            for (int i=0;i<allArticleType.getSize();i++){
        %>

        <tr>
            <th>类别：</th>
            <td><%=allArticleType.getList().get(i).getArticleTypeName() %>
            </td>
        </tr>
        <tr>
            <th>描述：</th>
            <td><%=allArticleType.getList().get(i).getArticleTypeDesc()%>
            </td>
        </tr>
        <tr>
            <th>操作：</th>
            <td>
                <form action="/type/select" style="float: left">
                    <input type="hidden" name="articletypeid" value="<%=allArticleType.getList().get(i).getArticleTypeId()%>"/>
                    <button type="submit" class="easyui-linkbutton">修改</button>
                </form>
                 <form action="/type/delete" style="float: left">
                    <input type="hidden" name="articletypeid" value="<%=allArticleType.getList().get(i).getArticleTypeId()%>"/>
                    <button type="submit" class="easyui-linkbutton">删除</button>
                 </form>
            </td>
        </tr>
        <%
            }
        %>

    </table>

<div style="padding:10px;text-align: center" >
    <c:if test="<%=!allArticleType.isIsFirstPage()%>">
        <form action="/type/selectAll" style="float: left ; align-content: center" method="post">
            <input type="hidden" name="src" value="admin/articleType/mgrArticleType"/>
            <input type="hidden" name="pageNum" value="<%=allArticleType.getNavigateFirstPage()%>"/>
            <input type="image" src="<%=basePath%>/static/images/first.png" onClick="document.name.submit()" />&nbsp;&nbsp;|
        </form>
    </c:if>

    <c:if test="<%=allArticleType.isHasPreviousPage()%>">
        <form action="/type/selectAll" style="float: left;align-content: center" method="post">
            <input type="hidden" name="src" value="admin/articleType/mgrArticleType"/>
            <input type="hidden" name="pageNum" value="<%=allArticleType.getPrePage()%>"/>
            <input type="image" src="<%=basePath%>/static/images/pre.png" onclick="document.name.submit()" />&nbsp;&nbsp;|
        </form>
    </c:if>

    <c:forEach items="${typeBeanList.navigatepageNums}" var="num">
        <form action="/type/selectAll" style="float: left;color:${num eq pageInfo.pageNum?"red":""};align-content: center " method="post">
            <input type="hidden" name="src" value="admin/articleType/mgrArticleType"/>
            <input type="hidden" name="pageNum" value="${num}"/>
            <input type="submit" value="${num}"/>&nbsp;&nbsp;|
        </form>
    </c:forEach>

    <c:if test="<%=allArticleType.isHasNextPage()%>">
        <form action="/type/selectAll" style="float: left;align-content: center" method="post">
            <input type="hidden" name="src" value="admin/articleType/mgrArticleType"/>
            <input type="hidden" name="pageNum" value="<%=allArticleType.getNextPage()%>"/>
            <input type="image" src="<%=basePath%>/static/images/next.png" onclick="document.name.submit()"/>&nbsp;&nbsp;|
        </form>
    </c:if>
    <c:if test="<%=!allArticleType.isIsLastPage()%>">
        <form action="/type/selectAll" style="float: left;align-content: center" method="post">
            <input type="hidden" name="src" value="admin/articleType/mgrArticleType"/>
            <input type="hidden" name="pageNum" value="<%=allArticleType.getNavigateLastPage()%>"/>
            <input type="image" src="<%=basePath%>/static/images/last.png" onclick="document.name.submit()"/>
        </form>
    </c:if>
    当前第<%=allArticleType.getPageNum()%>/<%=allArticleType.getPages()%>
</div>
<%
    session.removeAttribute("typeBeanList");

%>
</body>
</html>
