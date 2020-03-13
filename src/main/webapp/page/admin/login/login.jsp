<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>登录界面</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.7.0/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.7.0/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.7.0/demo/demo.css">
    <script type="text/javascript"  src="${pageContext.request.contextPath}/static/jquery-easyui-1.7.0/jquery.min.js"></script>
    <script type="text/javascript"  src="${pageContext.request.contextPath}/static/jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
</head>

<body style="background-image: url("${pageContext.request.contextPath}/static/images/login.jpg")">
<div style="width: 600px;height: 100px;top: 300px;left: 150px;margin: 0 auto">
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

