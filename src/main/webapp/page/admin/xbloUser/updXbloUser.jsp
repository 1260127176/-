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
    <title>密码管理界面</title>
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet"
          type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/js.js"></script>
</head>

<%
    XbloUserBean xbloUserBean = (XbloUserBean) session.getAttribute("userBean");
    session.removeAttribute("userBean");
    XbloUserBean validXbloUserBean = (XbloUserBean) session.getAttribute("loginUser");
%>

<body id="page">
<h2>修改密码</h2>
<form action="/user/update" method="post">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <input type="hidden" name="xbloUserId"  value="<%=xbloUserBean.getXbloUserId()%>" />
        <tr>
            <th>用户名：</th>
            <td><input type="text" name="xbloUsername" size="50"
                       readonly="readonly" value="<%=xbloUserBean.getXbloUsername()%>" /></td>
        </tr>

        <tr>
            <th>新密码：</th>
            <td><input type="password" id="xbloPassword1" name="xbloPassword" size="50" /></td>
        </tr>
        <tr>
            <th>重复新密码：</th>
            <td><input type="password" id="xbloPassword2" name="xbloPasswordEq" size="50" /></td>
        </tr>
        <tr>
        <th>手  机：</th>
        <td><input type="text" name="phone" size="50"  value="<%=xbloUserBean.getPhone()%>" /></td>
        </tr>
        <tr>
            <th>&nbsp;</th>
            <td><input type="submit" id="btn" class="bt" value="提交" onclick="return chkPwdEql()"/></td>
        </tr>
    </table>
</form>
</body>
</html>
