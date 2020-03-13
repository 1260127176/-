<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.ruoyu.bean.*" %>
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
    <title>用户管理界面</title>
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/jquery-easyui-1.7.0/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/jquery-easyui-1.7.0/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/static/jquery-easyui-1.7.0/demo/demo.css">
    <script type="text/script" src="<%=basePath%>/static/jquery-easyui-1.7.0/jquery.min.js"></script>
    <script type="text/script" src="<%=basePath%>/static/jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
</head>

<%
    PageInfo<XbloUserBean> allUser = (PageInfo<XbloUserBean>) session.getAttribute("userBeanList");
%>

<body id="page">
<h2>用户管理</h2>

    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <%
            for (int i=0;i<allUser.getSize();i++){
        %>

        <tr>
            <th>用户名：</th>
            <td><%=allUser.getList().get(i).getXbloUsername()%>
            </td>
        </tr>
        <tr>
            <th>操作：</th>
            <td>
                <form action="/user/select/find" style="float: left">
                    <input type="hidden" name="xbloUserId" value="<%=allUser.getList().get(i).getXbloUserId()%>"/>
                    <button type="submit" class="easyui-linkbutton">修改密码</button>
                </form>
                <form action="/user/delete" style="float: left">
                    <input type="hidden" name="xbloUserId" value="<%=allUser.getList().get(i).getXbloUserId()%>"/>
                    <button type="submit" class="easyui-linkbutton">删除用户</button>
                </form>
            </td>
        </tr>
        <%
            }
        %>

    </table>
<div style="padding:10px;text-align: center" >
    <c:if test="<%=!allUser.isIsFirstPage()%>">
        <form action="/user/selectAll" style="float: left ; align-content: center" method="post">
            <input type="hidden" name="pageNum" value="<%=allUser.getNavigateFirstPage()%>"/>
            <input type="image" src="<%=basePath%>/static/images/first.png" onClick="document.name.submit()" />&nbsp;&nbsp;|
        </form>
    </c:if>

    <c:if test="<%=allUser.isHasPreviousPage()%>">
        <form action="/user/selectAll" style="float: left;align-content: center" method="post">
            <input type="hidden" name="pageNum" value="<%=allUser.getPrePage()%>"/>
            <input type="image" src="<%=basePath%>/static/images/pre.png" onclick="document.name.submit()" />&nbsp;&nbsp;|
        </form>
    </c:if>

    <c:forEach items="${userBeanList.navigatepageNums}" var="num">
        <form action="/user/selectAll" style="float: left;color:${num eq pageInfo.pageNum?"red":""};align-content: center " method="post">
            <input type="hidden" name="pageNum" value="${num}"/>
            <input type="submit" value="${num}"/>&nbsp;&nbsp;|
        </form>
    </c:forEach>

    <c:if test="<%=allUser.isHasNextPage()%>">
        <form action="/user/selectAll" style="float: left;align-content: center" method="post">
            <input type="hidden" name="pageNum" value="<%=allUser.getNextPage()%>"/>
            <input type="image" src="<%=basePath%>/static/images/next.png" onclick="document.name.submit()"/>&nbsp;&nbsp;|
        </form>
    </c:if>
    <c:if test="<%=!allUser.isIsLastPage()%>">
        <form action="/user/selectAll" style="float: left;align-content: center" method="post">
            <input type="hidden" name="pageNum" value="<%=allUser.getNavigateLastPage()%>"/>
            <input type="image" src="<%=basePath%>/static/images/last.png" onclick="document.name.submit()"/>
        </form>
    </c:if>
    当前第<%=allUser.getPageNum()%>/<%=allUser.getPages()%>
</div>
<%
    session.removeAttribute("userBeanList");
%>
</body>
</html>
