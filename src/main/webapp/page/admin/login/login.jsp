<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%
        String path = request.getContextPath();
    %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>登录界面</title>
    <style type="text/css">
        body{
            background: url("<%=path%>/static/images/background.jpg"); repeat:no-repeat;background-size: 100% 100%;background-attachment: fixed;

        }
    </style>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.7.0/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.7.0/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.7.0/demo/demo.css">
    <script type="text/javascript"  src="${pageContext.request.contextPath}/static/jquery-easyui-1.7.0/jquery.min.js"></script>
    <script type="text/javascript"  src="${pageContext.request.contextPath}/static/jquery-easyui-1.7.0/jquery.easyui.min.js"></script>

</head>

<body>
<div style="align-content:center;width: 100%;height: 50px;margin-left: 860px;margin-top: 100px;">
    <strong style="font-size: 30px;color: #e8e8e8">欢迎登陆</strong>
    <strong style="font-size: 45px;font-family: 新細明體-ExtB;color: #DD691D">若鱼博客</strong>
</div>
<div style="position: absolute;left: 830px;top: 270px;">
    <div style="margin:auto"></div>
<div class="easyui-panel" title="登录" style="width:100%;max-width:400px;padding:30px 60px;margin: auto">
    <form action="/user/login" id="ff" method="post">
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="xbloUsername" style="width:100%" data-options="label:'用户名:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input  type="password" class="easyui-textbox" name="xbloPassword" style="width:100%" data-options="label:'密  码:',required:true">
        </div>

        <div style="text-align:center;padding:5px 0">
            <input href="/user/login" type="submit" class="easyui-linkbutton" style="width:80px" value="登录" />
            <input type="reset" class="easyui-linkbutton" onclick="clearForm()" style="width:80px" value="重置" />
        </div>
    </form>
</div>
</div>
<script>
    function submitForm(){
        $('#ff').form('submit');
    }
    function clearForm(){
        $('#ff').form('clear');
    }
</script>
</body>
</html>

